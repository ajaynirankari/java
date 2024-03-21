package com.gl.OpenSSL;

import java.io.*;

public class OpenSSLUtil {
    public static String executeCommand(String command) throws IOException, InterruptedException {
        StringBuilder output = new StringBuilder();
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }

        int exitVal = process.waitFor();
        if (exitVal ==  0) {
            return output.toString();
        } else {
            throw new IOException("Failed to execute command: " + command);
        }
    }
}
