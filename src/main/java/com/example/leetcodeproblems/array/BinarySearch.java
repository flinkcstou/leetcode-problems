package com.example.leetcodeproblems.array;

public class BinarySearch {

    public static void main(String[] args) {

//        mySqrt(2);
//        mySqrt1(8);

        int i = searchRotatedBest(new int[]{5, 6, 0, 1, 2, 3, 4}, 0);
        System.out.println(i);
    }

    public static int searchRotatedBest2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            }
            if (nums[left] <= nums[middle]) {
                if (target >= nums[left] && target <= nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
                continue;
            }
            if (nums[middle] <= nums[right]) {
                if (target >= nums[middle] && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    public static int searchRotatedBest(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (nums[left] <= nums[middle]) {
                if (target >= nums[left] && target <= nums[middle]) {
                    int start = left;
                    int end = middle;

                    while (start <= end) {
                        int center = start + (end - start) / 2;

                        if (nums[center] == target) {
                            return center;
                        }
                        if (nums[center] > target) {
                            end = center - 1;
                        }
                        if (nums[center] < target) {
                            start = center + 1;
                        }
                    }
                    return -1;
                } else {
                    left = middle + 1;
                    continue;
                }
            }
            if (nums[middle] <= nums[right]) {
                if (target >= nums[middle] && target <= nums[right]) {
                    int start = middle;
                    int end = right;

                    while (start <= end) {
                        int center = start + (end - start) / 2;

                        if (nums[center] == target) {
                            return center;
                        }
                        if (nums[center] > target) {
                            end = center - 1;
                        }
                        if (nums[center] < target) {
                            start = center + 1;
                        }
                    }
                    return -1;
                } else {
                    right = middle - 1;
                    continue;
                }
            }


        }

        return -1;
    }

    public static int searchRotated(int[] nums, int target) {
        int rotate = 0;
        int start = 0;
        int end = nums.length;

        if (nums[0] > nums[nums.length - 1]) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                } else {

                    rotate = i + 1;
                    break;
                }
            }
        }

        while (start <= end) {
            int middle = start + (end - start) / 2;

            int pos = (middle + rotate) % nums.length;

            if (nums[pos] == target) {
                return pos;
            }
            if (nums[pos] > target) {
                end = middle - 1;
            }
            if (nums[pos] < target) {
                start = middle + 1;
            }

        }
        return -1;


    }

    public static int mySqrt1(int x) {
        if (x == 0 || x == 1)
            return x;
        int start = 1;
        int end = x;
        int mid = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if ((long) mid * mid > (long) x)
                end = mid - 1;
            else if (mid * mid == x)
                return mid;
            else
                start = mid + 1;
        }

        return Math.round(end);
    }

    public static int mySqrt(int x) {

        int start = 0;
        int end = x;
        int previousMiddle = x;


        while (start <= end) {
            int middle = (start + end) / 2;

            long value = (long) middle * middle;
            if (value == x) {
                return middle;
            }
            if (value < x) {
                previousMiddle = middle;
                start = middle + 1;
            }
            if (value > x) {
                end = middle - 1;
            }
        }


        return previousMiddle;
    }

    public static int classicSearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                start = middle + 1;
            }
            if (nums[middle] > target) {
                end = middle - 1;
            }
        }

        return -1;

    }

    public static int search(int[] nums, int target) {


        int head = 0;
        int tail = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            int middle = (tail + head) / 2;

            if (nums[middle] == target) {
                return middle;
            }
            if ((middle + 1) < nums.length && nums[middle + 1] == target) {
                return middle + 1;
            }

            if (nums[middle] < target) {
                head = middle;
            }
            if (nums[middle] > target) {
                tail = middle;
            }
        }


        return -1;
    }

    public static void insertionSort() {
        /*
for (int i = left + 1; i <= right; i++) {
    int key = array[i];
    int j = i - 1;
    while (j >= left && array[j] > key) {
        array[j + 1] = array[j];
        j--;
    }
    array[j + 1] = key;
}
        * */
    }
}
