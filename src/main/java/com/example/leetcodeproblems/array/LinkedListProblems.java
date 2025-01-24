package com.example.leetcodeproblems.array;

import java.util.HashSet;
import java.util.Set;

public class LinkedListProblems {


    public static void main(String[] args) {

    }

    static boolean hasCycle(ListNode head) {


        ListNode slowNode = head;
        ListNode fastNode = head;
        while (true) {
            if (fastNode == null) {
                return false;
            }
            if (fastNode.next == null) {
                return false;
            }
            if (slowNode == fastNode.next) {
                return true;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

        }

    }

    static public ListNode detectCycle(ListNode head) {
        // прорешать через fast and slow pointer

        ListNode node = head;

        if (node == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();

        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headA.next == null || headB == null || headB.next == null) {
            return null;
        }

        ListNode nodeA = headA;
        Set<ListNode> set = new HashSet<>();
        while (nodeA != null) {
            set.add(nodeA);
            nodeA = nodeA.next;
        }
        ListNode nodeB = headB;

        while (nodeB != null) {
            if (set.contains(nodeB)) {
                return nodeB;
            }
            nodeB = nodeB.next;
        }

        return null;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // todo nabu solve this problems by fast and slow pointer
        if (n == 0) {
            return head;
        }

        int size = 0;
        ListNode node = head;

        while (node != null) {
            size++;
            node = node.next;
        }

        if (size < n) {
            return null;
        }
        if (size == n) {
            return head.next;
        }

        int sizeSecond = size - n;
        ListNode nodeSecond = head;

        for (int i = 1; i < sizeSecond; i++) {
            nodeSecond = nodeSecond.next;
        }
        nodeSecond.next = nodeSecond.next.next;


        return head;

    }

    public static ListNode reverseList(ListNode head) {

        // Написать, нарисовать flow как работает этот алгоритм

        ListNode first = null;
        ListNode node = head;
        ListNode temp = null;

        while (node != null) {
            temp = node.next;

            node.next = first;
            first = node;
            node = temp;
        }
        return first;

    }

    public static ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode node = head;

        while (node != null && node.next != null) {
            ListNode potential = node.next;
            if (potential.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }

        }
        return head;
    }

    public static ListNode removeElementsBest(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(head.val, head);
        ListNode node = dummy;

        while (node != null && node.next != null) {
            ListNode potential = node.next;
            if (potential.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return dummy.next;
    }

    public static ListNode removeElementsBest1(ListNode head, int val) {
        // На свежую голову разобрать этот метод подход с current и removeElementsBest где используется future

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(head.val, head);
        ListNode prev = dummy;
        ListNode curr = head;

        while (prev != null && prev.next != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static ListNode oddEvenList(ListNode head) {
        // прорешать как в sample 44200 KB submission посмотри и повтори также
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;

        ListNode oddDummy = odd;
        ListNode oddEven = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = oddEven;

        return oddDummy;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
