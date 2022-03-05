package com.gl.LinkedListImplementation;

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
        myLinkedList.addFirst(99);
        myLinkedList.show();
        myLinkedList.addAt(503, 6);
        myLinkedList.show();
        myLinkedList.addBeforeData(8, 38);
        myLinkedList.show();
        myLinkedList.addAfterData(8, 48);
        myLinkedList.show();
        myLinkedList.deleteLast();
        myLinkedList.show();
        myLinkedList.deleteFirst();
        myLinkedList.show();
        myLinkedList.deleteAt(3);
        myLinkedList.show();
        myLinkedList.deleteData(8);
        myLinkedList.show();
        myLinkedList.sort();
        myLinkedList.show();
        myLinkedList.search(67);
        myLinkedList.search(48);
    }
}

class MyLinkedList {
    private Node head;
    private Node tail;

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

    void addAt(int data, int position) {
        int s = size() - 1;
        if (position > s) {
            System.out.println("Position must be less than " + s);
            return;
        }
        Node positionNode = getAtPositionNode(position);
        if (positionNode != null) {
            Node atNode = new Node();
            atNode.data = data;

            atNode.next = positionNode.next;
            positionNode.next = atNode;
        }
    }

    int size() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    Node getAtPositionNode(int position) {
        Node temp = head;
        int count = 1;
        while (temp != null) {
            if (count == position) {
                return temp;
            }
            count++;
            temp = temp.next;
        }
        return null;
    }

    void addBeforeData(int data, int newData) {
        Node previous = getPreviousNode(data);

        if (previous != null) {
            Node atNode = new Node();
            atNode.data = newData;

            atNode.next = previous.next;
            previous.next = atNode;
        }
    }

    void addAfterData(int data, int newData) {
        Node current = getNode(data);

        Node atNode = new Node();
        atNode.data = newData;

        atNode.next = current.next;
        current.next = atNode;
    }

    Node getNode(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    Node getPreviousNode(int data) {
        Node temp = head;
        Node previous = head;
        while (temp != null) {
            if (temp.data == data)
                return previous;
            previous = temp;
            temp = temp.next;
        }
        return null;
    }

    Node getAfterNode(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data)
                return temp.next;
            temp = temp.next;
        }
        return null;
    }

    void deleteLast() {
        Node previousNode = getPreviousNode(tail.data);
        previousNode.next = null;
        tail = previousNode;
    }

    void deleteFirst() {
        head = head.next;
    }

    void deleteAt(int position) {
        Node atPositionNode = getAtPositionNode(position);
        if (atPositionNode != null) {
            Node previousNode = getPreviousNode(atPositionNode.data);
            previousNode.next = atPositionNode.next;
        } else {
            System.out.println("input atPositionNode not found = " + position);
        }
    }

    void deleteData(int data) {
        Node node = getNode(data);
        if (node != null) {
            Node previousNode = getPreviousNode(data);
            previousNode.next = node.next;
        } else {
            System.out.println("input data not found = " + data);
        }
    }

    void sort() {
        int s = size();
        for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                Node j_1Node = getAtPositionNode(j - 1);
                Node jNode = getAtPositionNode(j);
                if (j_1Node != null && jNode != null) {
                    if (j_1Node.data > jNode.data) {
                        swap(j_1Node, jNode);
                    }
                }
            }
        }
    }

    void swap(Node i, Node j) {
        int t = i.data;
        i.data = j.data;
        j.data = t;
    }

    void search(int data) {
        Node node = getNode(data);
        if (node == null) {
            System.out.println("Search data(" + data + ") NOT found in Linked List");
        } else {
            System.out.println("Search data(" + data + ") found in Linked List");
        }
    }

    void show() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    private class Node {
        int data;
        Node next;
    }
}
