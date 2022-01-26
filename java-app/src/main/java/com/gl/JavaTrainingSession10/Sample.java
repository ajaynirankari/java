package com.gl.JavaTrainingSession10;

import com.gl.JavaTrainingSession10.books.Book;

import java.io.File;

public class Sample {
    static Book book;

    public static void main(String[] args) {
        //Book book1 = new Book();
        //System.out.println("book1.name = " + book1.name);
        //Book book;
        System.out.println("book = " + book);

        //book = new Book();
        book = new Book("Book1", "AuthorName1", 345);
        System.out.println("book = " + book);

        //System.out.println("book.name = " + book.name);
        System.out.println("book = " + book.getName());

        //System.out.println("book.price = " + book.price);
        System.out.println("book.price = " + book.getPrice());

        //book.price=-90;
        book.setPrice(90);
        System.out.println("book.price = " + book.getPrice());

        String s = "Hello";
        s.length();

        File file;
    }
}