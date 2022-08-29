package com.gl.leetCode.BinaryTreePreorderTraversal;

import java.util.*;

public class Sample {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("preorderTraversal(root) = " + preorderTraversal(root));
        System.out.println("inOrderTraversal(root) = " + inOrderTraversal(root));
        System.out.println("postOrderTraversal(root) = " + postOrderTraversal(root));
        System.out.println("levelOrderTraversal(root) = " + levelOrderTraversal(root));
        System.out.println("levelOrder(root) = " + levelOrder(root));
        System.out.println("levelOrderUsingQueue(root) = " + levelOrderUsingQueue(root));
        System.out.println("zigZagLevelOrderUsingQueue(root) = " + zigZagLevelOrderUsingQueue(root));
    }

    static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    static void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }

    static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    static void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }

    static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderTraversal(root, list);
        return list;
    }

    static void postOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left, list);
        postOrderTraversal(root.right, list);
        list.add(root.val);
    }

    static List<List<Integer>> zigZagLevelOrderUsingQueue(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> subList;
        boolean f = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                subList.add(node.val);
            }
            if (f) {
                Collections.reverse(subList);
            }
            f = !f;
            list.add(subList);
        }
        return list;
    }

    static List<List<Integer>> levelOrderUsingQueue(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> subList;
        while (!queue.isEmpty()) {
            int size = queue.size();
            subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                subList.add(node.val);
            }
            list.add(subList);
        }
        return list;
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        int level = 1;
        while (levelOrderTraversal(root, level++, list1)) {
            list.add(list1);
            System.out.println(list1);
            list1 = new ArrayList<>();
        }
        return list;
    }

    static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int level = 1;
        while (levelOrderTraversal(root, level++, list)) {
            System.out.println();
        }
        return list;
    }


    static boolean levelOrderTraversal(TreeNode root, int level, List<Integer> list) {
        if (root == null) {
            return false;
        }
        if (level == 1) {
            list.add(root.val);
            System.out.print("\t" + root.val);
            return true;
        }
        boolean left = levelOrderTraversal(root.left, level - 1, list);
        boolean right = levelOrderTraversal(root.right, level - 1, list);

        return left || right;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
