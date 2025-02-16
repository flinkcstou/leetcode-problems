package com.example.leetcodeproblems.array;

import java.util.*;

public class OpenTheLock {
    public static void main(String[] args) {

        int i = openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");

        System.out.println(i);

    }

    public static int openLock(String[] deadends, String target) {
        // Ты все правильно реализовал, можно теперь элегантнее написать код
        // посмотри как реализовано в editorials, реализуй от памяти также
        // посмотри видео ролики в ютубе может быть есть еще более красивый код


        for (String deadend : deadends) {
            if (deadend.equals(target) || deadend.equals("0000")) {
                return -1;
            }
        }
        if (target.equals("0000")) {
            return 0;
        }

        Deque<String> deque = new ArrayDeque<>();
        deque.addLast("0000");

        Set<String> set = new HashSet<>();
        set.addAll(deque);
        set.addAll(List.of(deadends));
        int count = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            count++;
            for (int k = 0; k < size; k++) {
                String s = deque.removeFirst();

                for (int i = 0; i < 4; i++) {
                    char[] chars = s.toCharArray();
                    char c = chars[i];
                    int number = c - '0';

                    int plus = (number + 1 + 10) % 10;
                    chars[i] = (char) (plus + '0');

                    String plusS = new String(chars);

                    if (plusS.equals(target)) {
                        return count;
                    }

                    if (set.add(plusS)) {
                        deque.addLast(plusS);
                    }

                    int minus = (number - 1 + 10) % 10;
                    chars[i] = (char) (minus + '0');
                    String minusS = new String(chars);

                    if (minusS.equals(target)) {
                        return count;
                    }

                    if (set.add(minusS)) {
                        deque.addLast(minusS);
                    }
                }
            }
        }
        return -1;
    }
}
