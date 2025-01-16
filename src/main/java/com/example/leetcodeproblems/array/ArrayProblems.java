package com.example.leetcodeproblems.array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayProblems {


    public static BigInteger factorialIterative(int n, int start) {
        BigInteger result = new BigInteger("1");

        for (int i = 1 + start; i <= n; i++) { // Умножаем от 2 до n
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public int MaxConsecutiveOnes(int[] nums) {

        int currentcount = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (num != 0) {
                currentcount++;
            } else {
                currentcount = 0;
            }
            if (maxCount < currentcount) {
                maxCount = currentcount;
            }

        }
        return maxCount;
    }

    public int findNumbers(int[] nums) {

        int countEvenDigits = 0;
        for (int num : nums) {
            boolean even = String.valueOf(num).length() % 2 == 0;
            if (even) {
                countEvenDigits++;
            }

        }
        return countEvenDigits;
    }

    public int findNumbers_2(int[] nums) {

        int countEvenDigits = 0;
        for (int num : nums) {

            int cnt = 0;
            while (num != 0) {
                num = num / 10;
                cnt++;
            }

            if (cnt % 2 == 0) {
                countEvenDigits++;
            }


        }
        return countEvenDigits;
    }

    public int[] sortedSquares(int[] nums) {
        /*
         * Написать solution problem
         * */
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }


        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int min = nums[j];
                    nums[j] = nums[i];
                    nums[i] = min;
                }
            }
        }
        return nums;
    }

    public int[] sortedSquares_BigON(int[] nums) {
        /*
         * Написать solution problem
         * */
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int[] nums_2 = new int[nums.length];

        int firstPointer = 0;
        int lastPointer = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[firstPointer] > nums[lastPointer]) {
                nums_2[i] = nums[firstPointer];
                firstPointer++;
            } else {
                nums_2[i] = nums[lastPointer];
                lastPointer--;
            }
        }
        return nums_2;

    }

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                continue;
            }
            i++;
            for (int j = arr.length - 1; j >= i; j--) {
                arr[j] = arr[j - 1];
            }

        }
    }

    public void duplicateZeros_BigON(int[] arr) {
        int capacity = arr.length;
        int countZeros = 0;

        for (int i = 0; i < capacity; i++) {
            if (arr[i] == 0) {
                countZeros++;
            }
        }

        int index = capacity - 1;
        int indexCountZeros = capacity - 1 + countZeros;

        while (index >= 0) {

            if (indexCountZeros < capacity) {
                arr[indexCountZeros] = arr[index];
            }
            if (arr[index] == 0) {
                indexCountZeros--;
                if (indexCountZeros < capacity) {
                    arr[indexCountZeros] = arr[index];
                }
            }

            index--;
            indexCountZeros--;
        }

    }

    public void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {

        int indexm1 = m - 1;
        int indexm2 = n - 1;
        int index = m + n - 1;

        while (index >= 0) {
            if (indexm2 < 0) {
                break;
            }
            if (indexm1 < 0) {
                nums1[index] = nums2[indexm2];
                indexm2--;
            } else if (nums2[indexm2] > nums1[indexm1]) {
                nums1[index] = nums2[indexm2];
                indexm2--;
            } else {
                nums1[index] = nums1[indexm1];
                indexm1--;
            }
            index--;
        }


    }

    public int removeElement(int[] nums, int val) {

        int lastPointer = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] == val) {
                int replacedValue = nums[lastPointer];
                nums[lastPointer] = nums[i];
                nums[i] = replacedValue;
                lastPointer--;
            }
        }

        return lastPointer + 1;
    }

    public int removeDuplicatesFromSortedArray(int[] nums) {

        int duplicatedIndex = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] == nums[i] && duplicatedIndex == 0) {
                duplicatedIndex = i;
            }

            if (nums[i - 1] != nums[i] && duplicatedIndex != 0) {
                nums[duplicatedIndex] = nums[i];
                duplicatedIndex++;
            }

        }

        if (duplicatedIndex == 0) {
            return nums.length;
        }

        return duplicatedIndex;
    }

    public int removeDuplicatesFromSortedArray_BEST(int[] nums) {

        int unique = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[unique] != nums[i]) {
                unique++;

                nums[unique] = nums[i];
            }
        }
        return unique + 1;
    }

    public int binarySearch(int[] nums, int val) {

        int startIndex = 0;
        int lastIndex = nums.length - 1;

        while (startIndex <= lastIndex) {
            int midIndex = (startIndex + lastIndex) / 2;

            if (nums[midIndex] < val) {
                startIndex = midIndex + 1;
            }
            if (nums[midIndex] > val) {
                lastIndex = midIndex - 1;
            }
            if (nums[midIndex] == val) {
                return midIndex;
            }

        }

        return -1;

    }

    public boolean checkIfExist(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] * 2 == arr[j] || arr[i] == arr[j] * 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIfExistThroughMax(int[] arr) {

        int[] newArr = new int[2001];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] * 2 <= 1000 && arr[i] * 2 >= -1000 && newArr[1000 + (arr[i] * 2)] == 1) {
                return true;
            }
            if (arr[i] % 2 == 0 && newArr[1000 + (arr[i] / 2)] == 1) {
                return true;
            }

            newArr[1000 + arr[i]] = 1;

        }

        return false;
    }

    public boolean checkIfExistThroughHsh(int[] arr) {

        // todo решить
//        for (int num : nums) {
//            max = Math.max(max, Math.abs(num));
//        }
//
//         Хеш-массив для хранения чисел
//        boolean[] hash = new boolean[max * 2 + 1]; // Учитываем отрицательные индексы

        return false;
    }

    public boolean validMountainArray(int[] arr) {

        if (arr.length <= 2) {
            return false;
        }
        if (arr[0] >= arr[1]) {
            return false;
        }
        boolean down = false;

        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                down = true;
            }

            if (arr[i - 1] == arr[i]) {
                return false;
            }

            if (arr[i - 1] < arr[i] && down) {
                return false;
            }

        }

        return down;
    }

    public int[] replaceElements(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int max = i + 1;

            nested:
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[max] <= arr[j]) {
                    max = j;
                }
            }

            arr[i] = arr[max];

        }
        arr[arr.length - 1] = -1;

        return arr;


    }

    public int[] replaceElementsFast(int[] arr) {


        if (arr.length == 0) {
            return arr;
        }

        int max = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            int current = arr[i];

            arr[i] = max;

            if (current > max) {
                max = current;
            }

        }

        arr[arr.length - 1] = -1;

        return arr;
    }

    public void moveZeroes(int[] nums) {


        int zeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];
            nums[i] = nums[zeroIndex];
            nums[zeroIndex] = value;

            if (nums[zeroIndex] != 0) {
                zeroIndex++;
            }
        }

    }

    public void moveZeroesWithoutNonOrdered(int[] nums) {


        int last = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] == 0) {
                int value = nums[last];
                nums[last] = nums[i];
                nums[i] = value;
                last--;
            }

        }

    }

    public int[] sortArrayByParity(int[] nums) {

        int oddIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] % 2 == 1) {
                int value = nums[i];
                nums[i] = nums[oddIndex];
                nums[oddIndex] = value;
                oddIndex--;
            }

        }

        return nums;

    }

    public int[] sortArrayByParityLeftToRight(int[] nums) {


        int evenIndex = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 == 0) {
                int value = nums[i];
                nums[i] = nums[evenIndex];
                nums[evenIndex] = value;
                evenIndex++;
            }

        }
        return nums;

    }

    public int heightChecker(int[] heights) {

        int[] newHeights = new int[heights.length];

        for (int i = 0; i < newHeights.length; i++) {
            newHeights[i] = heights[i];
        }

        Arrays.sort(new int[]{1, 2, 3});

        for (int i = 0; i < newHeights.length; i++) {

            int minIndex = i;
            for (int j = i; j < heights.length; j++) {
                if (heights[minIndex] > heights[j]) {
                    minIndex = j;
                }
            }
            int value = heights[minIndex];
            heights[minIndex] = heights[i];
            heights[i] = value;
        }

        int count = 0;
        for (int i = 0; i < heights.length; i++) {

            if (newHeights[i] != heights[i]) {
                count++;
            }
        }


        return count;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        int[] newNums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            newNums[nums[i] - 1] = 1;
        }

        List<Integer> outputNums = new ArrayList<>();

        for (int i = 0; i < newNums.length; i++) {

            if (newNums[i] == 0) {
                outputNums.add(i + 1);
            }
        }

        return outputNums;
    }

    public List<Integer> findDisappearedNumbersBest(int[] nums) {

        int count = 1;
        List<Integer> outputNums = new ArrayList<>();

        while (count <= nums.length) {
            if (nums[count - 1] == count) {
                count++;
                continue;
            }
            int valueCurrent = nums[count - 1];
            int valueReplace = nums[valueCurrent - 1];

            if (valueCurrent == valueReplace) {
                count++;
                continue;
            }

            nums[valueCurrent - 1] = valueCurrent;
            nums[count - 1] = valueReplace;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                outputNums.add(i + 1);
            }
        }

        return outputNums;
    }

    public int thirdMax(int[] nums) {


        for (int i = 0; i < nums.length; i++) {
            int max = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[max] < nums[j]) {
                    max = j;
                }
            }
            int value = nums[i];
            int newValue = nums[max];
            nums[i] = newValue;
            nums[max] = value;

        }

        if (nums.length < 3) {
            return nums[0];
        }
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            count++;
            if (count == 3) {
                return nums[i];
            }
        }
        return nums[0];
    }

    public int thirdMaxFast(int[] nums) {


        long max = Long.MIN_VALUE;
        long maxPrev = Long.MIN_VALUE;
        long maxPrevPrev = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {


            int value = nums[i];

            if (max == nums[i] || maxPrev == nums[i] || maxPrevPrev == nums[i]) {
                continue;
            }
            if (max < value) {
                maxPrevPrev = maxPrev;
                maxPrev = max;
                max = value;
            } else if (maxPrev < value) {
                maxPrevPrev = maxPrev;
                maxPrev = value;
            } else if (maxPrevPrev < value) {
                maxPrevPrev = value;
            }
        }
        if (maxPrevPrev == Long.MIN_VALUE) {
            return (int) max;
        }
        return (int) maxPrevPrev;

    }

    public int dominantIndex(int[] nums) {
        int indexMax = 0;
        int indexMaxPrev = 1;

        if (nums[0] < nums[1]) {
            indexMaxPrev = indexMax;
            indexMax = 1;
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[indexMax] < nums[i]) {
                indexMaxPrev = indexMax;
                indexMax = i;
            } else if (nums[indexMaxPrev] < nums[i]) {
                indexMaxPrev = i;
            }
        }
        if (nums[indexMaxPrev] == 0) {
            return indexMax;
        }

        if (nums[indexMax] / nums[indexMaxPrev] >= 2) {
            return indexMax;
        }
        return -1;
    }

    public int pivotIndex(int[] nums) {

        int rightSum = 0;
        int leftSum = 0;

        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        if (leftSum == rightSum) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            rightSum -= nums[i];
            leftSum += nums[i - 1];

            if (leftSum == rightSum) {
                return i;
            }

        }

        return -1;

    }

    public int[] plusOne(int[] digits) {
        int one = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int value = (digits[i] + one);
            one = value >= 10 ? 1 : 0;
            digits[i] = value % 10;
        }

        if (one == 0) {
            return digits;
        }

        int[] nums = new int[digits.length + 1];
        nums[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            nums[i + 1] = digits[i];
        }
        return nums;
    }

    public List<Integer> spiralOrder(int[][] matrix) {


        int row = matrix.length;
        int column = matrix[0].length;

        int rowBegin = 0;
        int rowEnd = row - 1;

        int colBegin = 0;
        int colEnd = column - 1;

        List<Integer> l = new ArrayList<>();

        while (true) {

            if (colEnd - colBegin < 0) {
                return l;
            }

            for (int i = 0; i <= colEnd - colBegin; i++) {

                int j = matrix[rowBegin][colBegin + i];
                l.add(j);

            }
            rowBegin++;

            if (rowEnd - rowBegin < 0) {
                return l;
            }

            for (int i = 0; i <= rowEnd - rowBegin; i++) {

                int j = matrix[rowBegin + i][colEnd];
                l.add(j);

            }
            colEnd--;

            if (colEnd - colBegin < 0) {
                return l;
            }

            for (int i = 0; i <= colEnd - colBegin; i++) {
                int j = matrix[rowEnd][colEnd - i];
                l.add(j);

            }
            rowEnd--;

            if (rowEnd - rowBegin < 0) {
                return l;
            }

            for (int i = 0; i <= rowEnd - rowBegin; i++) {
                int j = matrix[rowEnd - i][colBegin];
                l.add(j);
            }
            colBegin++;
        }


    }

    public List<Integer> spiralOrderBest(int[][] matrix) {

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;

        int columnBegin = 0;
        int columnEnd = matrix[0].length - 1;

        int dir = 0;

        List<Integer> results = new ArrayList<>();

        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {

            switch (dir) {
                case 0:
                    for (int column = columnBegin; column <= columnEnd; column++) {
                        results.add(matrix[rowBegin][column]);
                    }
                    rowBegin++;
                    break;
                case 1:
                    for (int row = rowBegin; row <= rowEnd; row++) {
                        results.add(matrix[row][columnEnd]);
                    }
                    columnEnd--;
                    break;
                case 2:
                    for (int column = columnEnd; column >= columnBegin; column--) {
                        results.add(matrix[rowEnd][column]);
                    }
                    rowEnd--;
                    break;
                case 3:
                    for (int row = rowEnd; row >= rowBegin; row--) {
                        results.add(matrix[row][columnBegin]);
                    }
                    columnBegin++;
                    break;
            }
            dir = (dir + 1) % 4;

        }
        return results;


    }

    public List<List<Integer>> generateTriangles(int numRows) {

        List<List<Integer>> triangles = new ArrayList<>();
        if (numRows >= 1) {
            triangles.add(List.of(1));
        }
        if (numRows >= 2) {
            triangles.add(List.of(1, 1));
        }
        if (numRows <= 2) {
            return triangles;
        }

        int count = 3;
        while (count <= numRows) {
            List<Integer> previous = triangles.get(triangles.size() - 1);
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < count; i++) {

                if (i == 0 || i + 1 == count) {
                    row.add(1);
                    continue;
                }
                int value = previous.get(i) + previous.get(i - 1);
                row.add(value);
            }
            triangles.add(row);
            count++;
        }

        return triangles;
    }

    public List<Integer> getRow(int rowIndex) {

        Integer[] row = new Integer[rowIndex + 1];
        row[0] = 1;
        if (rowIndex == 0) {
            return Arrays.asList(row);
        }
        row[1] = 1;
        if (rowIndex == 1) {
            return Arrays.asList(row);

        }

        int startPointer = 1;
        int endPointer = rowIndex - 1;


        while (startPointer <= endPointer) {

            BigInteger formula = (factorialIterative(rowIndex, rowIndex - startPointer)).divide(factorialIterative(startPointer, 0));
            row[startPointer] = formula.intValue();
            row[endPointer] = formula.intValue();
            ;

            startPointer++;
            endPointer--;
        }

        row[rowIndex] = 1;
        System.out.println(Arrays.asList(row));
        return Arrays.asList(row);
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int rowLength = mat.length;
        int columnLength = mat[0].length;
        int[] values = new int[rowLength * columnLength];

        int count = 0;
        int dir = 0;

        int pointRowStart = 0;
        int pointColumnStart = 0;
        int point = 0;

        while (true) {
            int copyCount = count;
            int startColumn = pointColumnStart;
            int startRow = Math.min(point, rowLength - 1);
            int step = Math.min(point, (columnLength - 1) - pointColumnStart);

            for (int i = step; i >= 0; i--) {
                if (dir == 0) {
                    values[count] = mat[startRow--][startColumn++];
                } else {
                    values[copyCount + i] = mat[startRow--][startColumn++];
                }
                count++;
            }

            if (count > rowLength * columnLength - 1) {
                System.out.println(Arrays.toString(values));
                return values;
            }
            if (point < rowLength - 1) {
                point++;
            } else {
                pointColumnStart++;
            }

            dir = (dir + 1) % 2;

        }
    }


}
