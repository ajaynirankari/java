package com.gl.JavaTrainingSession34;

public class Sample {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(6);
        doublyLinkedList.showFromHead();
        doublyLinkedList.showFromTail();

        doublyLinkedList.add(9);
        doublyLinkedList.showFromHead();
        doublyLinkedList.showFromTail();

        doublyLinkedList.add(12);
        doublyLinkedList.showFromHead();
        doublyLinkedList.showFromTail();

        doublyLinkedList.add(2);
        doublyLinkedList.showFromHead();
        doublyLinkedList.showFromTail();

        doublyLinkedList.addAfter(9, 99);
        doublyLinkedList.showFromHead();
        doublyLinkedList.showFromTail();

        doublyLinkedList.addBefore(99, 98);
        doublyLinkedList.showFromHead();
        doublyLinkedList.showFromTail();

        doublyLinkedList.addFirst(100);
        doublyLinkedList.showFromHead();
        doublyLinkedList.showFromTail();

        doublyLinkedList.addAfter(2, 22);
        doublyLinkedList.showFromHead();
        doublyLinkedList.showFromTail();

        doublyLinkedList.addBefore(100, 101);
        doublyLinkedList.showFromHead();
        doublyLinkedList.showFromTail();
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    void add(int data) {
        addLast(data);
    }

    void addFirst(int data) {
        Node newNode = new Node(null, data, head);
        head.prev = newNode;
        head = newNode;
    }

    void addLast(int data) {
        Node newNode = new Node(tail, data, null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    void addAfter(int data, int newData) {
        Node foundNode = getNode(data);
        if (foundNode != null) {
            if (foundNode == tail) {
                addLast(newData);
            } else {
                Node foundNodeNext = foundNode.next;
                Node newNode = new Node(foundNode, newData, foundNodeNext);
                foundNodeNext.prev = newNode;
                foundNode.next = newNode;
            }
        } else {
            System.out.println("Data(" + data + ") not found");
        }
    }

    void addBefore(int data, int newData) {
        Node foundNode = getNode(data);
        if (foundNode != null) {
            if (foundNode == head) {
                addFirst(newData);
            } else {
                Node foundNodePre = foundNode.prev;
                Node newNode = new Node(foundNodePre, newData, foundNode);
                foundNodePre.next = newNode;
                foundNode.prev = newNode;
            }
        } else {
            System.out.println("Data(" + data + ") not found");
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

    void showFromHead() {
        Node temp = head;
        System.out.print("FromHead:-> ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    void showFromTail() {
        Node temp = tail;
        System.out.print("FromTail:-> ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
        System.out.println();
    }

    class Node {
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