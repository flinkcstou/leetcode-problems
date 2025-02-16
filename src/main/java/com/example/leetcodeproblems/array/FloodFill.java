package com.example.leetcodeproblems.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class FloodFill {

    public static void main(String[] args) {

        floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);


    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Можно решить еще легче, из за  того что мне не нужно все currentColor искать я могу обойтись только recursion.
        // Попробуй решить через recursion, решение есть в submissions
        // Я тут использовал лишнее это visited;
        // Есть решение в editorial, запомни и реши также от памяти, это нужно запомнить что такое dfs алгоритм и как выглядит classic
        if (image.length == 0 || image[0].length == 0 || sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return image;
        }


        Deque<int[]> deque = new ArrayDeque<>();
        int[][] visited = new int[image.length][image[0].length];

        int currentColor = image[sr][sc];

        int[] i = new int[]{-1, 1, 0, 0};
        int[] j = new int[]{0, 0, -1, 1};

        visited[sr][sc] = 1;
        deque.addLast(new int[]{sr, sc});
        image[sr][sc] = color;

        while (!deque.isEmpty()) {

            int[] element = deque.removeFirst();

            for (int k = 0; k < 4; k++) {
                int nextI = element[0] + i[k];
                int nextJ = element[1] + j[k];

                if (nextI >= 0 && nextI < image.length && nextJ >= 0 && nextJ < image[0].length && image[nextI][nextJ] == currentColor && visited[nextI][nextJ] == 0) {
                    visited[nextI][nextJ] = 1;
                    deque.addLast(new int[]{nextI, nextJ});
                    image[nextI][nextJ] = color;
                }

            }

        }


        return image;
    }
}


