package com.gl.util;

public class EncryptDecrypt {
    public static void main(String[] args) {
        String password = "password";
        System.out.println(STR."Plain Password: \{password}");
        String encryptedPassword = encrypt(password);
        System.out.println(STR."Encrypted Password: \{encryptedPassword}");
        String decryptedPassword = decrypt(encryptedPassword);
        System.out.println(STR."Decrypted Password: \{decryptedPassword}");
    }

    private static String decrypt(String encryptedPassword) {
        StringBuilder decryptedPassword = new StringBuilder();
        for (int i = 0; i < encryptedPassword.length(); i++) {
            decryptedPassword.append((char) (encryptedPassword.charAt(i) - 1));
        }
        return decryptedPassword.toString();
    }

    private static String encrypt(String password) {
        StringBuilder encryptedPassword = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            encryptedPassword.append((char) (password.charAt(i) + 1));
        }
        return encryptedPassword.toString();
    }
}

