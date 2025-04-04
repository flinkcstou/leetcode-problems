package com.example.leetcodeproblems.narytree;

import java.util.*;

public class NAryTreePostorderTraversal {
    public static void main(String[] args) {
        // Мжно решить через while и linkedList и stacke а не через List, stack , stack

        Node root = new Node(1);
        root.children = new ArrayList<>();
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        root.children.get(0).children = new ArrayList<>();
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
        List<Integer> postorder = new Solution().postorderStack(root);
        System.out.println(postorder);
    }


    public static class Solution {

        public List<Integer> postorderStack(Node root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }

            Deque<Node> deque = new ArrayDeque<>();
            Deque<Node> dequeSecond = new ArrayDeque<>();

            deque.addLast(root);

            while (!deque.isEmpty()) {

                Node node = deque.peekLast();
                Node nodeSecond = dequeSecond.peekLast();

                if (node.children == null || node.children.isEmpty()) {
                    list.add(node.val);
                    deque.removeLast();
                    continue;
                }
                if (Objects.equals(node, nodeSecond)) {
                    list.add(node.val);
                    deque.removeLast();
                    dequeSecond.removeLast();
                    continue;
                }

                dequeSecond.addLast(node);

                for (int i = node.children.size() - 1; i >= 0; i--) {
                    deque.addLast(node.children.get(i));
                }

            }


            return list;
        }

        public List<Integer> postorder(Node root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            recursive(root, list);
            return list;
        }

        public void recursive(Node root, List<Integer> list) {
            if (root == null) {
                return;
            }

            if (root.children != null) {
                for (Node child : root.children) {
                    recursive(child, list);
                }
            }
            list.add(root.val);
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
