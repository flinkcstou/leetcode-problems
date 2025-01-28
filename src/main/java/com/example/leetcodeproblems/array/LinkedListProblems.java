package com.example.leetcodeproblems.array;

import java.util.HashSet;
import java.util.Set;

public class LinkedListProblems {


    public static void main(String[] args) {

        LinkedListProblems.MyLinkedList myLinkedList = new LinkedListProblems.MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedList.get(1);              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.get(1);

//        myLinkedList.addAtHead(7);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtIndex(3, 0);
//        myLinkedList.deleteAtIndex(2);
//        myLinkedList.addAtHead(6);
//        myLinkedList.addAtTail(4);
//        myLinkedList.get(4);
//        myLinkedList.addAtHead(4);
//        myLinkedList.addAtIndex(5, 0);
//        myLinkedList.addAtHead(6);

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

    public static boolean isPalindrome(ListNode head) {

        // Есть более элегантный код, посмотри в submission, запомни и напиши из памяти также

        if (head == null) {
            return false;
        }

        ListNode node = head;
        ListNode copy = new ListNode(node.val);
        ListNode dummy = copy;

        while (node != null && node.next != null) {
            node = node.next;
            dummy.next = new ListNode(node.val);
            dummy = dummy.next;
        }


        node = copy;
        ListNode temp = null;
        ListNode first = null;

        while (node != null) {
            temp = node.next;

            node.next = first;
            first = node;
            node = temp;
        }

        ListNode main = head;

        while (first != null) {
            if (first.val != main.val) {
                return false;
            }
            first = first.next;
            main = main.next;
        }


        return true;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Решить двумя способами , есть решения в submissions, через рекурсию а второй через сорт, да сорт будет дольше но нужно попробовать решить
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            return mergeTwoLists(list2, list1);
        }

        ListNode head = new ListNode(0);
        ListNode node = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                node = node.next;

                list1 = list1.next;
            } else {
                node.next = list2;
                node = node.next;

                list2 = list2.next;
            }

        }
        if (list1 != null) {
            node.next = list1;
        }
        if (list2 != null) {
            node.next = list2;
        }

        return head.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode node = head;

        int dozen = 0;

        while (l1 != null || l2 != null || dozen != 0) {
            int sum = dozen;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            int rest = sum % 10;
            dozen = sum / 10;

            ListNode curr = new ListNode(rest);
            node.next = curr;
            node = curr;
        }

        return head.next;
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

    public static class MyLinkedList {

        Node head;
        int size = 0;

        public MyLinkedList() {
            head = null;
            size = 0;
        }

        public int get(int index) {
            if (size <= index) {
                return -1;
            }
            Node node = new Node(0, head);
            for (int i = 0; i <= index; i++) {
                node = node.next;
            }
            return node.val;
        }

        private void createHead(int val) {
            head = new Node(val, null, null);
            size = 1;
        }

        private void createTail(int val) {
            Node node = head;
            while (node != null && node.next != null) {
                node = node.next;
            }
            Node dummy = new Node();
            dummy.val = val;
            dummy.prev = node;
            node.next = dummy;
            size++;
        }

        private void createIndex(int index, int val) {
            Node node = new Node(0, head);
            for (int i = 0; i <= index; i++) {
                node = node.next;
            }
            Node dummy = new Node(val, node, node.prev);
            node.prev.next = dummy;
            node.prev = dummy;
            size++;
        }


        public void addAtHead(int val) {
            if (head == null) {
                createHead(val);
                return;
            }
            Node dummy = new Node();
            dummy.val = val;
            dummy.next = head;
            head.prev = dummy;
            head = dummy;
            size++;
        }

        public void addAtTail(int val) {
            if (head == null) {
                createHead(val);
                return;
            }
            createTail(val);
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            }
            if (size == index) {
                addAtTail(val);
                return;
            }
            if (size < index) {
                return;
            }
            createIndex(index, val);
        }

        public void deleteAtIndex(int index) {
            if (size <= index) {
                return;
            }
            if (index == 0) {
                head = head.next;
                size--;
                return;
            }
            Node node = new Node(0, head);
            for (int i = 0; i <= index; i++) {
                node = node.next;
            }
            Node dummy = node;
            dummy.prev.next = dummy.next;
            if (dummy.next != null) {
                dummy.next.prev = dummy.prev;
            }
            size--;
        }

        public static class Node {
            public Integer val;
            public Node next;
            public Node prev;

            public Node() {
            }

            public Node(Integer val, Node next) {
                this.val = val;
                this.next = next;
            }

            public Node(Integer val, Node next, Node prev) {
                this.val = val;
                this.next = next;
                this.prev = prev;
            }
        }
    }


}
