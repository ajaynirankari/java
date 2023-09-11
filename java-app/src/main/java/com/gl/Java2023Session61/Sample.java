package com.gl.Java2023Session61;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        // What is wrapper class
        // What is Auto-boxing or unboxing
        // Primitive value Vs Object Value

        byte b = 56;
        int x = 89;
        short s = 45;
        long l = 567l;

        float f = 1.13F;
        double y = 10.2;

        char c = 'A';
        boolean b1 = false;
        // For all these 8 primitive data type
        // corresponding the object value
        // Wrapper Classes

        Byte b11;
        Short s1;
        Integer in1;
        Long ln;

        Float ff;
        Double dd;

        Boolean bb;
        Character cc;

        //Integer integer  = new Integer(45);
        Integer integer = Integer.valueOf(45);
        Integer integerObject = 89;
        int x1 = 89;

        x1 = integerObject;
        integerObject = x1;

        String ss1 = new String("One");
        String s2 = "Hello";
        StringBuffer stringBuffer = new StringBuffer("Two");
        Test varTest = new Test(3);


        // Collection framework on the object

        List<Test> list = new ArrayList<>();

        list.add(varTest);
        list.add(new Test(5));
        //list.add(56);

        Test test1 = list.get(1);
        List<Integer> list1 = new ArrayList<>();
        Integer integer2 = Integer.valueOf(506);
        list1.add(integer2);
        int x3 = 90;
        list1.add(x3);
        list1.add(91); // since JDK 5, Autoboxing or Unboxing

        Integer integer1 = list1.get(2);
        int int1 = list1.get(2);


        List<Integer> integers = List.of(3, 6, 8);
        List<Integer> list2 = Arrays.asList(3, 4, 6, 8);
        //list2.add(88);
        System.out.println("list2 = " + list2);

        List<Integer> integers1 = new ArrayList<>(List.of(3, 6, 8));
        System.out.println("integers1 = " + integers1);
        integers1.add(99);
        System.out.println("integers1 = " + integers1);

        char c1 = 'a';
        System.out.println("c1 = " + c1);
        Character c2 = 'a';
        System.out.println("c2 = " + c2);
        System.out.println("c2 = " + Character.isDigit(c2));
        System.out.println("c2 = " + Character.isLowerCase(c2));

        Boolean bb4 = Boolean.valueOf(false);
        Boolean bb5 = false;

    }
}

class Test {
    int v;

    Test(int v1) {
        v = v1;
    }
}
