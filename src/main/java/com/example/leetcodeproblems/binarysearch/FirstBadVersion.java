package com.example.leetcodeproblems.binarysearch;

public class FirstBadVersion {

    public static void main(String[] args) {
        int i = firstBadVersion2(5);
        System.out.println(2);
    }

    public static boolean isBadVersion(int version) {
        return version >= 3;
    }

    public static int firstBadVersion2(int n) {


        int start = 1;
        int end = n;

        while (start < end) {
            int middle = start + (end - start) / 2;

            boolean badVersion = isBadVersion(middle);
            if (badVersion) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return end;
    }

    public static int firstBadVersion(int n) {


        int start = 1;
        int end = n;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            boolean badVersion = isBadVersion(middle);
            if (badVersion) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return end;
    }
}
