package com.gl.JavaTrainingSession05;

public class Sample {
    public static void main(String[] args) {

        //Primitive data type value - store in method own stack frame
        int a = 10;
        int b = 20;
        System.out.println("a=" + a + ",b=" + b);
        swap(a, b);
        System.out.println("a=" + a + ",b=" + b);

        // Java Array is an Object
        // Array values are store in heap
        // The heap is shareable memory
        int[] intArray = {4, 7, 2, 5};
        printArray(intArray);
        swap(intArray, 2, 3);
        printArray(intArray);

        printArray(intArray);
        updateArrayWithVoidReturnType(intArray);
        printArray(intArray);
        int[] result = updateArrayWithIntArrayReturnType(intArray);
        printArray(result);

    }

    static void updateArrayWithVoidReturnType(int[] r) {
        // Update the input array itself
        // No need of return array from this method
        for (int i = 0; i < r.length; i++) {
            r[i] = r[i] * 2;
        }
    }

    static int[] updateArrayWithIntArrayReturnType(int[] r) {
        // Input array is NOT updated here
        // Create new array and update value from the input array
        // Need of return new array from this method
        int[] t = new int[r.length];
        for (int i = 0; i < r.length; i++) {
            t[i] = r[i] * 2;
        }
        return t;
    }

    static void printArray(int[] d) {
        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i] + ",");
        }
        System.out.println();
    }

    static void swap(int a, int b) {
        int t = a;
        a = b;
        b = t;
        System.out.println("a=" + a + ",b=" + b);
    }

    static void swap(int[] array, int indexA, int indexB) {
        int t = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = t;
    }
}
