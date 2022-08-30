package com.gl.JavaTrainingSession37;

public class Sample {
    public static void main(String[] args) {
        // Binary Search Tree
        int[] a = {3, 6, 9, 10, 14, 19, 22, 26, 40};
        System.out.println("binarySearch(a,19) = " + binarySearch(a, 20));

        Node root = new Node(7);
        root.left = new Node(2);
        root.right = new Node(9);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right.left = new Node(8);
        root.right.right = new Node(10);

        System.out.println("root = " + root);
    }

    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int v) {
            val = v;
        }
    }

    static boolean binarySearch(int[] a, int s) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (s == a[mid]) {
                return true;
            }
            if (s > a[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
