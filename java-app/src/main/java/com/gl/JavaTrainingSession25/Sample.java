package com.gl.JavaTrainingSession25;

public class Sample {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        boolean r = a > b;
        System.out.println("r = " + r);

        String output;
        if (r) {
            output = "GT";
        } else {
            output = "LT";
        }
        System.out.println("output = " + output);

        output = (a > b) ? "GT" : "LT";
        System.out.println("output = " + output);

        int x = (a > b) ? 50 : 90;
        System.out.println("x = " + x);

        double d = (a > b) ? 50.8 : 90.9;
        System.out.println("d = " + d);

        int number = 30;
        int remainder = number % 3;
        System.out.println("remainder = " + remainder);

        String text = remainder == 0 ? "car" : "truck";
        System.out.println("text = " + text);

        text = remainder != 0 ? "car" : "truck";
        System.out.println("text = " + text);

        text = number % 3 != 0 ? "car" : "truck";
        System.out.println("text = " + text);

        if ((number % 3) != 0) {
            text = "car";
        } else {
            text = "truck";
        }
        System.out.println("text = " + text);
    }
}
