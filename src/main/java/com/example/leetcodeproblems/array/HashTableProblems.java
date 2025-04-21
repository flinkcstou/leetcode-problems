package com.example.leetcodeproblems.array;

import java.util.*;

public class HashTableProblems {

    public static void main(String[] args) {

//        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        myLinkedList.get(4);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5, 0);
        myLinkedList.addAtHead(6);
    }

    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();


        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }


        return false;
    }

    public static int singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        return set.stream().findFirst().get();

    }

    public static int singleNumberBest(int[] nums) {

        int numXor = 0;

        for (int num : nums) {
            numXor = numXor ^ num;
        }
        return numXor;

    }

    public static boolean isHappy(int n) {

        List<Integer> digits = new ArrayList<>();
        int number = n;
        int sum = 0;

        if (number == 1) {
            return true;
        }
        if (number < 4) {
            return false;
        }

        // Извлекаем цифры с конца числа
        while (number > 0) {
            digits.add(number % 10); // Берем последнюю цифру
            number /= 10;           // Убираем последнюю цифру
        }
        for (Integer digit : digits) {
            sum += digit * digit;
        }
        try {
            return isHappy(sum);
        } catch (Throwable e) {
            return false;
        }

    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }


        return set2.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }

        }
        return new int[]{};
    }

    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> values = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) == c2) {
                    return false;
                }
            } else if (values.contains(c2)) {
                return false;
            } else {
                map.put(c1, c2);
                values.add(c2);
            }

        }

        return true;
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length < list2.length) {
            return findRestaurant(list2, list1);
        }
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, List<String>> map2 = new HashMap<>();


        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int sumIndex = i + map1.get(list2[i]);
                if (min > sumIndex) {
                    min = sumIndex;
                }

                if (map2.containsKey(sumIndex)) {
                    map2.get(sumIndex).add(list2[i]);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(list2[i]);
                    map2.put(sumIndex, list);
                }
            }
        }
        return map2.get(min).toArray(new String[0]);
    }

    public static int firstUniqChar(String s) {


        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) != -1) {
                return i;
            }
        }

        return -1;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersection(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            map.computeIfPresent(nums1[i], (k, v) -> v + 1);
            map.computeIfAbsent(nums1[i], (it) -> 1);
        }
        for (int i = 0; i < nums2.length; i++) {

            if (map.containsKey(nums2[i]) && map.get(nums2[i]) >= 1) {
                nums.add(nums2[i]);
                map.compute(nums2[i], (k, v) -> v - 1);
            }
        }

        return nums.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        /*
         * Завтра прорешать быстрым способом
         * */

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int index = i;
            map.computeIfPresent(nums[i], (key, v) -> {
                v.add(index);
                return v;
            });
            map.computeIfAbsent(nums[i], (key) -> {
                List<Integer> list = new ArrayList<>();
                list.add(index);
                return list;
            });
        }
        for (Integer key : map.keySet()) {
            List<Integer> integers = map.get(key);
            if (integers.size() <= 1) {
                continue;
            }
            for (int i = 1; i < integers.size(); i++) {
                if (Math.abs(integers.get(i) - integers.get(i - 1)) <= k) {
                    return true;
                }
            }
        }


        return false;
    }

    public static boolean containsNearbyDuplicateBest(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }

            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

        }


        return false;
    }

    public static boolean isValidSudoku(char[][] board) {

        Map<Character, List<Set<Integer>>> map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (!map.containsKey(c)) {
                    List<Set<Integer>> list = new ArrayList<>();
                    list.add(new HashSet<>());
                    list.add(new HashSet<>());
                    list.add(new HashSet<>());
                    map.put(c, list);
                }
                List<Set<Integer>> list = map.get(c);
                int k = (i / 3) + (j / 3);
                if (list.get(0).contains(i)) {
                    return false;
                }
                if (list.get(1).contains(j)) {
                    return false;
                }
                if (list.get(2).contains(k)) {
                    return false;
                }
                list.get(0).add(i);
                list.get(1).add(j);
                list.get(2).add(k);
            }
        }

        return true;

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = String.valueOf(charArray);

            if (map.containsKey(sorted)) {
                List<String> strings = map.get(sorted);
                strings.add(str);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                map.put(sorted, strings);
            }
        }

        List<List<String>> values = new ArrayList<>();

        for (String key : map.keySet()) {
            values.add(map.get(key).stream().toList());
        }

        return values;
    }

    public static int numJewelsInStones(String jewels, String stones) {

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        Integer count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }


        return count;
    }

    public static int lengthOfLongestSubstring(String s) {

//        https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/ посмотреть решение и также один раз решить по памяти
        int count = 0;
        int maxCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                i = map.get(c);
                map = new HashMap<>();
                count = 0;
                continue;
            }
            map.put(c, i);
            count++;
            if (maxCount < count) {
                maxCount = count;
            }
        }

        return maxCount;
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> mapF = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                int sum = nums1[i] + nums2[j];
                if (!mapF.containsKey(sum)) {
                    mapF.put(sum, 0);
                }
                mapF.computeIfPresent(sum, (k, v) -> v + 1);
            }
        }
        Map<Integer, Integer> mapS = new HashMap<>();

        for (int i = 0; i < nums3.length; i++) {

            for (int j = 0; j < nums4.length; j++) {

                int sum = nums3[i] + nums4[j];
                if (!mapS.containsKey(sum)) {
                    mapS.put(sum, 0);
                }
                mapS.computeIfPresent(sum, (k, v) -> v + 1);
            }
        }
        int count = 0;

        for (Integer i : mapF.keySet()) {
            Integer negativeI = -i;

            if (mapS.containsKey(negativeI)) {
                count += mapF.get(i) * mapS.get(negativeI);
            }
        }


        return count;
    }

    public static int[] topKFrequent(int[] nums, int k) {

        // изучить priorityQueue кажется так будет быстрее
        // нужно повторно написать код, но уже через List<Integer>[]

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Set<Integer>> mapCount = new HashMap<>();

        for (Integer key : map.keySet()) {

            Integer count = map.get(key);

            if (!mapCount.containsKey(count)) {
                Set<Integer> set = new HashSet<>();
                mapCount.put(count, set);
            }
            Set<Integer> set = mapCount.get(count);
            set.add(key);
        }
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        set.addAll(map.values());

        int[] newNums = new int[k];
        int newIndex = 0;


        for (Integer i : set) {

            Set<Integer> integers = mapCount.get(i);

            for (Integer integer : integers) {
                newNums[newIndex++] = integer;
                if (newIndex == k) {
                    return newNums;
                }
            }

        }


        return newNums;

    }

    static class RandomizedSet {
        // посмотреть задачи которые люди решали в submission details там есть решение с двумя map посмотри, пойми и реши также

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        boolean isChanged = false;

        public RandomizedSet() {
            set = new HashSet<>();
        }

        public boolean insert(int val) {
            boolean a = set.add(val);
            if (!isChanged) {
                isChanged = a;
            }
            return a;
        }

        public boolean remove(int val) {
            boolean a = set.remove(val);
            if (!isChanged) {
                isChanged = a;
            }
            return a;
        }

        public int getRandom() {
            if (isChanged) {
                list = new ArrayList<>();
                list.addAll(set);
                isChanged = false;
            }

            int i = random.nextInt(list.size());

            return list.get(i);
        }
    }


    public static class MyLinkedList {
        // переписать, добавив size

        Node node;

        public MyLinkedList() {
            node = new Node();
        }

        public int get(int index) {
            Node node = this.node;

            for (int i = 0; i < index; i++) {
                if (node.next == null) {
                    return -1;
                }
                node = node.next;
            }

            if (node.val == null) {
                return -1;
            }

            return node.val;
        }

        public void addAtHead(int val) {
            Node cur = new Node();
            cur.val = val;
            if (this.node.val == null) {
                this.node = cur;
                return;
            }

            cur.next = this.node;
            this.node = cur;

        }

        public void addAtTail(int val) {

            Node cur = new Node();
            cur.val = val;

            Node node = this.node;
            while (node.next != null) {
                node = node.next;
            }
            node.next = cur;
        }

        public void addAtIndex(int index, int val) {

            Node cur = new Node();
            cur.val = val;
            if (index == 0) {
                addAtHead(val);
                return;
            }


            Node node = this.node;
            Node prev = new Node();
            for (int i = 0; i < index; i++) {
                if (node == null) {
                    return;
                }
                prev = node;
                node = node.next;
            }

            cur.next = node;
            prev.next = cur;
        }

        public void deleteAtIndex(int index) {

            Node node = this.node;
            if (index == 0) {
                node = node.next;
                this.node = node;
                if (this.node == null) {
                    this.node = new Node();
                }
                return;
            }


            Node prev = new Node();
            for (int i = 0; i < index; i++) {
                if (node.next == null) {
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = node.next;
        }

        public static class Node {
            public Integer val;
            public Node next;
            public Node prev;
        }
    }
}
