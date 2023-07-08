package com.gl.Java2023Session18;

public class Sample {
    public static void main(String[] args) {

        String sentence = "This is test message";
        System.out.println("sentence = " + sentence);

        int count = wordsCount(sentence);
        System.out.println("wordsCount = " + count);

        printAllWordsInGivenSentence(sentence);
        System.out.println();

        String[] allWords = getAllWordsInGivenSentence(sentence);
        System.out.println("allWords.length = " + allWords.length);

        for (int i = 0; i < allWords.length; i++) {
            System.out.println("(" + (i + 1) + ") word -> " + allWords[i]);
        }

        String[] strings = sentence.split(" ");
        System.out.println("strings.length = " + strings.length);
        for (String t : strings) {
            System.out.println(t);
        }
        System.out.println("sentence.toUpperCase() = " + sentence.toUpperCase());
        System.out.println("sentence.toLowerCase() = " + sentence.toLowerCase());

        String s = "    this      is     test     ";
        System.out.println("s = [" + s + "]");
        System.out.println("s.trim() = [" + s.trim() + "]");

        printShape();
    }

    static void printShape() {
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
            //System.out.print("\n");
        }
    }

    static String[] getAllWordsInGivenSentence(String sentence) {
        String[] allWords = sentence.split(" ");
        return allWords;
    }

    static void printAllWordsInGivenSentence(String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ') {
                System.out.println();
            } else {
                System.out.print(ch);
            }
        }
    }

    static int wordsCount(String sentence) {
        int wordCount = 0;

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ') {
                wordCount = wordCount + 1;
            }
        }
        return wordCount + 1;
    }
}

