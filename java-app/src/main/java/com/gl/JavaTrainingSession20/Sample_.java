package com.gl.JavaTrainingSession20;

import java.util.Arrays;

public class Sample_ {
    public static void main(String[] args) {
        // Get max occurrence character wise string from given input string, using Array Data Structure
        // Example:
        //          Input - occurrence
        //          Output - ccceerrnou
        // c=3
        // e=2
        // r=2
        // n=1
        // o=1
        // u=1

        String input = "occurrencE";

        System.out.println("input = " + input);

        int[] allChars = findAllCharOccurrence(input);

        int maxOccurrence = maxOccurrence(allChars);

        // First approach - Index wise processing
        String maxOccurrenceWiseStr = maxOccurrenceIndexWiseString(allChars, maxOccurrence);
        System.out.println("output = " + maxOccurrenceWiseStr);

        // Second approach - Character wise processing
        String output = maxOccurrenceCharacterWiseString(allChars, maxOccurrence);
        System.out.println("output = " + output);
        String output1 = maxOccurrenceCharacterCaseInSensitiveWiseString(allChars, maxOccurrence, input);
        System.out.println("output1 = " + output1);

    }

    private static String maxOccurrenceIndexWiseString(int[] allChars, int maxOccurrence) {
        StringBuilder stringBuilder = new StringBuilder();
        while (maxOccurrence > 0) {
            int[] allIndexOfaGivenValue = getAllIndexOfaGivenValue(allChars, maxOccurrence);
            for (int i = 0; i < allIndexOfaGivenValue.length; i++) {
                int t = allIndexOfaGivenValue[i];
                char ch = (char) t;
                for (int j = 1; j <= maxOccurrence; j++) {
                    stringBuilder.append(ch);
                }
            }
            maxOccurrence--;
        }
        return stringBuilder.toString();
    }

    static int[] getAllIndexOfaGivenValue(int[] a, int value) {
        int[] tempArray = new int[a.length];
        int tempIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (value == a[i]) {
                tempArray[tempIndex] = i;
                tempIndex = tempIndex + 1;
            }
        }
        int[] returnArray = new int[tempIndex];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = tempArray[i];
        }
        return returnArray;
    }

    private static String maxOccurrenceCharacterWiseString(int[] allChars, int maxOccurrence) {
        StringBuilder stringBuilder = new StringBuilder();
        while (maxOccurrence > 0) {
            stringBuilder.append(getAllCharacterOfaGivenValue(allChars, maxOccurrence));
            maxOccurrence--;
        }
        return stringBuilder.toString();
    }

    private static String maxOccurrenceCharacterCaseInSensitiveWiseString(int[] allChars, int maxOccurrence, String input) {
        StringBuilder stringBuilder = new StringBuilder();
        while (maxOccurrence > 0) {
            stringBuilder.append(getAllCharacterCaseInSensitiveOfaGivenValue(allChars, maxOccurrence, input));
            maxOccurrence--;
        }
        return stringBuilder.toString();
    }

    static String getAllCharacterOfaGivenValue(int[] a, int value) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (value == a[i]) {
                char ch = (char) i;
                for (int j = 1; j <= value; j++) {
                    stringBuilder.append(ch);
                }
            }
        }
        return stringBuilder.toString();
    }

    static String getAllCharacterCaseInSensitiveOfaGivenValue(int[] a, int value, String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (value == a[i]) {
                char ch = (char) i;
                int fromIndex = 0;
                for (int j = 1; j <= value; j++) {
                    int foundIndex = input.indexOf(ch, fromIndex);
                    if (foundIndex >= 0) {
                        stringBuilder.append(ch);
                        fromIndex = foundIndex + 1;
                    } else {
                        int caseChar = isLowerCase(ch) ? ch - 32 : ch + 32;
                        stringBuilder.append((char) caseChar);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    static boolean isLowerCase(int c) {
        return c >= 97 && c <= 122;
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

    static int[] findAllCharOccurrence(String input) {
        int[] allChars = new int[256];
        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int asciiValueAsIndex = (int) c;
            allChars[asciiValueAsIndex] = allChars[asciiValueAsIndex] + 1;
        }
        for (int i = 0; i < allChars.length; i++) {
            //if (allChars[i] > 0)
            //System.out.println((char) i + " -> " + allChars[i] + " " + i);
        }
        return allChars;
    }

}
