package com.example.leetcodeproblems.binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        double medianSortedArraysBinarySearch = findMedianSortedArraysBinarySearch(new int[]{1, 3}, new int[]{2});
        System.out.println(medianSortedArraysBinarySearch);
    }

    public static double findMedianSortedArraysBinarySearch(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArraysBinarySearch(nums2, nums1);
        }

        int left = 0;
        int right = nums1.length;

        int length = (nums1.length + nums2.length +1) / 2;

        while (left <= right) {

            int middle1 = left + (right - left) / 2;
            int middle2 = length - middle1;

            int min1 = middle1 == 0 ? Integer.MIN_VALUE : nums1[middle1 - 1];
            int max1 = middle1 == nums1.length ? Integer.MAX_VALUE : nums1[middle1];

            int min2 = middle2 == 0 ? Integer.MIN_VALUE : nums2[middle2 - 1];
            int max2 = middle2 == nums2.length ? Integer.MAX_VALUE : nums2[middle2];

            if (min1 <= max2 && min2 <= max1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (double) (Math.max(min1, min2) + Math.min(max1, max2)) / 2;
                } else {
                    return Math.max(min1, min2);
                }
            } else if (min1 > max2) {
                right = middle1 - 1;
            } else {
                left = middle1 + 1;
            }
        }

        return -1.0;

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> list = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                .sorted()
                .boxed()
                .toList();


        int left = 0;
        int right = list.size() - 1;
        int middle = left + (right - left) / 2;

        if (list.size() % 2 == 0) {
            return (double) (list.get(middle) + list.get(middle + 1)) / 2;
        } else {
            return list.get(middle);
        }


    }

}
