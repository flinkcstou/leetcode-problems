package com.example.leetcodeproblems.narytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NAryTreePreorderTraversal {


    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new ArrayList<>();
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        root.children.get(0).children = new ArrayList<>();
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));

        List<Integer> preorder = new NAryTreePreorderTraversal().preorder(root);
        System.out.println(preorder);

    }

    public List<Integer> preorderStack(Node root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {

            Node node = deque.removeLast();
            list.add(node.val);

            if (node.children == null) {
                continue;
            }
            for (int i = node.children.size() - 1; i >= 0; i--) {
                deque.addLast(node.children.get(i));
            }

        }

        return list;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        recursive(root, list);
        return list;
    }

    public void recursive(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);

        if (root.children == null) {
            return;
        }
        for (Node child : root.children) {
            recursive(child, list);
        }
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
