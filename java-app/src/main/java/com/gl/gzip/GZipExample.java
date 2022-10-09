package com.gl.gzip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZipExample {
    public static void main(String[] args) {

        // File path for compression
        Path source = Paths.get("request.json");
        Path target = Paths.get("request.json.gz");

        // File path for de-compression
        Path de_target = Paths.get("de_request.json");

        if (Files.notExists(source)) {
            System.err.printf("The path %s doesn't exist!", source);
            return;
        }
        try {
            GZipExample.compressGzip(source, target);
            System.out.println("compressGzip done ");
            GZipExample.decompressGzip(target, de_target);
            System.out.println("decompressGzip done ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // copy file (FileInputStream) to GZIPOutputStream
    public static void compressGzip(Path source, Path target) throws IOException {
        try (GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream(target.toFile()));
             FileInputStream fis = new FileInputStream(source.toFile())) {
            // copy file
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                gos.write(buffer, 0, len);
            }
        }
    }

    //  NIO Files.copy to copy a Path to GZIPOutputStream directly
    public static void compressGzipNio(Path source, Path target) throws IOException {
        try (GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream(target.toFile()))) {
            Files.copy(source, gos);
        }
    }

    //Compress a String to Gzip
    public static void compressStringToGzip(String data, Path target) throws IOException {
        try (GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream(target.toFile()))) {
            gos.write(data.getBytes(StandardCharsets.UTF_8));
        }
    }

    // Decompress a Gzip file – GZIPInputStream
    public static void decompressGzip(Path source, Path target) throws IOException {
        try (GZIPInputStream gis = new GZIPInputStream(new FileInputStream(source.toFile()));
             FileOutputStream fos = new FileOutputStream(target.toFile())) {
            // copy GZIPInputStream to FileOutputStream
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
                System.out.println("Decompress Data = \n" + new String(buffer));
            }

        }

    }
}
