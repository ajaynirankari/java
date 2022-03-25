package com.gl.DoublyLinkedListImplementation;

public class DoublyLinkedListImplementationDemo {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(5);
        doublyLinkedList.add(2);
        doublyLinkedList.add(7);
        doublyLinkedList.add(1);
        doublyLinkedList.show();
        doublyLinkedList.reverse();
        doublyLinkedList.addFirst(9);
        doublyLinkedList.show();
        doublyLinkedList.reverse();
        doublyLinkedList.addLast(19);
        doublyLinkedList.show();
        doublyLinkedList.reverse();
        doublyLinkedList.addAfter(7, 77);
        doublyLinkedList.show();
        doublyLinkedList.reverse();
        doublyLinkedList.addBefore(77, 66);
        doublyLinkedList.show();
        doublyLinkedList.reverse();
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    void add(int data) {
        Node newNode = new Node(data, null, null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
    }

    void addFirst(int data) {
        if (head != null) {
            Node newNode = new Node(data, head, null);
            head.previous = newNode;
            head = newNode;
        }
    }

    void addLast(int data) {
        if (tail != null) {
            Node newNode = new Node(data, null, tail);
            tail.next = newNode;
            tail = newNode;
        }
    }

    void addAfter(int data, int newData) {
        Node foundNode = getNode(data);
        if (foundNode != null) {
            Node newNode = new Node(newData, foundNode.next, foundNode);
            foundNode.next.previous=newNode;
            foundNode.next = newNode;
        } else {
            System.out.println("Node(" + data + ") not found");
        }
    }

    void addBefore(int data, int newData) {
        Node foundNode = getNode(data);
        if (foundNode != null) {
            Node newNode = new Node(newData, foundNode, foundNode.previous);
            foundNode.previous.next=newNode;
            foundNode.previous = newNode;
        } else {
            System.out.println("Node(" + data + ") not found");
        }
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

    void show() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    void reverse() {
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
