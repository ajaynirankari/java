package com.gl.Java2023Session16;

public class Sample {
    public static void main(String[] args) {
        // Vowels  - a, e, i, o, u

        char input_ = '&';
        System.out.println("input = " + input_);

        boolean isVowel = isVowel(input_);
        if (isVowel == true) {
            System.out.println("Vowel");
        } else {
            System.out.println("NOT Vowel");
        }

        boolean isConsonant = isConsonant(input_);
        if (isConsonant == true) {
            System.out.println("Consonant");
        } else {
            System.out.println("NOT Consonant");
        }

        String input = "This is test message for testing";
        System.out.println("input = " + input);
        int count = countTheNumberOfConsonant(input);
        System.out.println("countTheNumberOfConsonant = " + count);

        // find out the count of the specific character in given input
        // input = "This is test message for testing";
        // char = t;
        // output -> count of t = 4
        // output -> count of T = 1
        // output -> in case of insensitive, count of t = 5
        count = countCharInGivenStringInput(input, 's');
        System.out.println("count = " + count);
    }

    static int countTheNumberOfConsonant(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            boolean isConsonant = isConsonant(ch);
            if (isConsonant == true) {
                count = count + 1;
            }
            //System.out.println(i+"]ch = " + ch + ", isConsonant= " + isConsonant+", count = "+count);
        }
        return count;
    }

    //This method return true if input char is consonant
    static boolean isConsonant(char ch) {
        boolean isAlphabet = isAlphabet(ch);
        if (isAlphabet == true) {
            boolean isVowel = isVowel(ch);
            if (isVowel == true) {
                return false;
            } else {
                return true;   // it is a consonant;
            }
        } else {
            return false;
        }
    }

    static boolean isAlphabet(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }
        return false;
    }

    static boolean isVowel(char ch) {
        if (isUpperCase(ch)) {
            ch = toLowerCase(ch);
        }
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    static char toLowerCase(char ch) {
        return (char) (ch + 32);
    }

    static boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    static int countCharInGivenStringInput(String input, char ch) {
        // TODO:
        return 0;
    }
}
