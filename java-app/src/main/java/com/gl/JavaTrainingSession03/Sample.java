package com.gl.JavaTrainingSession03;

public class Sample {

    public static void main(String[] args) {
        Util obj = new Util();

        int a[] = {7, 4, 9, 2, 18, 5, 1};
        int maxElement = obj.findMaxElement(a);
        System.out.println("max of a[] = " + maxElement);

        int b[] = {17, 4, 19, 2, 18, 5};
        System.out.println("max of b[] = " + obj.findMaxElement(b));

        int c[] = {5, 7, 9, 3};
        System.out.println("max of c[] = " + obj.findMaxElement(c));

        System.out.println("findMinElement of b[] = " + obj.findMinElement(b));
        System.out.println("findMinElement of a[] = " + obj.findMinElement(a));
    }
}

class Util {

    public int findMaxElement(int forGivenAnyInputArray[]) {
        int max = forGivenAnyInputArray[0];
        for (int i = 1; i < forGivenAnyInputArray.length; i++) {
            if (max < forGivenAnyInputArray[i]) {
                max = forGivenAnyInputArray[i];
            }
        }
        return max;
    }

    public int findMinElement(int b[]) {
        int min = b[0];
        for (int i = 1; i < b.length; i++) {
            if (min > b[i]) {
                min = b[i];
            }
        }
        return min;
    }

    // Method overloading
    // Define more than one method with same name but with different input parameter
    // Example like - calculateSum() define for int and float input parameter

    public int calculateSum(int a, int b) {
        return a + b;
    }

    public int calculateSum(int a, int b, int c) {
        return a + b + c;
    }

    public float calculateSum(float a, float b) {
        return a + b;
    }

    public float calculateSum(float a, float b, float c) {
        return a + b + c;
    }
}
