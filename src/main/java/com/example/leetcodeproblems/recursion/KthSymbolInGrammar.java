package com.example.leetcodeproblems.recursion;

import java.util.*;
import java.util.stream.Collectors;

public class KthSymbolInGrammar {


    public Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        int i = new KthSymbolInGrammar().kthGrammar3(30, 434991989);
        System.out.println(i);
    }

    public int kthGrammar(int n, int k) {
        return recursion(n, k, 0);
    }

    public int recursion(int n, int k, int pointer) {
        if (n == 1) {
            return pointer;
        }

        int totalElements = (int) Math.pow(2, n - 1);
        int halfElements = totalElements / 2;

        if (k > halfElements) {
            int nextPointer = (pointer == 0) ? 1 : 0;
            return 1 - recursion(n - 1, k - halfElements, nextPointer);
        } else {
            int nextPointer = (pointer == 0) ? 0 : 1;
            return recursion(n - 1, k, nextPointer);
        }
    }


    public int kthGrammar3(int n, int k) {
        String sdf = createStrRecursion(0, n);
        return Character.getNumericValue(sdf.charAt(k - 1));
    }

    public String createStrRecursion(int cipher, int n) {
        if (map.containsKey(n + "_" + cipher)) {
            return map.get(n + "_" + cipher);
        }
        if (n == 1) {
            return "0";
        }
        if (n == 2) {
            if (cipher == 0) {
                return "01";
            }
            if (cipher == 1) {
                return "10";
            }
        }

        String result = "";
        if (cipher == 0) {
            result = createStrRecursion(0, n - 1) + createStrRecursion(1, n - 1);
        }
        if (cipher == 1) {
            result = createStrRecursion(1, n - 1) + createStrRecursion(0, n - 1);
        }
        map.put(n + "_" + cipher, result);
        return result;
    }


    public int kthGrammar2(int n, int k) {

        List<Integer> characters = new ArrayList<>();
        characters.add(0);


        for (int i = 1; i < n; i++) {
            characters = characters.stream().map(x -> getInt(x))
                    .flatMapToInt(x -> Arrays.stream(x))
                    .mapToObj(x -> (int) x)
                    .collect(Collectors.toList());

        }

        return characters.get(k - 1);
    }

    public int[] getInt(int c) {
        if (c == 0) {
            return new int[]{0, 1};
        } else if (c == 1) {
            return new int[]{1, 0};
        } else {
            return new int[]{};
        }
    }
}
