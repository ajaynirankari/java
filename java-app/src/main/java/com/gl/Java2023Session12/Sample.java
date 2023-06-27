package com.gl.Java2023Session12;

import java.io.File;

public class Sample {
    public static void main(String[] args) {

        int[] a = {3, 6, 8};
        System.out.println("a.length = " + a.length);
        // i < a.length
        // i <= a.length-1

        for (int i = 0; i < a.length; i++) {
            System.out.println("i = " + i + " i <= a.length-1 " + (i <= a.length - 1) + " ----> " + a[i]);
        }
        System.out.println("-------------------");
        for (int i = 0; i <= a.length - 1; i++) {
            System.out.println("i = " + i + " i <= a.length-1 " + (i <= a.length - 1) + " ----> " + a[i]);
        }
        System.out.println("-------------------");
        for (int e : a) {
            System.out.println("v = " + e);
        }

        String name = "rian";
        System.out.println(name);

        char[] ch = name.toCharArray();
        System.out.println(ch[0]);

        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            int ascii = (int) c;
            System.out.println("[" + ascii + "] --> [" + c + "] index of " + i);
        }

        System.out.println("------------------------------");
        char c1 = 'R';
        int ac1 = (int) c1;
        System.out.println(c1);
        System.out.println(ac1);

        int ac2 = ac1 + 32;
        char c2 = (char) ac2;
        System.out.println(ac2);
        System.out.println(c2);

        char c3 = 'A';
        System.out.println(c3);
        int ic4 = (c3 + 32);
        char c4 = (char) ic4;
        System.out.println(c4);


        int n = 78945;
        char cn = (char) n;
        System.out.println(cn);

        char c5 = 'g';
        System.out.println(c5);
        char c6 = (char) (c5 - 32);
        System.out.println(c6);

        System.out.println(name + " --> " + name.toUpperCase());

        char[] chars = {'A', 'b', 'p', 'f'};
        System.out.println(chars);
        System.out.println(chars[2]);
        chars[2] = (char) (chars[2] - 32);

        String str1 = new String(chars);
        System.out.println(str1);
        char[] chars1 = str1.toCharArray();
        System.out.println(chars1);

        String s = "Hello Testing Test one";
        char ss = 'C';
        String[] sa = {"Hello Testing", "Get", "Testing", "Hello"};
        String st1 = sa[0];
        System.out.println(st1.toUpperCase());
        System.out.println(sa.length);

        char[] ar1 = sa[0].toCharArray();
        System.out.println(ar1[6]);

        char[] ssc = {'H', 'e', 'l', 'l', 'o'};

        String ss2 = "Hello";
        String ss1 = new String("Hello");
        String ss3 = new String(ssc);
        System.out.println(ss2 + " " + ss1 + " " + ss3);

        File file = new File("/");
    }
}
