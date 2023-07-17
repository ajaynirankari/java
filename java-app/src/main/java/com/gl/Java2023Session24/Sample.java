package com.gl.Java2023Session24;

public class Sample {
    public static void main(String[] args) {

        // Switch have a two version
        // 1 - switch as statement
        // 2 - switch as expression

        System.out.println("OK");

        int x = 1;
        int expression = x * 3 + 4 - 1;

        test();
        int v1 = test1();

        int score = 71;
        if (score > 90) {
            System.out.println("Grade A");
        } else if (score > 70) {
            System.out.println("Grade B");
        } else if (score > 60) {
            System.out.println("Grade C");
        } else {
            System.out.println("Failed");
        }
        System.out.println("--------- Next Line");

        score = 70;
        switch (score) {
            case 90:
                System.out.println("Grade A");
                break;
            case 70:
                System.out.println("Grade B");
                break;
            case 60:
                System.out.println("Grade C");
                break;
            default:
                System.out.println("Failed");
        }
        System.out.println("--------- Next Line");


        score = 70;
        String val = switch (score) {
            case 90 ->
                    "Grade A";
            case 70 ->
                    "Grade B";
            case 60 ->
                    "Grade C";
            default ->
                    "Failed";
        };
        System.out.println("--------- Next Line val =  " + val);
    }

    static void test() {
        System.out.println("test");
    }

    static int test1() {
        System.out.println("test1");
        return 123;
    }
}
