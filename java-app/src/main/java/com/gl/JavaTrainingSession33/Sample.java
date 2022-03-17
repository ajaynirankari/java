package com.gl.JavaTrainingSession33;

public class Sample {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(4);
        doublyLinkedList.showFromHeadToTail();
        doublyLinkedList.add(3);
        doublyLinkedList.showFromHeadToTail();
        doublyLinkedList.add(6);
        doublyLinkedList.showFromHeadToTail();
        doublyLinkedList.showTailToHead();
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    void add(int data) {
        Node newNode = new Node(data, null, tail);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    void showFromHeadToTail() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
    void showTailToHead() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.previous;
        }
        System.out.println();
    }


    static class Node {
        int data;
        Node next;
        Node previous;

        public Node(int data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }
}