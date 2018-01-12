package me.halin.crypto;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import me.halin.crypto.databinding.ActivityCryptoBinding;

public class CryptoActivity extends AppCompatActivity {

    public static final String TAG = CryptoActivity.class.getName();

    private ActivityCryptoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_crypto);
        binding.setContext(this);
//        binding.setSrcStr("MDAwMDAwMDAwMDAwMDAwMA==");    //Base64解密
        binding.setSrcStr("0000000000000000");
        binding.setSrcStr("FMze2Dc9VVCYrOuzpdKdfbQQHIHTRYlzkrdXxSohkL4=");  // AES解密
//        binding.setSrcStr("087mbMmEWgm1HmY8s99R/DaIQt9oLGClYW5y3a4EoiMc=");  // AES解密

        //RSA 私钥解密 密文
//        binding.setSrcStr("M+1fXrAAlISi18tiSCTiyk0n64C8sYXgXG2qIbvZ1sV3urtP7RRPfiaKwed1G5DVTGLTXech0AQqFxDDytc+1omsrP259gP2S5+i5GnjmRm+f0LHV6RaGlaxfrEyLP/Kao4p8Jzp5V/hHfAjVGq/z3qgcvKwhvWNEdfokTvYZ+9oQkDi0bNZjujvsbci+oOV+TBVIEWG5QhoZ1ntiv6svZ7JgHThHtVDTgTWPbhIZxIHfDNJWR+OF46cnEJVg4HQYQo41wVPRGfrUIH8SD7liMo896zWOifcQmrwUEpSCAkeXLgeIKO7JEkYHOEWfZMPG/u6vEJ5jEQoHGSDoNEM0w==");

//        binding.setSrcStr("UZKNKYIUMRplm1wI5mCjTWW+lhauKAfkAMEep+/PBWW6jgPNQW22u9Yor3QuwPQcma3yHakNwd7B" +
//                "ykUbNdro5hAgUY6SwaR4uyi0C+F3GXkkX7fCZ1iEIV1pMeTyTbVQt0/HxulJnt/dTM13BbbU01Lm" +
//                "9EGeYRWT6t+oboMPMDAMf5Slen4m53MBKG6+n2/SY8+KlVVU9N9qccPk2beoBsGX6cPgswXKsjCD" +
//                "KIfmlyAqOlYJnFg2kdXvchs4UrnTNmUgDEsJTPCL9UZCKq7guO7K5k1jN8qxV1ddCLdrUIuznPW1" +
//                "4aJTyAY+yk8vCe9iwHTQtZisfc8Uc5VN4cD1Fw==");
//        binding.setKeyStr(Constant.RSA_PRIVATE_KEY);
        binding.setKeyStr("0000000000000000");
        binding.setVectorStr("0000000000000000");
        binding.encryptType.check(R.id.aes);

    }


    public void encrypt(View view) {

        String srcStr, keyStr, vectorStr;
        srcStr = binding.getSrcStr();
        if (srcStr == null) {
            srcStr = "";
        }

        keyStr = binding.getKeyStr();
        if (keyStr == null) {
            keyStr = "";
        }

        vectorStr = binding.getVectorStr();
        if (vectorStr == null) {
            vectorStr = "";
        }

        String result = null;
        switch (binding.encryptType.getCheckedRadioButtonId()) {
            case R.id.md5:
                result = new EncryptSample().md5(srcStr);
                break;
            case R.id.base64:
                result = new EncryptSample().base64(srcStr);
                break;
            case R.id.aes:


                // 得到基准结果
                String baseResult = new JavaCryptoSample().aesEncrypt(srcStr, keyStr, vectorStr);
                result = new EncryptSample().aes(srcStr, keyStr, vectorStr);

                if (!TextUtils.equals(baseResult, result)) {

                    Log.e(TAG, "baseResult:" + baseResult);
                    Toast.makeText(this, "加密结果不同 baseResult：" + baseResult + ", result:" + result, Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.rsa:
                result = new JavaCryptoSample().rsaEncrypt(srcStr, keyStr);
                break;
        }

        Log.e(TAG, "Result:" + result);
        binding.setResult(result);
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboardManager != null) {
            ClipData clipData = ClipData.newPlainText("text", result);
            clipboardManager.setPrimaryClip(clipData);
        }
    }


    public void decrypt(View view) {

        String srcStr, keyStr, vectorStr;
        srcStr = binding.getSrcStr();
        if (srcStr == null) {
            srcStr = "";
        }

        keyStr = binding.getKeyStr();
        if (keyStr == null) {
            keyStr = "";
        }

        vectorStr = binding.getVectorStr();
        if (vectorStr == null) {
            vectorStr = "";
        }

        String result = null;
        switch (binding.encryptType.getCheckedRadioButtonId()) {
            case R.id.md5:
                Toast.makeText(this, "md5不支持解密", Toast.LENGTH_SHORT).show();
                return;
            case R.id.base64:

                result = new DecryptSample().base64(srcStr);

                break;
            case R.id.aes:


                // 得到基准结果
                String baseResult = new JavaCryptoSample().aesDecrypt(srcStr, keyStr, vectorStr);
                result = new DecryptSample().aes(srcStr, keyStr, vectorStr);

                if (!TextUtils.equals(baseResult, result)) {

                    Log.e(TAG, "baseResult:" + baseResult);
                    Toast.makeText(this, "加密结果不同 baseResult：" + baseResult + ", result:" + result, Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.rsa:
                result = new JavaCryptoSample().rsaDecrypt(srcStr, keyStr);
                break;
        }

        Log.e(TAG, "Result:" + result);
        binding.setResult(result);
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboardManager != null) {
            ClipData clipData = ClipData.newPlainText("text", result);
            clipboardManager.setPrimaryClip(clipData);
        }
    }


}
