package com.gl.Java2023Session14;

public class Sample {
    public static void main(String[] args) {

        // input = test, teSt, teST, TeST
        // output = Test, Test, Test, Test

        String input = "TeST";
        System.out.println("input = " + input);
        String output = toCamelCase(input);
        System.out.println("output = " + output);

        // input = This is a Test class
        // output =  This Is A Test Class

        input = "This is a Test class";
        System.out.println("input = " + input);
        output = toCamelCase(input);
        System.out.println("output = " + output);

        // input = john smith test
        // output = John Smith Test

        input = "john smith test";
        System.out.println("input = " + input);
        output = toCamelCaseForSentence(input);
        System.out.println("output = " + output);

    }

    static String toCamelCaseForSentence(String input) {
        char[] chars = input.toCharArray();
        boolean foundSpace = true;
        char c;
        for (int i = 0; i < chars.length; i++) {
            c = chars[i];
            if (c == ' ') {
                foundSpace = true;
                continue;
            }

            if (foundSpace) {
                if (isLowerCase(c)) {
                    chars[i] = toUpperCase(c);
                }
                foundSpace = false;
            } else {
                if (isUpperCase(c)) {
                    chars[i] = toLowerCase(c);
                }
            }
        }
        return new String(chars);
    }


    static String toCamelCase(String input) {
        char[] chars = input.toCharArray();
        char c = chars[0];
        if (isLowerCase(c)) {
            chars[0] = toUpperCase(c);
        }
        for (int i = 1; i < chars.length; i++) {
            c = chars[i];
            if (isUpperCase(c)) {
                chars[i] = toLowerCase(c);
            }
        }
        return new String(chars);
    }

    static char toUpperCase(char ch) {
        return (char) (ch - 32);
    }

    static char toLowerCase(char ch) {
        return (char) (ch + 32);
    }

    static boolean isLowerCase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    static boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}
