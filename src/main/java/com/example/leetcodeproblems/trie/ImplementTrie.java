package com.example.leetcodeproblems.trie;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("word");

        boolean search = trie.search("wor");
        boolean search1 = trie.search("worD");
        boolean search2 = trie.search("word");
        trie.insert("worD");
        boolean search3 = trie.search("worD");

        System.out.println(trie);
    }

    public static class TrieNode {

        public Map<Character, TrieNode> map = new HashMap<>();
        public Boolean isEnd = false;

    }

    public static class Trie {

        TrieNode root = new TrieNode();

        public Trie() {

        }

        public void insert(String word) {
            TrieNode curr = root;

            for (int i = 0; i < word.length(); i++) {
                curr = curr.map.computeIfAbsent(word.charAt(i), it -> new TrieNode());
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {

            TrieNode curr = root;

            for (int i = 0; i < word.length(); i++) {
                if (!curr.map.containsKey(word.charAt(i))) {
                    return false;
                }
                curr = curr.map.get(word.charAt(i));
            }
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {

            TrieNode curr = root;

            for (int i = 0; i < prefix.length(); i++) {
                if (!curr.map.containsKey(prefix.charAt(i))) {
                    return false;
                }
                curr = curr.map.get(prefix.charAt(i));
            }
            return true;
        }
    }
}
