package com.gl.JavaTrainingSession18;

public class Sample {
    public static void main(String[] args) {
        // Find the occurrence of each character from given string input using Array Data Structure
        // Example : - occurrence
        // o=1
        // c=3
        // u=1
        // r=2
        // e=2
        // n=1

        //System.out.println("a = " + (int) 'a');
        //System.out.println("z = " + (int) 'z');

        int[] allChars = new int[123];
        char input[] = "occurrence".toCharArray();
        for (int i = 0; i < input.length; i++) {
            int index = (int) input[i];
            allChars[index] = allChars[index] + 1;
        }
        for (int i = 0; i < allChars.length; i++) {
            if (allChars[i] > 0) {
                System.out.println((char) i + " = " + allChars[i] + " time at index [" + i + "]");
            }
        }
        int max = allChars[0];
        int maxValueIndex = getMaxValueIndex(allChars, max);
        System.out.println("maxValueIndex = " + maxValueIndex + " " + allChars[maxValueIndex] + " " + (char) maxValueIndex);

    }

    static int getMaxValueIndex(int[] a, int max) {
        int r = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                r = i;
            }
        }
        return r;
    }
}
