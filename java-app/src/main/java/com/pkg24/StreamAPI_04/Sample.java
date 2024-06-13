package com.pkg24.StreamAPI_04;

import java.util.List;

public class Sample {
    public static void main(String[] args) {

        MyUtil myUtilObject = new MyUtil();

        myUtilObject.myPrint(6);
        myUtilObject.myPrintStatic(7);
        MyUtil.myPrintStatic(7);

        System.out.println("-----------------------------------------");
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);

        integerList.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n + 10)
                .forEach(n -> System.out.println(n));

        System.out.println("-----------------------------------------");

        integerList.stream()
                .filter(myUtilObject::isEven)
                .map(myUtilObject::doubleIt)
                .forEach(myUtilObject::myPrint);

        System.out.println("-----------------------------------------");

        for (int i = 1; i < 9; i++) {
            System.out.println("Line 1 = " + i);
            if (i > 3) {
                System.out.println("Line 2 = " + i);
                System.out.println("Line 3 = " + i);
                System.out.println("Line 4 = " + i);
                System.out.println("Line 5 = " + i);
            }
        }
    }
}

class MyUtil {
    public void myPrint(int n) {
        System.out.println(n);
    }

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    public int doubleIt(int n) {
        return n + n;
    }

    public static void myPrintStatic(int n) {
        System.out.println(n);
    }
}
