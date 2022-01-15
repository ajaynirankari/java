package com.gl.JavaTrainingSession01;

public class Sample {
    public static void main(String[] args) {
        System.out.println("Hello work");
        // Array -

        int x;
        // x = 90;
        //System.out.println(x);

        int age1 = 15;
        int age2 = 25;
        int age3 = 45;
        int age5 = 35;

        // Declare
        // Initialize
        // Use/Access array element

        int age[] = new int[4];

        System.out.println(age.length);
        age[0] = 20;
        age[1] = 30;
        age[2] = 90;
        System.out.println(age[2]);

        int[] age_ = {2, 3, 4, 5, 15, 8, 9};
        System.out.println(age_.length);
        System.out.println(age_[4]);

        int bArray[] = new int[5];
        for (int i = 0; i < bArray.length; i++) {
            bArray[i] = i + 100;

        }
        //bArray1=new int[2];
        for (int i = 0; i < bArray.length; i++) {
            System.out.println(bArray[i]);
        }

        for (int t : bArray) {
            System.out.println(t);
        }

        String bArray0[] = new String[5];
        for (int i = 0; i < bArray0.length; i++) {
            //bArray1[i] = String.valueOf(i + 100);
            bArray0[i] = "" + (i + 100);

        }
        //bArray1=new String[2];
        for (int i = 0; i < bArray0.length; i++) {
            System.out.println(bArray0[i]);
        }

        for (String t : bArray0) {
            System.out.println(t);
        }

        Book bArray1[] = new Book[5];
        for (int i = 0; i < bArray1.length; i++) {
            bArray1[i] = new Book("Book_" + i);
        }
        for (int i = 0; i < bArray1.length; i++) {
            System.out.println(bArray1[i]);
        }
        for (Book t : bArray1) {
            System.out.println(t);
        }

    }
}

class Book {
    private String name;

    public Book(String nam) {
        name = nam;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}