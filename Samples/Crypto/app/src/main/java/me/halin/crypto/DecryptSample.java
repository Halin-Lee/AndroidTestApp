package me.halin.crypto;

/**
 * 解密示例
 * Created by halin on 1/10/18.
 */

public class DecryptSample {
    static {
        System.loadLibrary("HLCrypto");
    }

    public native String base64(String text);
    public native String aes(String src,String key,String vector);
}
