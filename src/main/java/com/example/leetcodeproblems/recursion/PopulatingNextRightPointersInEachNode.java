package com.example.leetcodeproblems.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public class PopulatingNextRightPointersInEachNode {


    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        Node connect = new PopulatingNextRightPointersInEachNode().connectRecursion(node);
        System.out.println(connect);
    }

    public Node connectRecursion(Node root) {

        recursion(root, null);
        return root;
    }

    public void recursion(Node prev, Node next) {
        if (prev == null) {
            return;
        }
        prev.next = next;

        if (next == null) {
            next = new Node();
        }
        recursion(prev.left, prev.right);
        recursion(prev.right, next.left);
//        recursion(next.left, next.right);
    }

    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        Deque<Node> deque = new ArrayDeque<>();

        deque.addLast(root);

        while (!deque.isEmpty()) {
            int size = deque.size();


            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = deque.removeFirst();
                if (prev != null) {
                    prev.next = node;
                }

                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }

                prev = node;
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
