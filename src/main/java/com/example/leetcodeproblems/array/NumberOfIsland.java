package com.example.leetcodeproblems.array;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class NumberOfIsland {

    // можно решить без Queue и Set, можно обойтись только рекурсией, перепиши

    char[][] grid = new char[][]{};
    Set<Integer> set = new HashSet<>();
    Queue<int[]> deque = new ArrayDeque<>();

    public static void main(String[] args) {
        NumberOfIsland numberOfIsland = new NumberOfIsland();
        char[][] a1 = new char[][]{
                {'1', '1', '1'},
                {'0', '0', '0'},
                {'1', '1', '1'}};

        char[][] a2 = {{'1', '0', '1', '1', '1'}, {'1', '0', '1', '0', '1'}, {'1', '1', '1', '0', '1'}};


        char[][] a = new char[][]{
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1'},
                {'1', '0', '1', '0', '1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '0', '1', '1', '1', '1', '1'},
                {'1', '1', '0', '1', '1', '0', '0', '0', '0', '1'},
                {'1', '0', '1', '0', '1', '0', '0', '1', '0', '1'},
                {'1', '0', '0', '1', '1', '1', '0', '1', '0', '0'},
                {'0', '0', '1', '0', '0', '1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '1', '0', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '0', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '0'}
        };
        numberOfIsland.numIslands(a2);

    }

    public int numIslands(char[][] grid) {
        // можно решить без Queue и Set, можно обойтись только рекурсией, перепиши
        this.grid = grid;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!set.add(getKey(i, j))) {
                    continue;
                }
                if (isWater(i, j)) {
                    continue;
                }

                deque.add(new int[]{i, j});

                while (!deque.isEmpty()) {
                    int[] last = deque.remove();

                    int lastI = last[0];
                    int lastJ = last[1];

                    int right = lastJ + 1;
                    int down = lastI + 1;
                    int left = lastJ - 1;
                    int up = lastI - 1;

                    addQueue(lastI, right);
                    addQueue(lastI, left);
                    addQueue(down, lastJ);
                    addQueue(up, lastJ);
                    System.out.println();
                }
                count++;

            }
        }


        return count;
    }

    public void addQueue(int i, int j) {
        if (inMatrix(i, j) && set.add(getKey(i, j)) && isLand(i, j)) {
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
        return grid[i][j] == '1';
    }

    public boolean isWater(int i, int j) {
        return grid[i][j] == '0';
    }
}
