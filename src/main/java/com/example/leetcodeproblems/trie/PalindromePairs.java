package com.example.leetcodeproblems.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().palindromePairsMap(new String[]{"b", "ab"});
        System.out.println(lists);
    }
    public static class Solution {
        public boolean isPalindrome(String word) {
            int left = 0;
            int right = word.length() - 1;
            while (left < right) {
                if (word.charAt(left++) != word.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }

        public List<List<Integer>> palindromePairsMap(String[] words) {

            List<List<Integer>> list = new ArrayList<>();
            if (words == null || words.length < 2) {
                return list;
            }

            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                map.put(words[i], i);
            }

            String empty = "";
            if (map.containsKey(empty)) {
                Integer index = map.get(empty);
                for (int i = 0; i < words.length; i++) {
                    if (index != i && isPalindrome(words[i])) {
                        list.add(List.of(index, i));
                        list.add(List.of(i, index));
                    }
                }
            }

            for (int i = 0; i < words.length; i++) {
                String str = new StringBuilder(words[i]).reverse().toString();
                Integer index = map.get(str);
                if (index != null && index != i) {
                    list.add(List.of(i, index));
                }
            }

            for (int i = 0; i < words.length; i++) {
                for (int j = 1; j < words[i].length(); j++) {
                    String left = words[i].substring(0, j);
                    String right = words[i].substring(j);

                    String leftReverse = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(leftReverse) && isPalindrome(right)) {
                        Integer index = map.get(leftReverse);
                        list.add(List.of(i, index));
                    }
                    String rightReverse = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(rightReverse) && isPalindrome(left)) {

                        Integer index = map.get(rightReverse);
                        list.add(List.of(index, i));
                    }

                }
            }

            return list;
        }

        public List<List<Integer>> palindromePairsBruteForce(String[] words) {

            List<List<Integer>> list = new ArrayList<>();
            if (words == null || words.length < 2) {
                return list;
            }

            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    String palindrome = words[i] + words[j];
                    if (isPalindrome(palindrome)) {
                        list.add(List.of(i, j));
                    }
                    palindrome = words[j] + words[i];
                    if (isPalindrome(palindrome)) {
                        list.add(List.of(j, i));
                    }
                }
            }
            return list;

        }

    }
}
