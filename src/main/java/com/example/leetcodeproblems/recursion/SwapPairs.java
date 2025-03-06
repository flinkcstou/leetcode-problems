package com.example.leetcodeproblems.recursion;

public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        swapPairs(head);

    }

    public static ListNode swapPairs(ListNode head) {
// попробовать решить через while, есть решение в solutions а также в submissions
        return swap(head);
    }

    public static ListNode swap(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        node.next.next = swap(node.next.next);
        ListNode temp = node.next;
        node.next = node.next.next;
        temp.next = node;
        return temp;

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
