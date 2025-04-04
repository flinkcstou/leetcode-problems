package com.example.leetcodeproblems.trie;

import java.util.*;

public class WordSearch2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> words = solution.findWords(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abdc"});
        System.out.println("sdf");
    }



    public static class Solution {
        public static class TrieNode {
            Map<Character, TrieNode> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();

        }
        Set<Integer> set = new HashSet<>();
        TrieNode root = new TrieNode();

        char[][] board = new char[][]{};

        public List<String> findWords(char[][] board, String[] words) {
            this.board = board;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    addTrieNode(i, j, root);
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    TrieNode trieNode = root.map.get(getCharacter(i, j));
                    addNeighbor(i, j, trieNode);
                }
            }


            List<String> exists = new ArrayList<>();

            for (String word : words) {

                TrieNode curr = root;
                for (int i = 0; i < word.length(); i++) {
                    curr = curr.map.get(word.charAt(i));



                    if (curr == null) {
                        break;
                    }
                }
                if (curr != null) {
                    exists.add(word);
                }
            }

            return exists;
        }

        public void addTrieNode(int i, int j, TrieNode trieNode) {
            if (inMatrix(i, j)) {
                trieNode.map.putIfAbsent(getCharacter(i, j), new TrieNode());
                trieNode.map.get(getCharacter(i, j)).set.add(getKey(i, j));
            }
        }

        public int getKey(int i, int j) {
            return (i * this.board[0].length) + (j + 1);
        }

        public Character getCharacter(int i, int j) {
            return board[i][j];
        }

        public void addNeighbor(int indexI, int indexJ, TrieNode trieNode) {

            int right = indexJ + 1;
            int left = indexJ - 1;
            int up = indexI + 1;
            int down = indexI - 1;


            addTrieNodeNeighbor(indexI, right, trieNode);
            addTrieNodeNeighbor(indexI, left, trieNode);
            addTrieNodeNeighbor(up, indexJ, trieNode);
            addTrieNodeNeighbor(down, indexJ, trieNode);

        }

        public void addTrieNodeNeighbor(int i, int j, TrieNode trieNode) {
            if (inMatrix(i, j)) {
                trieNode.map.putIfAbsent(getCharacter(i, j), root.map.get(getCharacter(i, j)));
            }
        }


        public boolean inMatrix(int i, int j) {
            int row = board.length;
            int column = board[0].length;
            return i >= 0 && i < row && j >= 0 && j < column;

        }
    }
}
