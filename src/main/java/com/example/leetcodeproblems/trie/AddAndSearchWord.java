package com.example.leetcodeproblems.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class AddAndSearchWord {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("dad");
        wordDictionary.addWord("at");
//        wordDictionary.search(".at");
        wordDictionary.addWord("bat");
//        boolean search = wordDictionary.search(wordDictionary.root, "pad");
//        boolean search1 = wordDictionary.search(wordDictionary.root, "bad");
        boolean search2 = wordDictionary.search(wordDictionary.root, ".at");
//        boolean search3 = wordDictionary.search(wordDictionary.root, "b..");
        System.out.println(search2);
    }


    public static class WordDictionary {
        TrieNode root = new TrieNode();

        public WordDictionary() {

        }

        public void addWord(String word) {
            root.addWord(word);
        }

        public boolean search(String word) {
            return search(root, word);
        }

        public boolean search(TrieNode root, String word) {

            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == '.') {
                    for (TrieNode inner : curr.map.values()) {
                        boolean search = search(inner, word.substring(i + 1));
                        if (search) {
                            return true;
                        }
                    }
                    return false;
                }
                curr = curr.map.get(word.charAt(i));
                if (curr == null) {
                    return false;
                }
            }
            return curr.isEnd;
        }


        public static class TrieNode {
            Map<Character, TrieNode> map = new HashMap<>();
            boolean isEnd = false;

            public void addWord(String word) {

                TrieNode curr = this;
                for (int i = 0; i < word.length(); i++) {
                    curr.map.putIfAbsent(word.charAt(i), new TrieNode());
                    curr = curr.map.get(word.charAt(i));
                }
                curr.isEnd = true;

            }

            public boolean search(String word, Function<TrieNode, TrieNode> function) {
                TrieNode curr = this;
                for (int i = 0; i < word.length(); i++) {
                    curr = curr.map.get(word.charAt(i));
                    if (curr == null) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
