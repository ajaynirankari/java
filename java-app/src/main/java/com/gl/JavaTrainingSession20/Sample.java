package com.gl.JavaTrainingSession20;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        // Get max occurrence character case-insensitive wise string from given input string, using Array Data Structure
        // Example:
        //          Input - ReoccurrenceE
        //          Output - EeeecccRrrnou
        //
        // e=4 (Capital -1, Small-3)
        // c=3
        // r=3 (Capital -1, Small-2)
        // n=1
        // o=1
        // u=1

        String input = "ReoccurrenceE";

        System.out.println("input = " + input);
        int[] allChars = findOccurrenceOfEachCharacter(input);

        int maxOccurrence = maxOccurrence(allChars);

        String output = allMaxOccurrenceCharacterString(allChars, maxOccurrence, input);
        System.out.println("output = " + output);


        char s = 'A'; // char is unsigned integer
        System.out.println("s = " + s);
        int a = (int) s;
        int b = s + 32;
        char c = (char) (s + 32);
        s = (char) a;
        System.out.println("s = " + s);
    }

    static String allMaxOccurrenceCharacterString(int[] allChars, int maxOccurrence, String input) {
        StringBuilder stringBuilder = new StringBuilder();
        while (maxOccurrence > 0) {
            String result = getAllCharacterOfGivenMaxOccurrence(allChars, maxOccurrence, input);
            stringBuilder.append(result);
            maxOccurrence = maxOccurrence - 1;
        }
        return stringBuilder.toString();
    }

    static String getAllCharacterOfGivenMaxOccurrence(int[] allChars, int maxValue, String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < allChars.length; i++) {
            if (maxValue == allChars[i]) {
                char ch = (char) i;
                int fromIndex = 0;
                for (int j = 1; j <= maxValue; j++) {
                    int foundIndex = input.indexOf(ch, fromIndex);
                    if (foundIndex >= 0) {
                        stringBuilder.append(ch);
                        fromIndex = foundIndex + 1;
                    } else {
                        int lowerCase = ch + 32;
                        stringBuilder.append((char) lowerCase);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    static int maxOccurrence(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    static int[] findOccurrenceOfEachCharacter(String input) {
        input = input.toUpperCase();
        int[] allChars = new int[256];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int asciiIndex = (int) c;
            allChars[asciiIndex] = allChars[asciiIndex] + 1;
        }

        for (int i = 0; i < allChars.length; i++) {
            if (allChars[i] > 0) {
                System.out.println((char) i + " -> " + allChars[i] + " times at index [" + i + "]");
            }
        }
        return allChars;
    }
}