package com.gl.JavaTrainingSession26;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        String data = "radDar";
        System.out.println("data = " + data);

        boolean isPalindrome = isPalindrome(data);
        System.out.println("isPalindrome = " + isPalindrome);

        String inputForReverse = "abcde";
        System.out.println("inputForReverse = " + inputForReverse);

        String rev = reverse("abcde");
        System.out.println("reverse = " + rev);

        convertCharArrayToStringObject(data.toCharArray());
        convertPrimitiveIntToStringObject(345);
    }

    static String reverse(String input) {
        char[] chars = input.toCharArray();
        int l = 0;
        int r = input.length() - 1;
        while (l < r) {
            char t = chars[l];
            chars[l] = chars[r];
            chars[r] = t;
            l = l + 1;
            r = r - 1;
        }
        return new String(chars);
    }

    static boolean isPalindrome(String input) {
        input = input.toLowerCase();
        int l = 0;
        int r = input.length() - 1;
        while (l < r) {
            if (input.charAt(l) != input.charAt(r)) {
                return false;
            }
            l = l + 1;
            r = r - 1;
        }
        return true;
    }

    static void convertCharArrayToStringObject(char[] chars) {
        String s = "";
        for (int i = 0; i < chars.length; i++) {
            s = s + chars[i];
        }
        System.out.println("string using + = " + s);

        String s1 = new String();
        for (int i = 0; i < chars.length; i++) {
            s1 = s1.concat("" + chars[i]);
        }
        System.out.println("string using concat() = " + s1);

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            stringBuffer.append(chars[i]);
        }
        String s3 = stringBuffer.toString();
        System.out.println("string using stringBuffer = " + s3);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
        }
        String s2 = stringBuilder.toString();
        System.out.println("string using stringBuilder = " + s2);

        String s4 = new String(chars);
        System.out.println("string using new String(char[]) = " + s4);
    }

    static void convertPrimitiveIntToStringObject(int a) {
        String s1 = "" + a;
        String s2 = String.valueOf(a);
        String s3 = new String("" + a);
        String s4 = Integer.toString(a);
    }
}
