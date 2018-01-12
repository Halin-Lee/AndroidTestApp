package me.halin.crypto;

/**
 * 加密示例
 * Created by halin on 1/5/18.
 */

public class EncryptSample {


    static {
        System.loadLibrary("HLCrypto");
    }

    public native String md5(String text);
    public native String base64(String text);
    public native String aes(String src,String key,String vector);
    public native String rc4(String text);



}
