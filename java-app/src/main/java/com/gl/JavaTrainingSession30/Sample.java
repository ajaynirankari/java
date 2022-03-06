package com.gl.JavaTrainingSession30;

public class Sample {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        System.out.println("myLinkedList.head = " + myLinkedList.head);
        System.out.println("myLinkedList.tail = " + myLinkedList.tail);
        myLinkedList.add(5);
        System.out.println("myLinkedList.head = " + myLinkedList.head);
        System.out.println("myLinkedList.tail = " + myLinkedList.tail);
        myLinkedList.add(7);
        System.out.println("myLinkedList.head = " + myLinkedList.head);
        System.out.println("myLinkedList.tail = " + myLinkedList.tail);
        myLinkedList.show();
        myLinkedList.add(3);
        myLinkedList.show();
        myLinkedList.add(9);
        myLinkedList.show();
        myLinkedList.add(1);
        myLinkedList.show();
        myLinkedList.add(6);
        myLinkedList.show();
        myLinkedList.addFirst(4);
        myLinkedList.show();
        myLinkedList.addAfter(19, 99);
        myLinkedList.show();
        myLinkedList.addAfter(9, 98);
        myLinkedList.show();
        myLinkedList.addBefore(9, 97);
        myLinkedList.show();


    }
}

class MyLinkedList {
    Node head;
    Node tail;

    void add(int data) {
        Node temp = new Node();
        temp.data = data;

        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
    }

    void addFirst(int data) {
        Node temp = new Node();
        temp.data = data;

        temp.next = head;
        head = temp;
    }

    void addAfter(int data, int newData) {
        Node foundNode = getNode(data);
        linkNodeInLinkedList(data, newData, foundNode);
    }

    void addBefore(int data, int newData) {
        Node previousNode = getPreviousNode(data);
        linkNodeInLinkedList(data, newData, previousNode);
    }

    void linkNodeInLinkedList(int data, int newData, Node node) {
        if (node != null) {
            Node temp = new Node();
            temp.data = newData;

            temp.next = node.next;
            node.next = temp;
        } else {
            System.out.println("Data(" + data + ") not found in Linked List ");
        }
    }

    Node getPreviousNode(int data) {
        Node temp = head;
        Node previous = head;
        while (temp != null) {
            if (temp.data == data) {
                return previous;
            }
            previous = temp;
            temp = temp.next;
        }
        return null;
    }

    Node getNode(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    Node getAfterNode(int data) {
        Node temp = getNode(data);
        while (temp != null) {
            return temp.next;
        }
        return null;
    }

    void show() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    private static class Node {
        int data;
        Node next;
    }
}
