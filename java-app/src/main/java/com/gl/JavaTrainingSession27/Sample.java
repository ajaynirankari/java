package com.gl.JavaTrainingSession27;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Sample {
    public static void main(String[] args) {

        //Test test = new Test(); // Not allowed, to create an object of abstract class
        Test test;
        test = new SubClass();
        test.show();

        Test.m1();

        Test test1 = Test.getInstance();
        test1.show();

        NumberFormat numberFormat;

        numberFormat = NumberFormat.getCurrencyInstance();

        System.out.println("numberFormat.getCurrency() = " + numberFormat.getCurrency());
        double d = 34.678;
        System.out.println("d = " + d);
        String formatValue = numberFormat.format(d);
        System.out.println("formatValue = " + formatValue);
        System.out.println("formatValue getCurrencyInstance = " + NumberFormat.getCurrencyInstance().format(d));
        System.out.println("formatValue getCurrencyInstance = " + NumberFormat.getInstance().format(d));

        NumberFormat nf = NumberFormat.getInstance(Locale.UK);
        System.out.println("nf.getCurrency() = " + nf.getCurrency());
        System.out.println("formatValue = " + nf.format(d));

        DateTimeFormatter dateTimeFormatter;

        String s = String.format("%2f", d);
        System.out.println("s = " + s);
        s = String.format("%.2f", d);
        System.out.println("s = " + s);
    }
}

abstract class Test {

    void show() {
        System.out.println("show()");
    }

    static void m1() {
        System.out.println("m1()");
    }

    static Test getInstance() {
        Test obj = new SubClass();
        return obj;
    }

}

class SubClass extends Test {

}
