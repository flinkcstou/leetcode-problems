package com.example.leetcodeproblems.narytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaximumDepthOfNAryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new ArrayList<>();
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(4));
        root.children.add(new Node(5));
        root.children.get(0).children = new ArrayList<>();
        root.children.get(0).children.add(new Node(6));
        root.children.get(0).children.get(0).children = new ArrayList<>();
        root.children.get(0).children.get(0).children.add(new Node(7));
        root.children.get(0).children.get(0).children.get(0).children = new ArrayList<>();
        root.children.get(0).children.get(0).children.get(0).children.add(new Node(8));
        int i = new Solution().maxDepthStack(root);
        System.out.println(i);
    }

    public static class Solution {

        public int maxDepthStack(Node root) {
            if (root == null) {
                return 0;
            }
            LinkedList<Node> linkedList = new LinkedList<>();
            linkedList.addLast(root);
            int max = 0;

            while (!linkedList.isEmpty()) {
                int size = linkedList.size();
                max += 1;

                for (int i = 0; i < size; i++) {
                    Node node = linkedList.removeFirst();

                    if (node.children != null) {
                        for (Node child : node.children) {
                            linkedList.addLast(child);
                        }
                    }

                }

            }
            return max;
        }

        public int maxDepth(Node root) {
            int recursive = recursive(root, 0);
            return recursive;
        }

        public int recursive(Node root, int levelOrder) {
            if (root == null) {
                return levelOrder;
            }
            if (root.children == null) {
                return levelOrder;
            }
            int max = levelOrder;
            for (Node child : root.children) {
                max = Math.max(recursive(child, levelOrder + 1), max);
            }
            return max;
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
