#include <jni.h>
#include <string>
#include <openssl/md5.h>
#include <openssl/rc4.h>
#include <android/log.h>
#include <openssl/aes.h>
#include <openssl/rsa.h>
#include <string.h>

#include "base64.c"

bool is_utf8(const char *string) {
    if (!string)
        return 0;

    const unsigned char *bytes = (const unsigned char *) string;
    while (*bytes) {
        if ((// ASCII
                // use bytes[0] <= 0x7F to allow ASCII control characters
                bytes[0] == 0x09 ||
                bytes[0] == 0x0A ||
                bytes[0] == 0x0D ||
                (0x20 <= bytes[0] && bytes[0] <= 0x7E)
        )
                ) {
            bytes += 1;
            continue;
        }

        if ((// non-overlong 2-byte
                (0xC2 <= bytes[0] && bytes[0] <= 0xDF) &&
                (0x80 <= bytes[1] && bytes[1] <= 0xBF)
        )
                ) {
            bytes += 2;
            continue;
        }

        if ((// excluding overlongs
                    bytes[0] == 0xE0 &&
                    (0xA0 <= bytes[1] && bytes[1] <= 0xBF) &&
                    (0x80 <= bytes[2] && bytes[2] <= 0xBF)
            ) ||
            (// straight 3-byte
                    ((0xE1 <= bytes[0] && bytes[0] <= 0xEC) ||
                     bytes[0] == 0xEE ||
                     bytes[0] == 0xEF) &&
                    (0x80 <= bytes[1] && bytes[1] <= 0xBF) &&
                    (0x80 <= bytes[2] && bytes[2] <= 0xBF)
            ) ||
            (// excluding surrogates
                    bytes[0] == 0xED &&
                    (0x80 <= bytes[1] && bytes[1] <= 0x9F) &&
                    (0x80 <= bytes[2] && bytes[2] <= 0xBF)
            )
                ) {
            bytes += 3;
            continue;
        }

        if ((// planes 1-3
                    bytes[0] == 0xF0 &&
                    (0x90 <= bytes[1] && bytes[1] <= 0xBF) &&
                    (0x80 <= bytes[2] && bytes[2] <= 0xBF) &&
                    (0x80 <= bytes[3] && bytes[3] <= 0xBF)
            ) ||
            (// planes 4-15
                    (0xF1 <= bytes[0] && bytes[0] <= 0xF3) &&
                    (0x80 <= bytes[1] && bytes[1] <= 0xBF) &&
                    (0x80 <= bytes[2] && bytes[2] <= 0xBF) &&
                    (0x80 <= bytes[3] && bytes[3] <= 0xBF)
            ) ||
            (// plane 16
                    bytes[0] == 0xF4 &&
                    (0x80 <= bytes[1] && bytes[1] <= 0x8F) &&
                    (0x80 <= bytes[2] && bytes[2] <= 0xBF) &&
                    (0x80 <= bytes[3] && bytes[3] <= 0xBF)
            )
                ) {
            bytes += 4;
            continue;
        }

        return 0;
    }

    return 1;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_me_halin_crypto_EncryptSample_md5(
        JNIEnv *env,
        jobject /* this */,
        jstring srcjStr) {


    const char *unicodeChar = env->GetStringUTFChars(srcjStr, NULL);
    size_t unicodeCharLength = env->GetStringLength(srcjStr);

    unsigned char md[MD5_DIGEST_LENGTH];
    int i;
    char buf[33] = {'\0'};
    MD5((unsigned char *) unicodeChar, unicodeCharLength, (unsigned char *) &md);
    for (i = 0; i < 16; i++) {
        sprintf(&buf[i * 2], "%02x", md[i]);
    }
    env->ReleaseStringUTFChars(srcjStr, unicodeChar);

    __android_log_print(ANDROID_LOG_ERROR, "TAG", "%s %d", buf, strlen(buf));
    if (is_utf8(buf)) {
        return env->NewStringUTF(buf);
    } else {
        return NULL;
    }
}


extern "C"
JNIEXPORT jstring JNICALL
Java_me_halin_crypto_EncryptSample_base64(
        JNIEnv *env,
        jobject /* this */,
        jstring srcJStr) {

    const char *srcChar = env->GetStringUTFChars(srcJStr, NULL);
    unsigned long srcSize = strlen(srcChar);

    int outLength = Base64encode_len((int) srcSize);
    char *encoded = new char[outLength];
    Base64encode(encoded, srcChar, (int) srcSize);

    env->ReleaseStringUTFChars(srcJStr, srcChar);
    if (is_utf8(encoded)) {
        return env->NewStringUTF(encoded);
    } else {
        return NULL;
    }
}



extern "C"
JNIEXPORT jstring JNICALL
Java_me_halin_crypto_DecryptSample_base64(
        JNIEnv *env,
        jobject /* this */,
        jstring srcJStr) {

    const char *srcChar = env->GetStringUTFChars(srcJStr, NULL);

    int outLength = Base64decode_len(srcChar);
    char *decoded = new char[outLength];
    Base64decode(decoded, srcChar);


    env->ReleaseStringUTFChars(srcJStr, srcChar);

    if (is_utf8(decoded)) {
        return env->NewStringUTF(decoded);
    } else {
        return NULL;
    }
}



extern "C"
JNIEXPORT jstring JNICALL
Java_me_halin_crypto_EncryptSample_aes(
        JNIEnv *env,
        jobject /* this */,
        jstring srcJStr,
        jstring keyJStr,
        jstring vectorJStr) {

    if (srcJStr == NULL || keyJStr == NULL || vectorJStr == NULL) {
        return NULL;
    }

    // 构造加密Key
    AES_KEY enc_key;
    memset(&enc_key, 0, sizeof(AES_KEY));
    const char *keyChar = env->GetStringUTFChars(keyJStr, NULL);
    if (AES_set_encrypt_key(reinterpret_cast<const unsigned char *>(keyChar), 128, &enc_key)) {
        // 密钥构造出错，返回空
        env->ReleaseStringUTFChars(keyJStr, keyChar);
        return NULL;
    }
    env->ReleaseStringUTFChars(keyJStr, keyChar);


    const char *srcChar = env->GetStringUTFChars(srcJStr, NULL);
    unsigned long srcSize = strlen(srcChar);

    // 设置padding
    const size_t enc_in_size = ((srcSize + AES_BLOCK_SIZE) / AES_BLOCK_SIZE) * AES_BLOCK_SIZE;
    unsigned char *enc_in = new unsigned char[enc_in_size];
    int padding = AES_BLOCK_SIZE - (int) srcSize % AES_BLOCK_SIZE;   //需要补充的位数
    memset(enc_in, padding, enc_in_size);
    memcpy(enc_in, srcChar, srcSize);
    env->ReleaseStringUTFChars(srcJStr, srcChar);
    __android_log_print(ANDROID_LOG_ERROR, "OpenSSL", "In:%s", (char *) enc_in);

    // 初始化向量
    const char *vectorChar = env->GetStringUTFChars(vectorJStr, NULL);
    unsigned long vectorSize = strlen(vectorChar);
    unsigned char *vector = new unsigned char[vectorSize];
    memcpy(vector, vectorChar, vectorSize);
    env->ReleaseStringUTFChars(vectorJStr, vectorChar);

    // 加密
    unsigned char *enc_out = new unsigned char[enc_in_size];
    AES_cbc_encrypt(enc_in, enc_out, enc_in_size, &enc_key, vector, AES_ENCRYPT);


    // Base64转换
    int outLength = Base64encode_len(enc_in_size);
    char encoded[outLength];
    Base64encode(encoded, (char *) enc_out, (int) enc_in_size);


    __android_log_print(ANDROID_LOG_ERROR, "OpenSSL", "Out %s", encoded);

    env->ReleaseStringUTFChars(srcJStr, srcChar);
    if (is_utf8(encoded)) {
        return env->NewStringUTF(encoded);
    } else {
        return NULL;
    }
}

extern "C"
JNIEXPORT jstring JNICALL
Java_me_halin_crypto_EncryptSample_rsa(
        JNIEnv *env,
        jobject /* this */,
        jstring srcJStr,
        jstring keyJStr,
        jstring vectorJStr) {

//    RSA *keypair = RSA
    return NULL;
}




extern "C"
JNIEXPORT jstring JNICALL
Java_me_halin_crypto_DecryptSample_aes(
        JNIEnv *env,
        jobject /* this */,
        jstring srcJStr,
        jstring keyJStr,
        jstring vectorJStr) {

    if (srcJStr == NULL || keyJStr == NULL || vectorJStr == NULL) {
        return NULL;
    }

    // Base64解码
    const char *srcChar = env->GetStringUTFChars(srcJStr, NULL);
    int outLength = Base64decode_len(srcChar);
    char *decoded = new char[outLength];
    outLength = Base64decode(decoded, srcChar);
    env->ReleaseStringUTFChars(srcJStr, srcChar);

    if (outLength % AES_BLOCK_SIZE != 0) {
        return NULL;
    }


    // 构造解密Key
    AES_KEY dec_key;
    memset(&dec_key, 0, sizeof(AES_KEY));
    const char *keyChar = env->GetStringUTFChars(keyJStr, NULL);
    if (AES_set_decrypt_key(reinterpret_cast<const unsigned char *>(keyChar), 128, &dec_key)) {
        // 密钥构造出错，返回空
        env->ReleaseStringUTFChars(keyJStr, keyChar);
        return NULL;
    }
    env->ReleaseStringUTFChars(keyJStr, keyChar);


    // 初始化向量
    const char *vectorChar = env->GetStringUTFChars(vectorJStr, NULL);
    unsigned long vectorSize = strlen(vectorChar);
    unsigned char *dec_vector = new unsigned char[vectorSize];
    memcpy(dec_vector, vectorChar, vectorSize);
    env->ReleaseStringUTFChars(vectorJStr, vectorChar);

    unsigned char *dec_out = new unsigned char[outLength];
    AES_cbc_encrypt((const unsigned char *) decoded, dec_out, outLength, &dec_key, dec_vector,
                    AES_DECRYPT);


    // 删除Padding
    int padding = dec_out[outLength - 1];  //padding位数
    for (int i = 0; i < padding; i++) {
        if (dec_out[outLength - 1 - i] != padding) {
            // Padding计算错误，返回空
            return NULL;
        }
    }
//
    size_t outputLength = outLength - padding + 1;
    char *output = new char[outputLength];
    memset(output, 0, outputLength);
    memcpy(output, dec_out, outputLength - 1);

    __android_log_print(ANDROID_LOG_ERROR, "OpenSSL", "Out:%s %d %d", output, strlen(output),
                        outputLength);
    if (is_utf8(output)) {
        return env->NewStringUTF(output);
    } else {
        return NULL;
    }
}













extern "C"
JNIEXPORT jstring JNICALL
Java_me_halin_crypto_EncryptSample_rc4(
        JNIEnv *env,
        jobject /* this */,
        jstring srcjStr) {
    std::string hello = "Hello from C++";


    char code[64] = {0};
    int codelen = sizeof(code);
    memcpy(code, "123456", 6);

    unsigned char *outbuffer = new unsigned char[codelen];

    //用指定密钥对一段内存进行加密，结果放在outbuffer中
    RC4_KEY rc4_key;
    RC4_set_key(&rc4_key, 7, (unsigned char *) "123");
    RC4(&rc4_key, codelen, (unsigned char *) code, outbuffer);

    jstring test1;
    std::string str(reinterpret_cast<const char *>(outbuffer));
    test1 = env->NewStringUTF(str.c_str());
    //__android_log_print(ANDROID_LOG_ERROR, "OpenSSL", "%s", str);
    return test1;
}



