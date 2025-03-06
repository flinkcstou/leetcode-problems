package com.example.leetcodeproblems.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElement {

    public static void main(String[] args) {
        findClosestElements(new int[]{1, 2, 2, 2, 5, 5, 5, 8, 9, 9}, 4, 0);
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
// https://leetcode.com/problems/find-k-closest-elements/solutions/106426/java-c-python-binary-search-o-log-n-k-k/
        //https://leetcode.com/problems/find-k-closest-elements/solutions/202785/very-simple-java-o-n-solution-using-two-pointers/
        // https://leetcode.com/problems/find-k-closest-elements/solutions/2636647/java-explained-in-detail-binary-search-two-pointers-priority-queue/
        // завтра прорешать также как тут
        // тут решили через формулу то что дано в самом задании

        int left = 0;
        int right = arr.length - 1;
        int previousMiddle = 0;

        while (left <= right) {
            int middle = left + (right - left) / 2;


            if (arr[middle] == x) {
                right = middle;
                break;
            } else if (arr[middle] > x) {
                right = middle - 1;
            } else {
                previousMiddle = middle;
                left = middle + 1;
            }
        }

        int pointerLeft = previousMiddle;
        int pointerRight = previousMiddle + 1;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {

            int leftValue = pointerLeft < 0 ? Integer.MIN_VALUE : arr[pointerLeft];
            int rightValue = pointerRight >= arr.length ? Integer.MAX_VALUE : arr[pointerRight];

            if (Math.abs((long) x - leftValue) <= Math.abs((long) rightValue - x)) {
                list.add(leftValue);
                pointerLeft--;
            } else {
                list.add(rightValue);
                pointerRight++;
            }
        }
        return list.stream().sorted().toList();
    }
}
