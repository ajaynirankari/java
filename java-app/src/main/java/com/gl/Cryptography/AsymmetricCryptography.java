package com.gl.Cryptography;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HexFormat;

public class AsymmetricCryptography {
    public static KeyPair generateRSAKKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(3072);
        return keyPairGenerator.generateKeyPair();
    }
    public static byte[] encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
    }

    public static String decrypt(byte[] cipherText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(cipherText);
        return new String(result);
    }

    public static void main(String[] args) throws Exception {

        KeyPair keypair = generateRSAKKeyPair();

        String plainText = "This is a cryptography test message";
        System.out.println( "The original message is: " + plainText);

        byte[] cipherText = encrypt(plainText, keypair.getPublic());
        System.out.println("The encrypted text is: " + HexFormat.of().formatHex(cipherText));

        String decryptedText = decrypt(cipherText, keypair.getPrivate());
        System.out.println("The decrypted text is: " + decryptedText);
    }

}
