package com.example.leetcodeproblems.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {

    public static void main(String[] args) {

        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        String s = new ReplaceWords().replaceWords(dictionary, sentence);
        System.out.println(s);

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        // Все правильно решил,
        // нужно brute force прорешать
        // Нужно код привести в порядок, вынести логику в методы и красиво все оформить, реализация есть в editorial
        TrieNode root = new TrieNode();

        dictionary.forEach(it -> {
            TrieNode curr = root;
            for (int i = 0; i < it.length(); i++) {
                curr.map.putIfAbsent(it.charAt(i), new TrieNode());
                curr = curr.map.get(it.charAt(i));
                if (curr.root) {
                    break;
                }
            }
            curr.root = true;
            curr.map = new HashMap<>();
        });
        String[] split = sentence.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {

            if (!stringBuilder.isEmpty()) {
                stringBuilder.append(" ");
            }

            TrieNode curr = root;

            asd:
            for (int i = 0; i < s.length(); i++) {
                curr = curr.map.get(s.charAt(i));
                if (curr == null) {
                    stringBuilder.append(s);
                    break asd;
                }
                if (curr.root) {
                    stringBuilder.append(s, 0, i + 1);
                    break;
                }
            }
            if (curr != null && !curr.root) {
                stringBuilder.append(s);
            }


        }

        return stringBuilder.toString();

    }

    public static class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        boolean root = false;


    }
}
