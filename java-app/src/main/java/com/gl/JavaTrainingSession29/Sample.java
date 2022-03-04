package com.gl.JavaTrainingSession29;

public class Sample {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.add(35);
        myLinkedList.add(55);
        myLinkedList.add(22);
        myLinkedList.add(27);
        myLinkedList.add(8);
        myLinkedList.add(80);

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

    void show() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }
}

class Node {
    int data;
    Node next;
}