package com.gl.leetCode.AddTwoNumbers;

public class Sample {
    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        add(node1, 2);
        add(node1, 4);
        add(node1, 3);
        allNodes(node1.next);
        ListNode node2 = new ListNode();
        add(node2, 5);
        add(node2, 6);
        add(node2, 4);
        allNodes(node2.next);
        allNodes(addTwoNumbers(node1, node2).next);
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            carry = sum / 10;
        }
        return result.next;
    }

    static void add(ListNode node, int v) {
        while (node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(v);
    }

    static void allNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
}
