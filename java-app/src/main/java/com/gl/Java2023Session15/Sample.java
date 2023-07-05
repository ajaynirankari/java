package com.gl.Java2023Session15;

public class Sample {
    public static void main(String[] args) {
        // Vowels -> a, e, i, o, u
        // Vowels -> A, E, I, O, U

        String input = "This is tEst messAge";
        System.out.println("input = " + input);
        int count = countTheNumberOfVowels(input);
        System.out.println("countTheNumberOfVowels = " + count);
    }

    static int countTheNumberOfVowels(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isCharVowel(c)) {
                count++;
            }
        }
        return count;
    }

    static boolean isCharVowel(char c) {
        if (isUpperCase(c)) {
            c = convertToLowerCase(c);
        }
        return isVowel(c);
    }

    static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    static char convertToLowerCase(char c) {
        return (char) (c + 32);
    }
}
