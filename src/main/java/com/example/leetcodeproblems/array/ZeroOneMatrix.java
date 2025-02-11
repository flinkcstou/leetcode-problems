package com.example.leetcodeproblems.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class ZeroOneMatrix {

    // можно решить без Queue и Set, можно обойтись только рекурсией, перепиши

    int[][] grid = new int[][]{};
    Set<Integer> set = new HashSet<>();
    Deque<int[]> deque = new ArrayDeque<>();

    public static void main(String[] args) {
//        ZeroOneMatrix numberOfIsland = new ZeroOneMatrix();
//        char[][] a1 = new char[][]{
//                {'1', '1', '1'},
//                {'0', '0', '0'},
//                {'1', '1', '1'}};
//
//        char[][] a2 = {{'1', '0', '1', '1', '1'}, {'1', '0', '1', '0', '1'}, {'1', '1', '1', '0', '1'}};
//
//
//        char[][] a = new char[][]{
//                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1'},
//                {'1', '0', '1', '0', '1', '1', '1', '1', '1', '1'},
//                {'0', '1', '1', '1', '0', '1', '1', '1', '1', '1'},
//                {'1', '1', '0', '1', '1', '0', '0', '0', '0', '1'},
//                {'1', '0', '1', '0', '1', '0', '0', '1', '0', '1'},
//                {'1', '0', '0', '1', '1', '1', '0', '1', '0', '0'},
//                {'0', '0', '1', '0', '0', '1', '1', '1', '1', '0'},
//                {'1', '0', '1', '1', '1', '0', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1', '1', '1', '1', '0', '1'},
//                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '0'}
//        };
//        numberOfIsland.updateMatrix(a2);

    }

    public int[][] updateMatrix(int[][] grid) {
        //можно решить более элегантно можно больше половины вещей убрать
        this.grid = grid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isWater(i, j)) {
                    set.add(getKey(i, j));
                    deque.add(new int[]{i, j});
                }
            }
        }

        while (!deque.isEmpty()) {
            int[] first = deque.removeFirst();
            int count = grid[first[0]][first[1]];

            int firstI = first[0];
            int firstJ = first[1];

            int right = firstJ + 1;
            int down = firstI + 1;
            int left = firstJ - 1;
            int up = firstI - 1;

            addQueue(firstI, right, count + 1);
            addQueue(firstI, left, count + 1);
            addQueue(down, firstJ, count + 1);
            addQueue(up, firstJ, count + 1);
        }

        return grid;
    }

    public void addQueue(int i, int j, int count) {
        if (inMatrix(i, j) && set.add(getKey(i, j))) {
            grid[i][j] = count;
            deque.add(new int[]{i, j});
        }
    }

    public int getKey(int i, int j) {
        return (i * grid[0].length) + (j + 1);
    }

    public boolean inMatrix(int i, int j) {
        int row = grid.length;
        int column = grid[0].length;

        return i >= 0 && i < row && j >= 0 && j < column;
    }

    public boolean isLand(int i, int j) {
        return grid[i][j] == 1;
    }

    public boolean isWater(int i, int j) {
        return grid[i][j] == 0;
    }
}
