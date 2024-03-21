package com.gl.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class EncryptDecryptAESUtil {

    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};

    public static String encrypt(String valueToEnc) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        return Base64.getEncoder().encodeToString(encValue);
    }

    public static String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = Base64.getDecoder().decode(encryptedValue);
        byte[] decValue = c.doFinal(decodedValue);
        return new String(decValue);
    }

    private static SecretKeySpec generateKey() {
        return new SecretKeySpec(keyValue, ALGORITHM);
    }

    public static void main(String[] args) throws Exception {
        String originalString = "This is a test string";
        String encryptedString = encrypt(originalString);
        String decryptedString = decrypt(encryptedString);

        System.out.println(STR."Original String: \{originalString}");
        System.out.println(STR."Encrypted String: \{encryptedString}");
        System.out.println(STR."Decrypted String: \{decryptedString}");
    }
}
