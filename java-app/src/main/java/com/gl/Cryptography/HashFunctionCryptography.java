package com.gl.Cryptography;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Arrays;
import java.util.HexFormat;

public class HashFunctionCryptography {

    public static KeyPair generateRSAKKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(3072);
        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] generateDigitalSignature(byte[] plainText, PrivateKey privateKey) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageHash = md.digest(plainText);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(messageHash);
    }

    public static boolean verify(byte[] plainText, byte[] digitalSignature, PublicKey publicKey) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedMessage = md.digest(plainText);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] decryptedMessageHash = cipher.doFinal(digitalSignature);

        return Arrays.equals(decryptedMessageHash, hashedMessage);
    }

    public static void main(String[] args) throws Exception {

        KeyPair keypair = generateRSAKKeyPair();

        String plainText = "This is a cryptography test message";
        System.out.println("The original message is: " + plainText);

        byte[] digitalSignature = generateDigitalSignature(plainText.getBytes(), keypair.getPrivate());
        System.out.println("Signature Value: " + HexFormat.of().formatHex(digitalSignature));

        System.out.println("Verification: " + verify(plainText.getBytes(), digitalSignature, keypair.getPublic()));
    }

}
