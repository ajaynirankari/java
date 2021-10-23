package com.gl.URLParserDemo;

import java.net.URL;

public class URLParserDemo {
    public static void main(String[] args) throws Exception {
        String urlStr = "http://example.com:80/docs/books/tutorial/index.html?name=networking@test=true#DOWNLOADING";
        System.out.println(urlStr);

        URL urlObject = new URL(urlStr);
        System.out.println("Protocol = "+urlObject.getProtocol());
        System.out.println("Authority = "+urlObject.getAuthority());
        System.out.println("Host = "+urlObject.getHost());
        System.out.println("Port = "+urlObject.getPort());
        System.out.println("Path = "+urlObject.getPath());
        System.out.println("Query = "+urlObject.getQuery());
        System.out.println("File = "+urlObject.getFile());
        System.out.println("Fragment = "+urlObject.getRef());
    }
}
