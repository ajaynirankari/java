package com.gl.LinkedListDataStructure;

import org.mockito.Mockito;

public class Sample {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.add(5);
        myLinkedList.showAllElements();
        myLinkedList.add(2);
        myLinkedList.showAllElements();
        myLinkedList.add(12);
        myLinkedList.showAllElements();
        myLinkedList.add(6);
        myLinkedList.showAllElements();
        myLinkedList.addFirst(9);
        myLinkedList.showAllElements();
        myLinkedList.addAfter(22, 3);
        myLinkedList.showAllElements();
        myLinkedList.addAfter(2, 3);
        myLinkedList.showAllElements();
        myLinkedList.addBefore(2, 1);
        myLinkedList.showAllElements();
        myLinkedList.addAtPosition(4, 77);
        myLinkedList.showAllElements();
        myLinkedList.remove(77);
        myLinkedList.showAllElements();
        myLinkedList.removeFirst();
        myLinkedList.showAllElements();
        myLinkedList.removeLast();
        myLinkedList.showAllElements();
        myLinkedList.removeAtPosition(3);
        myLinkedList.showAllElements();
        myLinkedList.add(4);
        myLinkedList.add(9);
        myLinkedList.add(29);
        myLinkedList.add(91);
        myLinkedList.showAllElements();
        myLinkedList.sort();
        myLinkedList.showAllElements();
        myLinkedList.add(2);
        myLinkedList.showAllElements();
        myLinkedList.removeMiddleNode();
        myLinkedList.showAllElements();
        myLinkedList.add(9);
        myLinkedList.showAllElements();
        myLinkedList.removeMiddleNodeUsingTwoPointer();
        myLinkedList.showAllElements();

    }
}

class MyLinkedList {
    Node head; // first Node of Linked List
    Node tail; // last Node of Linked List

    void add(int element) {
        Node newNode = new Node(element, null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    void addFirst(int element) {
        Node newNode = new Node(element, head);
        head = newNode;
    }

    void addAfter(int element, int newElement) {
        Node foundNode = getNode(element);
        if (foundNode != null) {
            Node newNode = new Node(newElement, foundNode.next);
            foundNode.next = newNode;
        } else {
            System.out.println("Element(" + element + ") not found in linked lint");
        }

    }

    void addBefore(int element, int newElement) {
        Node previousNode = getPreviousNode(element);
        if (previousNode != null) {
            Node newNode = new Node(newElement, previousNode.next);
            previousNode.next = newNode;
        } else {
            System.out.println("Element(" + element + ") not found in linked lint");
        }
    }

    void addAtPosition(int position, int element) {
        int size = size();
        if (position < size) {
            Node nodeAtPosition = getNodeAtPosition(position);
            Node newNode = new Node(element, nodeAtPosition.next);
            nodeAtPosition.next = newNode;
        }
    }

    void remove(int element) {
        Node previousNode = getPreviousNode(element);
        Node node = getNode(element);
        previousNode.next = node.next;
    }

    void removeFirst() {
        head = head.next;
    }

    void removeLast() {
        Node previousNode = getPreviousNode(tail.element);
        previousNode.next = null;
        tail = previousNode;
    }

    Node getNodeAtPosition(int position) {
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        return temp;
    }

    int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count = count + 1;
            temp = temp.next;
        }
        return count;
    }

    Node getPreviousNode(int element) {
        Node temp = head;
        Node previous = head;
        while (temp != null) {
            if (temp.element == element) {
                return previous;
            }
            previous = temp;
            temp = temp.next;
        }
        return null;
    }

    Node getNode(int element) {
        Node temp = head;
        while (temp != null) {
            if (temp.element == element) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    void showAllElements() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.element + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    void removeAtPosition(int position) {
        int size = size();
        if (position < size) {
            Node nodeAtPosition = getNodeAtPosition(position);
            Node previousNode = getPreviousNode(nodeAtPosition.element);
            previousNode.next = nodeAtPosition.next;
        }
    }

    void sort() {
        int size = size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                Node j_1Node = getNodeAtPosition(j - 1);
                Node jNode = getNodeAtPosition(j);
                if (j_1Node.element > jNode.element) {
                    swap(j_1Node, jNode);
                }
            }
        }
    }

    void swap(Node i, Node j) {
        int t = i.element;
        i.element = j.element;
        j.element = t;
    }

    void removeMiddleNode() {
        Node middleNode = getMiddlePreviousNode();
        middleNode.next = middleNode.next.next;
    }

    void removeMiddleNodeUsingTwoPointer() {
        Node middleNode = getMiddlePreviousNodeUsingTwoPointer();
        middleNode.next = middleNode.next.next;
    }

    Node getMiddlePreviousNodeUsingTwoPointer() {
        Node fastPointer = head;
        Node slowPointer = head;
        Node previous = null;
        while (fastPointer.next != null) {
            previous = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return previous;
    }

    Node getMiddlePreviousNode() {
        int size = size();
        Node temp = head;
        for (int i = 1; i < size / 2; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private static class Node {
        int element;
        Node next;

        public Node(int element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
