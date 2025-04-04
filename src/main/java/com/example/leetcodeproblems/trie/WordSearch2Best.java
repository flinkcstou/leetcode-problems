package com.example.leetcodeproblems.trie;


import java.util.*;

public class WordSearch2Best {
    public static void main(String[] args) {

        List<String> words = new Solution().findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, Arrays.asList("oath", "pea", "eat", "rain", "oathi", "oathk", "oathf", "oate", "oathii", "oathfi", "oathfii").toArray(new String[0]));
        System.out.println(words);
    }


    public static class Solution {
        private final static Character hashTag = '#';
        TrieNode root = new TrieNode();
        char[][] board = new char[][]{};
        List<String> list = new ArrayList<>();

        public List<String> findWords(char[][] board, String[] words) {
            this.board = board;
            this.list = new ArrayList<>();
            this.add(words);

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    dfs(i, j, root);
                }
            }

            return list;
        }

        public void dfs(int i, int j, TrieNode root) {
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
                return;
            }

            Character character = board[i][j];
            TrieNode curr = root.map.get(character);

            if (curr == null || character == hashTag) {
                return;
            }

            if (curr.word != null) {
                list.add(curr.word);
                curr.word = null;
            }
            board[i][j] = hashTag;

            dfs(i - 1, j, curr);
            dfs(i + 1, j, curr);
            dfs(i, j - 1, curr);
            dfs(i, j + 1, curr);

            board[i][j] = character;
        }

        public void add(String[] words) {

            for (String word : words) {
                TrieNode curr = root;
                for (int i = 0; i < word.length(); i++) {
                    curr.map.putIfAbsent(word.charAt(i), new TrieNode());
                    curr = curr.map.get(word.charAt(i));
                }
                curr.word = word;
            }
        }

        public static class TrieNode {
            Map<Character, TrieNode> map = new HashMap<>();
            String word;

        }


    }
}
