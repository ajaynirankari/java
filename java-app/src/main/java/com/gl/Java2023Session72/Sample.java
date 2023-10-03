package com.gl.Java2023Session72;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class Sample {
    public static void main(String[] args) throws Exception {
        // Off-line data

        // Read data from On-line
        URL url = new URL("https://docs.oracle.com/en/java/javase/21/docs/api/");
        // URL class is Deprecated since = JDK 20
        // Recommended to use URI.toURL()

        URI uri = URI.create("https://docs.oracle.com/en/java/javase/21/docs/api/");
        try (InputStream inputStream = uri.toURL().openStream();
             OutputStream outputStream = Files.newOutputStream(Path.of("D:\\oracle.html"))) {
            int read = inputStream.read();
            while (read != -1) {
                System.out.print((char) read);
                outputStream.write(read);
                read = inputStream.read();
            }
        }

        System.out.println("uri.toURL().getHost() = " + uri.toURL().getHost());
        System.out.println("uri.toURL().getPort() = " + uri.toURL().getPort());
        System.out.println("uri.toURL().getPath() = " + uri.toURL().getPath());
        System.out.println("uri.toURL().getProtocol() = " + uri.toURL().getProtocol());
        System.out.println("uri.toURL().getContent() = " + uri.toURL().getContent());

        URLConnection urlConnection = uri.toURL().openConnection();
        try (InputStream inputStream = urlConnection.getInputStream()) {
            int read = inputStream.read();
            while (read != -1) {
                System.out.print((char) read);
                read = inputStream.read();
            }
        }

        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        try (HttpClient client = HttpClient.newHttpClient()) {
            String responseBody = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            System.out.println(responseBody);
        }

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpResponse<InputStream> inputStreamHttpResponse = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            try (InputStream inputStream = inputStreamHttpResponse.body()) {
                int read = inputStream.read();
                while (read != -1) {
                    System.out.print((char) read);
                    read = inputStream.read();
                }
            }
        }
    }
}
