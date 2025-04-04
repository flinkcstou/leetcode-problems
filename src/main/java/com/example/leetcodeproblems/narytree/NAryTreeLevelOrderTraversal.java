package com.example.leetcodeproblems.narytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new ArrayList<>();
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(4));
        root.children.get(0).children = new ArrayList<>();
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
        root.children.get(0).children.add(new Node(7));

        List<List<Integer>> lists = new Solution().levelOrder(root);
        System.out.println(lists);
    }

    public static class Solution {
        public List<List<Integer>> levelOrder(Node root) {

            List<List<Integer>> list = new ArrayList<>();

            recursive(root, list, 0);
            return list;

        }

        public void recursive(Node root, List<List<Integer>> list, int levelIndex) {
            if (root == null) {
                return;
            }
            if (list.size() < levelIndex + 1) {
                list.add(new ArrayList<>());
            }
            list.get(levelIndex).add(root.val);


            if (root.children == null) {
                return;
            }
            for (Node child : root.children) {
                recursive(child, list, levelIndex + 1);
            }

        }

        public List<List<Integer>> levelOrderQueue(Node root) {
            List<List<Integer>> list = new ArrayList<>();

            if (root == null) {
                return list;
            }
            Deque<Node> deque = new ArrayDeque<>();

            deque.addLast(root);

            while (!deque.isEmpty()) {

                int size = deque.size();
                List<Integer> innerList = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    Node node = deque.removeFirst();
                    innerList.add(node.val);

                    if (node.children != null) {
                        for (Node child : node.children) {
                            deque.addLast(child);
                        }
                    }
                }

                list.add(innerList);

            }

            return list;
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

    ;
}
