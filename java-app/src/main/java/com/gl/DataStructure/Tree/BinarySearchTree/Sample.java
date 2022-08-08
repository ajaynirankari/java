package com.gl.DataStructure.Tree.BinarySearchTree;

import java.util.*;

public class Sample {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(50);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(70);
        tree.add(60);
        tree.add(80);
        tree.add(45);
        tree.add(47);
        tree.add(85);
        tree.preOrder();
        tree.inOrder();
        tree.postOrder();

        System.out.println("tree = " + tree.search(80));
        System.out.println("tree.sumOfAll() = " + tree.sumOfAll());
        System.out.println("tree.totalNodes() = " + tree.totalNodes());
        System.out.println("tree.totalLeafs() = " + tree.totalLeafs());
        System.out.println("tree.height() = " + tree.height());
        tree.levelOrderTraversal();
        tree.levelOrderTraversalWithoutRecursion();
        System.out.println();
        tree.reverseLevelOrderTraversal();
        tree.reverseLevelOrderTraversalWithoutRecursion();
        System.out.println();
        tree.levelOrderTraversalWithoutRecursionLineWise();
        tree.inOrderWithoutRecursion();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.preOrderWithoutRecursion();
        System.out.println();
        tree.preOrder();
        System.out.println();
        tree.postOrderWithoutRecursion();
        System.out.println();
        tree.postOrder();
        tree.mirrorTheTree();
        tree.postOrder();
        tree.mirrorTheTree();
        tree.postOrder();
        //tree.deleteTree();
        System.out.println("tree.getLevelOnNode(50) = " + tree.getLevelOnNode(85));
        //tree.add(3);
        //tree.add(303);
        System.out.println("tree.getMaxMin() = " + tree.getMaxMin());

        ArrayList l;
    }
}

class BinarySearchTree {
    private Node root;

    public boolean search(int d) {
        return null != search(root, d);
    }

    private Node search(Node node, int d) {
        if (node == null || d == node.data) {
            return node;
        }

        if (d < node.data) {
            return search(node.left, d);
        } else {
            return search(node.right, d);
        }
    }

    public void add(int d) {
        if (root == null) {
            root = new Node(d);
        } else {
            add(root, d);
        }
    }

    private Node add(Node node, int d) {
        if (node == null) {
            node = new Node(d);
            return node;
        }

        if (d < node.data) {
            node.left = add(node.left, d);
        } else {
            node.right = add(node.right, d);
        }
        return node;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + ", ");
        inOrder(node.right);
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + ", ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + ", ");

    }

    public int sumOfAll() {
        return sum(root);
    }

    private int sum(Node node) {
        if (node == null)
            return 0;
        return node.data + sum(node.left) + sum(node.right);
    }

    public int totalNodes() {
        return totalNodes(root);
    }

    private int totalNodes(Node node) {
        if (node == null)
            return 0;
        return 1 + totalNodes(node.left) + totalNodes(node.right);
    }

    public int totalLeafs() {
        return totalLeafs(root);
    }

    private int totalLeafs(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return totalLeafs(node.left) + totalLeafs(node.right);
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null)
            return -1;
        return max(height(node.left), height(node.right)) + 1;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public void levelOrderTraversal() {
        levelOrderTraversal(root);
    }

    private void levelOrderTraversal(Node node) {
        if (node == null)
            return;
        int height = height(node);
        for (int i = 0; i <= height; i++) {
            printAtGivenLevel(node, i + 1);
            System.out.println();
        }
    }

    public void reverseLevelOrderTraversal() {
        reverseLevelOrderTraversal(root);
    }

    private void reverseLevelOrderTraversal(Node node) {
        if (node == null)
            return;
        int height = height(node);
        for (int i = height; i >= 0; i--) {
            printAtGivenLevel(node, i + 1);
            System.out.println();
        }
    }

    public void reverseLevelOrderTraversalWithoutRecursion() {
        reverseLevelOrderTraversalWithoutRecursion(root);
    }

    private void reverseLevelOrderTraversalWithoutRecursion(Node node) {
        if (node == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Stack<Node> stack = new Stack<>();
        while (queue.size() > 0) {
            Node t = queue.remove();
            if (t.left != null) {
                queue.add(t.left);
            }
            if (t.right != null) {
                queue.add(t.right);
            }
            stack.push(t);
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop().data + ", ");
        }
    }

    public void levelOrderTraversalWithoutRecursion() {
        levelOrderTraversalWithoutRecursion(root);
    }

    private void levelOrderTraversalWithoutRecursion(Node node) {
        if (node == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (queue.size() > 0) {
            Node top = queue.remove();
            System.out.print(top.data + ", ");
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
        }
    }

    public void levelOrderTraversalWithoutRecursionLineWise() {
        levelOrderTraversalWithoutRecursionLineWise(root);
    }

    private void levelOrderTraversalWithoutRecursionLineWise(Node node) {
        if (node == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (true) {
            int count = queue.size();
            if (count == 0)
                break;

            while (count > 0) {
                Node top = queue.remove();
                System.out.print(top.data + ", ");
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
                count--;
            }
            System.out.println();
        }
    }

    private void printAtGivenLevel(Node node, int level) {
        if (node == null)
            return;
        if (level == 1) {
            System.out.print(node.data + ", ");
        }
        printAtGivenLevel(node.left, level - 1);
        printAtGivenLevel(node.right, level - 1);
    }

    public void inOrderWithoutRecursion() {
        inOrderWithoutRecursion(root);
    }

    private void inOrderWithoutRecursion(Node node) {
        if (node == null) return;

        Stack<Node> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (stack.size() > 0) {
            Node top = stack.pop();
            System.out.print(top.data + ", ");
            if (top.right != null) {
                Node temp = top.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
    }

    public void preOrderWithoutRecursion() {
        preOrderWithoutRecursion(root);
    }

    private void preOrderWithoutRecursion(Node node) {
        if (node == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (stack.size() > 0) {
            Node top = stack.pop();
            System.out.print(top.data + ", ");
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

    public void postOrderWithoutRecursion() {
        postOrderWithoutRecursion(root);
    }

    private void postOrderWithoutRecursion(Node node) {
        if (node == null) return;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(node);
        while (stack1.size() > 0) {
            Node top = stack1.pop();
            if (top.left != null) {
                stack1.push(top.left);
            }
            if (top.right != null) {
                stack1.push(top.right);
            }
            stack2.push(top);
        }
        while (stack2.size() > 0) {
            System.out.print(stack2.pop().data + ", ");
        }

    }

    public void mirrorTheTree() {
        mirrorTheTree(root);
    }

    private void mirrorTheTree(Node node) {
        if (node == null) return;
        //swap left tree to right tree
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        mirrorTheTree(node.left);
        mirrorTheTree(node.right);
    }

    public void deleteTree() {
        System.out.println("Deleting node ... ");
        deleteTree(root);
    }

    private Node deleteTree(Node node) {
        if (node == null) return null;

        node.left = deleteTree(node.left);
        node.right = deleteTree(node.right);

        System.out.print(node.data + ", ");
        return node;
    }

    public int getLevelOnNode(int data) {
        return getLevelOnNode(root, data, 1);
    }

    private int getLevelOnNode(Node node, int data, int level) {
        if (node == null) return 0;
        if (node.data == data) return level;
        int nextLevel = getLevelOnNode(node.left, data, level + 1);
        if (nextLevel != 0) return nextLevel;
        nextLevel = getLevelOnNode(node.right, data, level + 1);
        return nextLevel;
    }

    public Pair getMaxMin() {
        return getMaxMin(root);
    }

    private Pair getMaxMin(Node node) {
        if (node == null) return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Pair left = getMaxMin(node.left);
        Pair right = getMaxMin(node.right);

        Pair ret = new Pair(Math.max(node.data, right.max), Math.min(node.data, left.min));
        //System.out.println(node.data + " -> {" + left + "," + right + "} => " + ret);
        return ret;
    }

    class Pair {
        int max;
        int min;

        public Pair(int max, int min) {
            this.max = max;
            this.min = min;
        }

        @Override
        public String toString() {
            return "[max=" + max + ",min=" + min + "]";
        }
    }

    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}