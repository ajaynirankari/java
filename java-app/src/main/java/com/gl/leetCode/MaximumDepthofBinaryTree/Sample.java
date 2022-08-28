package com.gl.leetCode.MaximumDepthofBinaryTree;

public class Sample {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.right.right.left = new Node(1);
        root.right.right.right.right = new Node(9);
        levelOrderTraversal(root);
        System.out.println("depthOrHeightOrMaxLevel = " + depthOrHeightOrMaxLevel(root));
    }

    static int depthOrHeightOrMaxLevel(Node node) {
        if (node == null) {
            return 0;
        }
        int left = depthOrHeightOrMaxLevel(node.left);
        int right = depthOrHeightOrMaxLevel(node.right);
        return 1 + Math.max(left, right);
    }

    static void levelOrderTraversal(Node node) {
        int level = 1;
        while (levelOrderTraversal(node, level++)) {
            System.out.println();
        }
    }

    static boolean levelOrderTraversal(Node node, int level) {
        if (node == null) {
            return false;
        }
        if (level == 1) {
            System.out.print("\t" + node.val);
            return true;
        }
        boolean left = levelOrderTraversal(node.left, level - 1);
        boolean right = levelOrderTraversal(node.right, level - 1);

        return left || right;
    }

    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "[" + val + "]";
        }
    }
}
