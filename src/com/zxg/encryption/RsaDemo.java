package com.zxg.encryption;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RsaDemo {

    public void testRsa(){
        try {
            //获取cipher对象
            Cipher cipher = Cipher.getInstance("RSA");
            //通过KeyPairGenerator来生成公钥和私钥
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            PublicKey publicKey = keyPair.getPublic();//公钥
            PrivateKey privateKey = keyPair.getPrivate();//私钥

            /*加密*/
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] bytes = cipher.doFinal("come baby".getBytes());
            final String encryptText = Base64.getEncoder().encodeToString(bytes);
            System.out.println("RSA公钥加密：" + encryptText);

            /*解密*/
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            bytes = cipher.doFinal(Base64.getDecoder().decode(encryptText));
            System.out.println("RSA解密：" + new String(bytes));
        }catch (Exception e){

        }
    }

    public static void main(String[] args) {
        RsaDemo demo = new RsaDemo();
        demo.testRsa();
    }
}
