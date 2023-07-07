package com.gl.Java2023Session17;

public class Sample {
    public static void main(String[] args) {
        // Find out the occurrence of specific char in given string input

        // input = This is a test message
        // char - s,
        // output -> 5

        String input = "This is a test message";
        char searchChar = 't';
        System.out.println("input = " + input);
        int output = countTheOccurrenceOfChar(input, searchChar);
        System.out.println("countTheOccurrenceOfChar = " + output + ", of searchChar = " + searchChar);

        output = countTheOccurrenceOfCharCaseInSensitive(input, searchChar);
        System.out.println("countTheOccurrenceOfCharCaseInSensitive = " + output + ", of searchChar = " + searchChar);
    }

    static int countTheOccurrenceOfCharCaseInSensitive(String input, char searchChar) {
        int count = 0;
        char searchCharInUpperCase = toUpperCase(searchChar);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            char inputCharInUpperCase = toUpperCase(ch);
            if (inputCharInUpperCase == searchCharInUpperCase) {
                count = count + 1;
            }
        }
        return count;
    }

    static int countTheOccurrenceOfChar(String input, char searchChar) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            if (inputChar == searchChar) {
                count = count + 1;
            }
        }
        return count;
    }

    static char toUpperCase(char ch) {
        char toUp = ch;
        if (ch >= 'a' && ch <= 'z') {
            toUp = (char) (ch - 32);
        }
        return toUp;
    }
}
