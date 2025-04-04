package com.example.leetcodeproblems.trie;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {


    public static void main(String[] args) {

        MapSum mapSumPairs = new MapSum();
        mapSumPairs.insert("apple", 3);

        int sum = mapSumPairs.sum("ap");
        mapSumPairs.insert("app", 2);
        mapSumPairs.insert("apple", 2);
        int sum1 = mapSumPairs.sum("ap");


        System.out.println(sum1);

    }

    public static class MapSumTrieNode {
        Map<String, Integer> map = new HashMap<>();
        TrieNode2 root = new TrieNode2();

        public MapSumTrieNode() {

        }

        public void insert(String key, int val) {

            int delta = val - map.getOrDefault(key, 0);
            map.put(key, val);

            TrieNode2 curr = root;

            for (int i = 0; i < key.length(); i++) {

                curr.map.computeIfAbsent(key.charAt(i), it -> new TrieNode2());
                curr = curr.map.get(key.charAt(i));
                curr.score += delta;
            }

        }

        public int sum(String prefix) {


            TrieNode2 curr = root;
            for (int i = 0; i < prefix.length(); i++) {

                curr = curr.map.get(prefix.charAt(i));
                if (curr == null) {
                    return 0;
                }
            }
            return curr.score;

        }

        public static class TrieNode2 {
            Map<Character, TrieNode2> map = new HashMap<>();
            int score = 0;
        }

    }

    public static class MapSumBruteForce2 {

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> score = new HashMap<>();

        public MapSumBruteForce2() {

        }

        public void insert(String key, int val) {
            Integer delta = val - map.getOrDefault(key, 0);
            map.put(key, val);

            String prefix = "";
            for (int i = 0; i < key.length(); i++) {
                prefix += key.charAt(i);

                score.put(prefix, score.getOrDefault(prefix, 0) + delta);
            }
        }

        public int sum(String prefix) {

            return score.getOrDefault(prefix, 0);
        }

    }

    public static class MapSumBruteForce {

        Map<String, Integer> map = new HashMap<>();

        public MapSumBruteForce() {

        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {

            int sum = 0;
            for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
                if (stringIntegerEntry.getKey().startsWith(prefix)) {
                    sum += stringIntegerEntry.getValue();
                }
            }
            return sum;
        }

    }


    public static class MapSum {
        public TrieNode root = new TrieNode();

        public MapSum() {

        }

        public void insert(String key, int val) {

            TrieNode cur = root;

            for (int i = 0; i < key.length(); i++) {
                if (!cur.map.containsKey(key.charAt(i))) {
                    TrieNode trieNode = new TrieNode();
                    cur.map.put(key.charAt(i), trieNode);
                }
                cur = cur.map.computeIfPresent(key.charAt(i), (k, oldVal) -> {
                    oldVal.keyValMap.put(key, val);
                    return oldVal;
                });
            }

        }

        public int sum(String prefix) {

            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (!cur.map.containsKey(prefix.charAt(i))) {
                    return 0;
                }
                cur = cur.map.get(prefix.charAt(i));
            }

            return cur.keyValMap.values().stream().mapToInt(Integer::intValue).sum();
        }

        public static class TrieNode {
            Map<Character, TrieNode> map = new HashMap<>();
            Map<String, Integer> keyValMap = new HashMap();

        }
    }
}
