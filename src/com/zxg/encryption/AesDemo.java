package com.zxg.encryption;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

/**
 * 加解密输入输出均为字节数组
 * https://www.jianshu.com/p/a3af4049c8ca
 */
public class AesDemo {

    public static final String transformation = "AES/CBC/PKCS5Padding";
    public static final String algorithm = "AES";
    //初始向量 加密参数 长度必须为16字节 (字节数组长度必须为16)
    public static final byte[] initializeVector = "2018101800112299".getBytes();

    public void testAesEncrypt() {
        try {
            Cipher cipher = Cipher.getInstance(transformation);
            //使用KeyGenerator生成key，参数与获取cipher对象的algorithm必须相同
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            //指定生成的密钥长度为128位(CBC模式下指定为128位)
            keyGenerator.init(128);
            Key key = keyGenerator.generateKey();
            //这里输出的为16(1字节等于8位)
            System.out.println("key length:" + key.getEncoded().length);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] bytes = new byte[0];
            bytes = cipher.doFinal("helloworld".getBytes());
            System.out.println("AES加密： " + Base64.getEncoder().encodeToString(bytes));

            //解密 用同样的key去解密
            //由于AES加密在CBC模式下是需要有一个初始向量数组byte[] initializeVector ,
            // 而解密的时候也需要同样的初始向量，因此需要使用加密时的参数初始化解密的cipher，否则会出错
            byte[] initializeVector = cipher.getIV();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initializeVector);
            cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
            //上面三步操作可以用此操作代替   cipher.init(Cipher.DECRYPT_MODE, key, cipher.getParameters());
            bytes = cipher.doFinal(bytes);
            System.out.println("AES解密： " + new String(bytes));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testAesEncrypt(String input, String keyStr) {
        try {
            Cipher cipher = Cipher.getInstance(transformation);
            SecretKey key = new SecretKeySpec(keyStr.getBytes(), algorithm);
            //初始化加密器 参数：模式(加密/解密) 秘钥 参数描述
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(initializeVector));
            byte[] bytes = cipher.doFinal(input.getBytes());
            System.out.println("AES加密： " + Base64.getEncoder().encodeToString(bytes));

            //解密
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(initializeVector));
            bytes = cipher.doFinal(bytes);
            System.out.println("AES解密： " + new String(bytes));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        AesDemo aesDemo = new AesDemo();
        //使用CBC模式key长度必须为128位(16个字符(1字节等于8位))
        byte[] bytes = "2018101800112291".getBytes();
        System.out.println("UUID Length:" + bytes.length);
        aesDemo.testAesEncrypt("sax lady",bytes.toString());
        aesDemo.testAesEncrypt();
    }

}
