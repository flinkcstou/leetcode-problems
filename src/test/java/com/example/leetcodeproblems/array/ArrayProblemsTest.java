package com.example.leetcodeproblems.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class ArrayProblemsTest {

    /*
    планированием решения или псевдокодом
    "Проработка решения"
    "Декомпозиция задачи"
    "Разработка плана"
    "Написание псевдокода"


    * */

    @Test
    void MaxConsecutiveOnes() {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};

        int i = new ArrayProblems().MaxConsecutiveOnes(nums);

        System.out.println(i);
        Assertions.assertThat(i).isEqualTo(3);


        nums = new int[]{1, 0, 1, 1, 0, 1};

        int i2 = new ArrayProblems().MaxConsecutiveOnes(nums);

        System.out.println(i2);
        Assertions.assertThat(i2).isEqualTo(2);


    }

    @Test
    void findNumbers() {

        int[] nums = new int[]{12, 345, 2, 6, 7896};

        int i = new ArrayProblems().findNumbers(nums);
        Assertions.assertThat(i).isEqualTo(2);

        nums = new int[]{555, 901, 482, 1771};

        int i2 = new ArrayProblems().findNumbers(nums);

        Assertions.assertThat(i2).isEqualTo(1);
    }

    @Test
    void findNumbers_2() {
        int[] nums = new int[]{12, 345, 2, 6, 7896};

        System.out.println(1 / 10);

        int i = new ArrayProblems().findNumbers_2(nums);
        Assertions.assertThat(i).isEqualTo(2);

        nums = new int[]{555, 901, 482, 1771};

        int i2 = new ArrayProblems().findNumbers(nums);

        Assertions.assertThat(i2).isEqualTo(1);
    }


    @Test
    void sortedSquares() {
        int[] nums = new int[]{-4, -1, 0, 3, 10};

        int[] ints = new ArrayProblems().sortedSquares(nums);

        System.out.println(Arrays.toString(ints));

        Assertions.assertThat(ints).containsExactly(new int[]{0, 1, 9, 16, 100});

        nums = new int[]{-7, -3, 2, 3, 11};

        ints = new ArrayProblems().sortedSquares(nums);

        Assertions.assertThat(ints).containsExactly(new int[]{4, 9, 9, 49, 121});

    }

    @Test
    void sortedSquares_BigON() {
        int[] nums = new int[]{-4, -1, 0, 3, 10};

        int[] ints = new ArrayProblems().sortedSquares_BigON(nums);

        System.out.println(Arrays.toString(ints));

        Assertions.assertThat(ints).containsExactly(new int[]{0, 1, 9, 16, 100});

        nums = new int[]{-7, -3, 2, 3, 11};

        ints = new ArrayProblems().sortedSquares_BigON(nums);

        Assertions.assertThat(ints).containsExactly(new int[]{4, 9, 9, 49, 121});

    }

    @Test
    void duplicateZeros() {
        int[] nums = new int[]{1, 0, 2, 3, 0, 4, 5, 0};

        new ArrayProblems().duplicateZeros(nums);

        System.out.println(Arrays.toString(nums));

        Assertions.assertThat(nums).containsExactly(new int[]{1, 0, 0, 2, 3, 0, 0, 4});

        nums = new int[]{1, 2, 3};

        new ArrayProblems().duplicateZeros(nums);

        Assertions.assertThat(nums).containsExactly(new int[]{1, 2, 3});

    }

    @Test
    void duplicateZeros_BigON() {

        int[] nums = new int[]{9, 9, 9, 4, 8, 0, 0, 3, 7, 2, 0, 0, 0, 0, 9, 1, 0, 0, 1, 1, 0, 5, 6, 3, 1, 6, 0, 0, 2, 3, 4, 7, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 7, 3, 3, 0, 5, 7, 0, 8, 1, 9, 6, 3, 0, 8, 8, 8, 8, 0, 0, 5, 0, 0, 0, 3, 7, 7, 7, 7, 5, 1, 0, 0, 8, 0, 0};

        new ArrayProblems().duplicateZeros_BigON(nums);

        Assertions.assertThat(nums).containsExactly(new int[]{9, 9, 9, 4, 8, 0, 0, 0, 0, 3, 7, 2, 0, 0, 0, 0, 0, 0, 0, 0, 9, 1, 0, 0, 0, 0, 1, 1, 0, 0, 5, 6, 3, 1, 6, 0, 0, 0, 0, 2, 3, 4, 7, 0, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 0, 0, 7, 3, 3, 0, 0, 5, 7, 0, 0, 8, 1, 9, 6, 3, 0, 0, 8, 8, 8, 8, 0});

//        int[] nums = new int[]{8,4,5,0,0,0,0,7};
//
//        new ArrayProblems().duplicateZeros_BigON(nums);
//
//        Assertions.assertThat(nums).containsExactly(new int[]{8,4,5,0,0,0,0,0});

//        int[] nums = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
//
//        new ArrayProblems().duplicateZeros_BigON(nums);
//
//        System.out.println(Arrays.toString(nums));
//
//        Assertions.assertThat(nums).containsExactly(new int[]{1, 0, 0, 2, 3, 0, 0, 4});
//
//        nums = new int[]{1, 2, 3};
//
//        new ArrayProblems().duplicateZeros_BigON(nums);
//
//        Assertions.assertThat(nums).containsExactly(new int[]{1, 2, 3});


    }


    @Test
    void mergeSortedArray() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;

        new ArrayProblems().mergeSortedArray(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        Assertions.assertThat(nums1).containsExactly(new int[]{1, 2, 2, 3, 5, 6});


        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[]{};
        n = 0;

        new ArrayProblems().mergeSortedArray(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        Assertions.assertThat(nums1).containsExactly(new int[]{1});

        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;

        new ArrayProblems().mergeSortedArray(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        Assertions.assertThat(nums1).containsExactly(new int[]{1});
    }

    @Test
    void removeElement() {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;

        int i = new ArrayProblems().removeElement(nums, val);

        System.out.println(Arrays.toString(nums));

        for (int j = 0; j <= i; j++) {
            Assertions.assertThat(nums[j]).isNotEqualTo(val);
        }

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;

        i = new ArrayProblems().removeElement(nums, val);

        System.out.println(Arrays.toString(nums));

        for (int j = 0; j <= i; j++) {
            Assertions.assertThat(nums[j]).isNotEqualTo(val);
        }

        nums = new int[]{3, 2, 2, 3};
        val = 3;

        i = new ArrayProblems().removeElement(nums, val);

        System.out.println(Arrays.toString(nums));
        System.out.println(i);

        for (int j = 0; j <= i; j++) {
            Assertions.assertThat(nums[j]).isNotEqualTo(val);
        }

    }

    @Test
    void removeDuplicatesFromSortedArray() {

        int[] nums = new int[]{1, 1, 2};

        int i = new ArrayProblems().removeDuplicatesFromSortedArray(nums);

        System.out.println(Arrays.toString(nums));
        System.out.println(i);

        Assertions.assertThat(i).isEqualTo(2);


        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        i = new ArrayProblems().removeDuplicatesFromSortedArray(nums);

        System.out.println(Arrays.toString(nums));
        Assertions.assertThat(i).isEqualTo(5);
        System.out.println(i);

    }

    @Test
    void removeDuplicatesFromSortedArray_BEST() {

        int[] nums = new int[]{1, 1, 2};

        int i = new ArrayProblems().removeDuplicatesFromSortedArray_BEST(nums);

        System.out.println(Arrays.toString(nums));
        System.out.println(i);

        Assertions.assertThat(i).isEqualTo(2);


        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        i = new ArrayProblems().removeDuplicatesFromSortedArray_BEST(nums);

        System.out.println(Arrays.toString(nums));
        Assertions.assertThat(i).isEqualTo(5);
        System.out.println(i);

    }


    @Test
    void binarySearch() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        int val = 13;
        int i = new ArrayProblems().binarySearch(nums, val);

        System.out.println(i);

        Assertions.assertThat(i).isEqualTo(12);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        val = 10;
        i = new ArrayProblems().binarySearch(nums, val);

        System.out.println(i);

        Assertions.assertThat(i).isEqualTo(-1);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        val = 1;
        i = new ArrayProblems().binarySearch(nums, val);

        System.out.println(i);

        Assertions.assertThat(i).isEqualTo(0);


        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        val = 20;
        i = new ArrayProblems().binarySearch(nums, val);

        System.out.println(i);

        Assertions.assertThat(i).isEqualTo(18);

    }

    @Test
    void checkIfExist() {

        int[] nums = new int[]{10, 2, 5, 3};
        boolean b = new ArrayProblems().checkIfExist(nums);

        Assertions.assertThat(b).isEqualTo(true);


        nums = new int[]{3, 1, 7, 11};
        b = new ArrayProblems().checkIfExist(nums);

        Assertions.assertThat(b).isEqualTo(false);

    }

    @Test
    void checkIfExistThroughMax() {

        int[] nums = new int[]{10, 2, 5, 3};
        boolean b = new ArrayProblems().checkIfExistThroughMax(nums);

        Assertions.assertThat(b).isEqualTo(true);

        nums = new int[]{2, 5, 3, 10};
        b = new ArrayProblems().checkIfExistThroughMax(nums);

        Assertions.assertThat(b).isEqualTo(true);


        nums = new int[]{3, 1, 7, 11};
        b = new ArrayProblems().checkIfExistThroughMax(nums);

        Assertions.assertThat(b).isEqualTo(false);

    }

    @Test
    void validMountainArray() {

        int[] nums = new int[]{2, 1};
        boolean b = new ArrayProblems().validMountainArray(nums);

        Assertions.assertThat(b).isEqualTo(false);

        nums = new int[]{3, 5, 5};
        b = new ArrayProblems().validMountainArray(nums);

        Assertions.assertThat(b).isEqualTo(false);


        nums = new int[]{0, 3, 2, 1};
        b = new ArrayProblems().validMountainArray(nums);

        Assertions.assertThat(b).isEqualTo(true);

    }

    @Test
    void replaceElements() {

        int[] nums = new int[]{17, 18, 5, 4, 6, 1};

        new ArrayProblems().replaceElements(nums);

        Assertions.assertThat(nums).containsExactly(new int[]{18, 6, 6, 6, 1, -1});


        nums = new int[]{400};

        new ArrayProblems().replaceElements(nums);

        Assertions.assertThat(nums).containsExactly(new int[]{-1});


    }

    @Test
    void replaceElementsFast() {

        int[] nums = new int[]{17, 18, 5, 4, 6, 1};

        new ArrayProblems().replaceElementsFast(nums);

        Assertions.assertThat(nums).containsExactly(new int[]{18, 6, 6, 6, 1, -1});


        nums = new int[]{400};

        new ArrayProblems().replaceElementsFast(nums);

        Assertions.assertThat(nums).containsExactly(new int[]{-1});


    }

    @Test
    void moveZeroes() {

        int[] nums = new int[]{0, 1, 0, 3, 12};

        new ArrayProblems().moveZeroes(nums);

        Assertions.assertThat(nums).containsExactly(new int[]{1, 3, 12, 0, 0});


        nums = new int[]{0};

        new ArrayProblems().moveZeroes(nums);

        Assertions.assertThat(nums).containsExactly(new int[]{0});


    }

    @Test
    void moveZeroesWithoutNonOrdered() {

        int[] nums = new int[]{0, 1, 0, 3, 12};

        new ArrayProblems().moveZeroesWithoutNonOrdered(nums);

        Assertions.assertThat(nums).containsExactly(new int[]{3, 1, 12, 0, 0});


        nums = new int[]{0};

        new ArrayProblems().moveZeroesWithoutNonOrdered(nums);

        Assertions.assertThat(nums).containsExactly(new int[]{0});

        Map<String, String> requestParameters = Collections.unmodifiableMap(new HashMap());

    }

    @Test
    void sortArrayByParity() {


        int[] nums = new int[]{3, 1, 2, 4};

        new ArrayProblems().sortArrayByParity(nums);

        int[] firstTwo = Arrays.copyOfRange(nums, 0, nums.length - 2);
        int[] lastTwo = Arrays.copyOfRange(nums, nums.length - 2, nums.length);

        Assertions.assertThat(firstTwo).contains(new int[]{2, 4});
        Assertions.assertThat(firstTwo).contains(new int[]{4, 2});
        Assertions.assertThat(lastTwo).contains(new int[]{3, 1});
        Assertions.assertThat(lastTwo).contains(new int[]{1, 3});


        nums = new int[]{0};

        new ArrayProblems().sortArrayByParity(nums);

        Assertions.assertThat(nums).containsExactly(new int[]{0});

    }

    @Test
    void sortArrayByParityLeftToRight() {

        int[] nums = new int[]{3, 1, 2, 4};

        new ArrayProblems().sortArrayByParityLeftToRight(nums);

        int[] firstTwo = Arrays.copyOfRange(nums, 0, nums.length - 2);
        int[] lastTwo = Arrays.copyOfRange(nums, nums.length - 2, nums.length);

        Assertions.assertThat(firstTwo).contains(new int[]{2, 4});
        Assertions.assertThat(firstTwo).contains(new int[]{4, 2});
        Assertions.assertThat(lastTwo).contains(new int[]{3, 1});
        Assertions.assertThat(lastTwo).contains(new int[]{1, 3});


        nums = new int[]{0};

        new ArrayProblems().sortArrayByParityLeftToRight(nums);

        Assertions.assertThat(nums).containsExactly(new int[]{0});

    }

    @Test
    void heightChecker() {

        int[] nums = new int[]{5, 1, 2, 3, 4};

        new ArrayProblems().heightChecker(nums);


    }

    @Test
    void findDisappearedNumbersBest() {

        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};

        // 4 3 2 7 8 2 3 1
        // 1 3 2 7 8 2 3 4
        // 1 3 2 4 8 2 3 7
        // 1 3 2 4 8 2 7 3
        // 1 3 3 4 8 2 7 2
        // 1 2 3 4 8 2 7 3
        //


        new ArrayProblems().findDisappearedNumbersBest(nums);


    }

    @Test
    void thirdMax() {

        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};

        // 4 3 2 7 8 2 3 1
        // 1 3 2 7 8 2 3 4
        // 1 3 2 4 8 2 3 7
        // 1 3 2 4 8 2 7 3
        // 1 3 3 4 8 2 7 2
        // 1 2 3 4 8 2 7 3
        //


        new ArrayProblems().thirdMaxFast(nums);

        System.out.println(Arrays.toString(nums));


    }

    @Test
    void pivotIndex() {
        int[] nums = new int[]{-1, -1, -1, -1, -1, 0};

        new ArrayProblems().pivotIndex(nums);

        System.out.println(8 % 10);
        System.out.println(10 % 10);

    }

    @Test
    void spiralOrder() {
        int[][] nums = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        new ArrayProblems().spiralOrder(nums);


    }

    @Test
    void spiralOrderBest() {
        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        new ArrayProblems().spiralOrderBest(nums);


    }

    @Test
    void generateTriangles() {


        new ArrayProblems().generateTriangles(5);
        new ArrayProblems().getRow(33);


    }


    @Test
    void findDiagonalOrder() {

        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] mat1 = new int[][]{{2, 3}};
        int[][] mat2 = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        int[][] mat3 = new int[][]{{1, 2, 3, 4, 5}, {6,7,8,9,10}};

        new ArrayProblems().findDiagonalOrder(mat);
        new ArrayProblems().findDiagonalOrder(mat1);
        new ArrayProblems().findDiagonalOrder(mat2);
        new ArrayProblems().findDiagonalOrder(mat3);


    }

}