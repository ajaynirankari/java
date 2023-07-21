package com.gl.Java2023Session25;

public class Sample {
    public static void main(String[] args) {
        String input = "This is a test message for testing";
        System.out.println("Input string = " + input);

        findAllDuplicateCharactersAndCountOfTheDuplicateCharacter(input);
    }

    static void findAllDuplicateCharactersAndCountOfTheDuplicateCharacter(String input) {
        int[] allCharactersArray = new int[256];

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int asciiValueOfCharAsAnIndexPositionOfArray = (int) ch;
            allCharactersArray[asciiValueOfCharAsAnIndexPositionOfArray] = allCharactersArray[asciiValueOfCharAsAnIndexPositionOfArray] + 1;
        }

        for (int i = 0; i < allCharactersArray.length; i++) {
            if (allCharactersArray[i] > 1) {
                System.out.println("Duplicate character is : [" + (char) i + "], its count is : [" + allCharactersArray[i] + "] times");
            }
        }
    }
}
