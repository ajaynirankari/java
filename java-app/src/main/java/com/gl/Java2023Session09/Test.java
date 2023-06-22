package com.gl.Java2023Session09;

public class Test {
    public static void main(String[] args) {

        System.out.println(Sample.sumOfThreeNumbers(7,3,1));

        int rs = Sample.sumOfThreeNumbers(6,8,9);
        System.out.println("rs = " + rs);

        Sample sample = new Sample();
        int r = sample.sumOfThreeNumbers(6, 7, 8);
        System.out.println(r);

    }
}
