package com.example.leetcodeproblems.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public class PopulatingNextRightPointersInEachNode2 {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.right = new Node(5);
        node.right.right = new Node(7);

        Node connect = new PopulatingNextRightPointersInEachNode2().connectRecursion(node);
        System.out.println(connect);

    }

    public Node connectRecursion(Node root) {

        Node head = root;

        while (head != null) {

            Node temp = new Node(0);
            Node dummy = temp;
            while (head != null) {

                if (head.left != null) {
                    temp.next = head.left;
                    temp = temp.next;
                }
                if (head.right != null) {
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            head = dummy.next;

        }

        return root;
    }

    public void recursion(Node root) {


    }

    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {

            int size = deque.size();

            Node lastRight = null;
            for (int i = 0; i < size; i++) {
                Node node = deque.removeFirst();

                if (node.right != null) {
                    deque.addLast(node.right);
                }

                if (node.left != null) {
                    deque.addLast(node.left);
                }

                node.next = lastRight;
                lastRight = node;

            }
        }

        return root;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
