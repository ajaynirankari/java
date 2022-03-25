package com.gl.JavaTrainingSession35;

public class Sample {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(2);
        doublyLinkedList.add(5);
        doublyLinkedList.add(7);
        doublyLinkedList.add(17);
        doublyLinkedList.add(1);
        doublyLinkedList.add(9);
        doublyLinkedList.add(79);
        doublyLinkedList.showFromHead();
        doublyLinkedList.showFromTail();
        doublyLinkedList.removeHead();
        doublyLinkedList.showFromHead();
        doublyLinkedList.showFromTail();
        doublyLinkedList.removeTail();
        doublyLinkedList.showFromHead();
        doublyLinkedList.showFromTail();
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    void add(int data) {
        Node newNode = new Node(tail, data, null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    void removeHead() {
        if (head == null) {
            System.out.println("Linked list is not created.");
        } else {
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
        }
    }

    void removeTail() {
        if (tail == null) {
            System.out.println("Linked list is not created.");
        } else {
            tail = tail.prev;
            if (tail == null) {

            } else {
                tail.next = null;
            }
        }
    }

    void showFromHead() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    void showFromTail() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
        System.out.println();
    }

    static private class Node {
        Node prev;
        int data;
        Node next;

        public Node(Node prev, int data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
}
