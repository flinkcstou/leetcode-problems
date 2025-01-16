package com.example.leetcodeproblems.array;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class StringProblems {

    // "static void main" must be defined in a public class.
    public static void main(String[] args) {
        // initialize
//        String s1 = "Hello World";
//        System.out.println("s1 is \"" + s1 + "\"");
//        String s2 = s1;
//        System.out.println("s2 is another reference to s1.");
//        String s3 = new String(s1);
//        System.out.println("s3 is a copy of s1.");
//        // compare using '=='
//        System.out.println("Compared by '==':");
//        // true since string is immutable and s1 is binded to "Hello World"
//        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
//        // true since s1 and s2 is the reference of the same object
//        System.out.println("s1 and s2: " + (s1 == s2));
//        // false since s3 is refered to another new object
//        System.out.println("s1 and s3: " + (s1 == s3));
//        // compare using 'equals'
//        System.out.println("Compared by 'equals':");
//        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
//        System.out.println("s1 and s2: " + s1.equals(s2));
//        System.out.println("s1 and s3: " + s1.equals(s3));
//        // compare using 'compareTo'
//        System.out.println("Compared by 'compareTo':");
//        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
//        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
//        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));
//
//        String asd = "01";
//
//        System.out.println((int) (asd.charAt(0) + asd.charAt(1)));
//        System.out.println((int) (asd.charAt(0) == 49 ? 1 : 0));
//        System.out.println((int) (asd.charAt(1)));
//
//        addBinary("1000", "0010");

//        System.out.println(addBinaryTheWorst("1000", "0010"));
//        System.out.println(addBinaryTheWorst("1000", "0010"));

//        System.out.println(strStr("mississippi", "issip"));


//        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));


//        arrayPairSum(new int[]{2, 3, 1, 1, 5, 6, 6, 4, 4, 9});
//        arrayPairSumBest(new int[]{2, 3, 1, 1, 5, 6, 6, 4, 4, 9, 2, 2});
//
//        twoSum(new int[]{2, 7, 11, 15}, 9);
//        twoSum(new int[]{2, 3, 4}, 6);
//        twoSum(new int[]{-1, 0}, -1);

//        System.out.println(minSubArrayLenBest(3, new int[]{2, 3, 3}));
//        System.out.println(minSubArrayLenBest(3, new int[]{1, 1, 1}));
//        System.out.println(minSubArrayLenBest(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
//        System.out.println(minSubArrayLenBest(4, new int[]{1, 4, 4}));
//        System.out.println(minSubArrayLenBest(7, new int[]{2, 3, 1, 2, 4, 3}));
//        System.out.println(minSubArrayLenBest(7, new int[]{1, 2, 4, 3}));
//        System.out.println(minSubArrayLenBest(213, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}));
//        rotateBestTheBest(new int[]{1, 2, 3}, 2);
//        rotateBestTheBest(new int[]{1, 2, 3, 4, 5, 6, 7}, 0);
//        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
//        rotateBest(a, 5);
//        System.out.println(Arrays.toString(a));

//        reverseWords2("   way asd    asdf sdf sdf sdf fdsfsdfwefdsf dsfdsfds     dsfdsfdsfds   ");
        reverseWords2("Let's take LeetCode contest");
    }

    public static String addBinary(String a, String b) {
        StringBuilder binariesBuilder = new StringBuilder();
        int pointerA = a.length() - 1;
        int pointerB = b.length() - 1;

        int vacume = 0;

        while (true) {
            int aNum = 0;
            int bNum = 0;
            if (pointerA >= 0) {
                aNum = a.charAt(pointerA) == 48 ? 0 : 1;
            }
            if (pointerB >= 0) {
                bNum = b.charAt(pointerB) == 48 ? 0 : 1;
            }

            vacume = switch (vacume + aNum + bNum) {
                case 0 -> {
                    binariesBuilder.append("0");
                    yield 0;
                }
                case 1 -> {
                    binariesBuilder.append("1");
                    yield 0;
                }
                case 2 -> {
                    binariesBuilder.append("0");
                    yield 1;
                }
                case 3 -> {
                    binariesBuilder.append("1");
                    yield 1;
                }
                default -> vacume;
            };

            if (pointerA <= 0 && pointerB <= 0 && vacume <= 0) {
                break;
            }
            pointerA--;
            pointerB--;
        }

        return binariesBuilder.reverse().toString();
    }


    public static String addBinaryBest(String a, String b) {
        StringBuilder binariesBuilder = new StringBuilder();
        int pointerA = a.length() - 1;
        int pointerB = b.length() - 1;

        int vacume = 0;

        while (pointerA >= 0 || pointerB >= 0 || vacume == 1) {
            if (pointerA >= 0) {
                vacume += a.charAt(pointerA) - '0';
            }
            if (pointerB >= 0) {
                vacume += b.charAt(pointerB) - '0';
            }
            binariesBuilder.append(vacume % 2);
            vacume = vacume / 2;

            pointerA--;
            pointerB--;
        }

        return binariesBuilder.reverse().toString();
    }


    public static String addBinaryTheWorst(String a, String b) {

        // Convert binary string to BigInteger
        BigInteger binaryAsBigInteger = new BigInteger(a, 2);
        BigInteger binaryAsBigInteger2 = new BigInteger(b, 2);

        // Convert BigInteger to BigDecimal
        BigDecimal binaryAsBigDecimal = new BigDecimal(binaryAsBigInteger);
        BigDecimal binaryAsBigDecimal2 = new BigDecimal(binaryAsBigInteger2);

        BigDecimal c = binaryAsBigDecimal.add(binaryAsBigDecimal2);

        return c.toBigInteger().toString(2);
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        char[] hayStackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();

        for (int i = 0; i <= hayStackChar.length - needleChar.length; i++) {

            int count = i;
            looped:
            for (int j = 0; j < needleChar.length; j++) {
                if (hayStackChar[count++] != needleChar[j]) {
                    break looped;
                }
                if (j == needleChar.length - 1) {
                    return i;
                }
            }

        }

        return -1;
    }

    public static int strStrBest(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        for (int i = 0; i <= haystackLength - needleLength; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                String str = haystack.substring(i, i + needleLength);
                if (str.equals(needle)) {
                    return i;
                }
            }

        }

        return -1;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i <= strs[0].length(); i++) {

            for (int j = 1; j < strs.length; j++) {

                if (i <= strs[j - 1].length() && i <= strs[j].length()) {
                    if (!strs[j - 1].substring(0, i).equals(strs[j].substring(0, i))) {
                        return strs[j - 1].substring(0, i - 1);
                    }
                } else {
                    return strs[j - 1].substring(0, i - 1);
                }

            }
        }

        return strs[0];
    }


    public static void reverseString(char[] s) {

        int last = s.length - 1;
        for (int i = 0; i < s.length && i <= last; i++, last--) {

            char value = s[i];
            char valueLast = s[last];
            s[last] = value;
            s[i] = valueLast;

        }
    }


    public static int arrayPairSum(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                if (nums[i] >= nums[j]) {
                    int maxValue = nums[i];
                    int value = nums[j];

                    nums[i] = value;
                    nums[j] = maxValue;
                }

            }
        }


        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {

            sum += Math.min(nums[i], nums[i + 1]);
        }

        return sum;
    }

    public static int arrayPairSumBest(int[] nums) {

        int N = 10_000;
        int minIndex = nums[0] + N;
        int maxIndex = nums[0] + N;
        int[] sortedArray = new int[(2 * N) + 1];

        for (int i = 0; i < nums.length; i++) {
            sortedArray[nums[i] + N] = sortedArray[nums[i] + N] + 1;
            minIndex = Math.min(minIndex, nums[i] + N);
            maxIndex = Math.max(maxIndex, nums[i] + N);
        }


        boolean odd = true;
        int sum = 0;
        for (int i = minIndex; i <= maxIndex; i++) {
            while (sortedArray[i] > 0) {
                if (odd) {
                    sum += i - N;
                }
                odd = !odd;
                sortedArray[i] = sortedArray[i] - 1;
            }
        }

        return sum;
    }

    public static int[] twoSum(int[] numbers, int target) {

        int maxIndex = numbers.length - 1;


        for (int i = 0; i <= maxIndex; i++) {
            looped:
            for (int j = maxIndex; j > i; j--) {
                if (numbers[i] + numbers[j] < target) {
                    break looped;
                }
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }


        return new int[]{};

    }

    public static int[] twoSumBest(int[] numbers, int target) {

        int firstPointer = 0;
        int lastPointer = numbers.length - 1;

        while (firstPointer <= lastPointer) {

            if (numbers[firstPointer] + numbers[lastPointer] < target) {
                firstPointer++;
                continue;
            }
            if (numbers[firstPointer] + numbers[lastPointer] > target) {
                lastPointer--;
                continue;
            }
            return new int[]{firstPointer + 1, lastPointer + 1};

        }

        return new int[]{};

    }

    public static int minSubArrayLen(int target, int[] nums) {
//        1,2,4,3
        int minCount = nums.length;
        boolean accumulated = false;
        int sum = 0;
        int count = 0;
        int startIndex = 0;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return 1;
            }
            sum += nums[i];
            count++;
            if (sum >= target) {
                accumulated = true;
                minCount = Math.min(minCount, count);

                sum = 0;
                count = 0;
                i = ++startIndex;
            }

        }
        if (accumulated) {
            return minCount;
        }
        return 0;

    }

    public static int minSubArrayLenBest(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return 1;
            }
            sum += nums[i];

            while (sum >= target) {
                minLength = Math.min(minLength, (i - left) + 1);
                sum -= nums[left++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }

    public static void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        if (nums.length < k) {
            k = k % nums.length;
        }
        int[] cutted = new int[k];
        int cuttedCount = 0;

        for (int i = nums.length - k; i < nums.length; i++) {
            cutted[cuttedCount++] = nums[i];
        }

        for (int i = nums.length - k - 1; i >= 0; i--) {

            int kIndex = i + k;
            int value = nums[i];
            int kValue = nums[kIndex];
            nums[i] = kValue;
            nums[kIndex] = value;


        }

        for (int i = 0; i < cuttedCount; i++) {
            nums[i] = cutted[i];
        }
        System.out.println(Arrays.toString(cutted));
        System.out.println(Arrays.toString(nums));


    }

    public static void rotateBest(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        if (nums.length <= k) {
            k = k % nums.length;
        }
        if (k == 0) {
            return;
        }
        int startPosition = 0;


        for (int i = 0; i < nums.length; ) {
            startPosition = i;

            int kIndex = nums.length - k;

            while (kIndex < nums.length && i < nums.length) {

                int value = nums[i];
                int kValue = nums[kIndex];

                nums[i] = kValue;
                nums[kIndex] = value;

                kIndex++;
                i++;
            }

            int rightCount = k;
            int leftCount = nums.length - rightCount - startPosition;

            if (rightCount == leftCount) {
                return;
            }
            if (rightCount > leftCount) {
                if (rightCount % leftCount == 0) {
                    return;
                }
                k = rightCount % leftCount;
            }


        }
        System.out.println(Arrays.toString(nums));

    }

    public static void rotateBestTheBest(int[] nums, int k) {
        rotateReverse(0, nums.length - 1, nums);
        rotateReverse(0, k - 1, nums);
        rotateReverse(k, nums.length - 1, nums);

        System.out.println(Arrays.toString(nums));

    }

    public static void rotateReverse(int start, int last, int[] nums) {

        while (start <= last) {

            int startValue = nums[start];
            int lastValue = nums[last];

            nums[start] = lastValue;
            nums[last] = startValue;

            start++;
            last--;
        }

    }

    public static void rotateSwap(int[] nums, int start, int end) {
        // todo nabu check it with rotateReverse
        System.out.println((end - start) / 2);
        for (int i = 0; i < (end - start + 1) / 2; i++) {
            int temp = nums[i + start];
            nums[i + start] = nums[end - i];
            nums[end - i] = temp;

        }
    }

    public static String reverseWords(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else if (count != 0) {
                if (!stringBuilder.isEmpty()) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(s, i + 1, i + count + 1);
                count = 0;
            }
            if (s.charAt(i) != ' ' && i == 0) {
                if (!stringBuilder.isEmpty()) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(s, i, i + count);
                count = 0;
            }

        }

        return stringBuilder.toString();
    }

    public static String reverseWords2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                start++;
            }
            if (s.charAt(i) == ' ') {
                if (start != 0) {
                    stringBuilder.append(reverseStringChar(s, i - start, i - 1));
                }
                stringBuilder.append(" ");
                start = 0;
            }
            if (s.charAt(i) != ' ' && i >= s.length() - 1) {
                stringBuilder.append(reverseStringChar(s, i - start, i));
                start = 0;
            }
        }

        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

    public static String reverseStringChar(String s, int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        while (end >= start) {
            stringBuilder.append(s.charAt(end--));
        }
        return stringBuilder.toString();
    }

    class MyHashSet {
        int[] buckets = new int[1000001];

        public MyHashSet() {

        }

        public void add(int key) {
            buckets[key] = 1;
        }


        public void remove(int key) {
            buckets[key] = 0;
        }

        public boolean contains(int key) {
            if (buckets[key] == 1) {
                return true;
            }
            return false;
        }
    }

    class MyHashMap {
        int[] buckets = new int[1000001];

        public MyHashMap() {

        }

        public void put(int key, int value) {
            if (value == 0) {
                this.buckets[key] = -1;
            } else {
                this.buckets[key] = value;
            }
        }

        public int get(int key) {
            if (this.buckets[key] == 0) {
                return -1;
            } else if (this.buckets[key] == -1) {
                return 0;
            } else {
                return this.buckets[key];

            }

        }

        public void remove(int key) {
            this.buckets[key] = 0;
        }
    }




}
