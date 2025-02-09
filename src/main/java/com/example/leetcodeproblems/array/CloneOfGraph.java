package com.example.leetcodeproblems.array;

import java.util.*;

public class CloneOfGraph {
    public static void main(String[] args) {

    }


    public static Node cloneGraph(Node node) {
        // Эту задачу можно решить через рекурсию,
        // Я понял что рекурсия это стек и то что можно через stack реализовать можно и через recursion
        // потом решить эту задачу через recursion
        //https://leetcode.com/problems/clone-graph/solutions/1793436/java-simple-code-with-heavy-comments/ просмотреть решение
        // завтра переписать внутри for, на более элегантный код, можно удалить clone, и exist удалить и сразу написать в if

        if (node == null || node.neighbors == null || node.neighbors.isEmpty()) {
            return node;
        }


        Node clone = new Node(node.val);
        Map<Node, Node> map = new HashMap<>();

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        map.put(node, clone);


        while (!queue.isEmpty()) {
            Node remove = queue.remove();
            Node temp = map.get(remove);


            for (Node neighbor : remove.neighbors) {

                boolean isExist = map.containsKey(neighbor);
                Node tempNeighbor = isExist ? map.get(neighbor) : new Node(neighbor.val);


                temp.neighbors.add(tempNeighbor);

                if (!isExist) {
                    map.put(neighbor, tempNeighbor);
                    queue.add(neighbor);
                }

            }

        }

        return clone;
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
