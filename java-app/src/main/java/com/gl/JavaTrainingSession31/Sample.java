package com.gl.JavaTrainingSession31;

public class Sample {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(5);
        myLinkedList.add(2);
        myLinkedList.add(7);
        myLinkedList.add(9);
        myLinkedList.add(1);
        myLinkedList.add(3);
        myLinkedList.showAll();
        myLinkedList.remove(9);
        myLinkedList.showAll();
        myLinkedList.removeFirst();
        myLinkedList.showAll();
        myLinkedList.removeLast();
        myLinkedList.showAll();
        myLinkedList.remove(2);
        myLinkedList.showAll();
        myLinkedList.add(9);
        myLinkedList.add(3);
        myLinkedList.add(5);
        myLinkedList.showAll();
        myLinkedList.remove(7);
        myLinkedList.add(13);
        myLinkedList.add(31);
        myLinkedList.showAll();
        myLinkedList.removeAtPosition(4);
        myLinkedList.remove(31);
        myLinkedList.showAll();
        myLinkedList.add(11);
        myLinkedList.showAll();
    }
}

class MyLinkedList {
    Node head;
    Node tail;

    void add(int data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    void removeFirst() {
        head = head.next;
    }

    void removeLast() {
        Node previousNode = getPreviousNode(tail.data);
        previousNode.next = null;
        tail = previousNode;
    }

    void remove(int data) {
        Node foundNode = getNode(data);
        if (foundNode != null) {
            Node previousNode = getPreviousNode(data);
            if (previousNode != null) {
                previousNode.next = foundNode.next;
                if (foundNode == tail) {
                    tail = previousNode;
                }
            } else {
                removeFirst();
            }
        } else {
            System.out.println("Data(" + data + ") NOT found in linked list ");
        }
    }

    void removeAtPosition(int position) {
        int size = size();
        if (position < size) {
            Node nodeAtPosition = getNodeAtPosition(position);
            remove(nodeAtPosition.data);
        } else {
            System.out.println("input position(" + position + ") is out of linked list");
        }
    }

    Node getNodeAtPosition(int position) {
        Node temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }
        return temp;
    }

    int size() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count = count + 1;
            temp = temp.next;
        }
        return count;
    }

    Node getPreviousNode(int data) {
        Node temp = head;
        Node previous = null;
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

    void showAll() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
