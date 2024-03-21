package com.gl.OpenSSL;

public class Sample {
    public static void main(String[] args){
        try {
            // Define the path where the certificate and key will be stored
            String certPath = "certificate.crt";
            String keyPath = "privatekey.key";

            // Generate the self-signed certificate
            String command = "openssl req -x509 -newkey rsa:4096 -keyout " + keyPath + " -out " + certPath + " -days  365 -nodes -subj '/CN=localhost'";
            String result = OpenSSLUtil.executeCommand(command);

            System.out.println("Self-signed certificate generated successfully.");
            System.out.println("Certificate Path: " + certPath);
            System.out.println("Private Key Path: " + keyPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
