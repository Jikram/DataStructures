package com.ji.general.lc.others;

import java.util.HashMap;
import java.util.Map;

//leetcode#525
//input nums = [0,1,0] Output: 2, input [0,1] output 2
public class ContagiousSubarray {
    public static void main(String[] args) {
        System.out.println("Output : " + findMaxLength(new int[]{0, 1, 0}));
        System.out.println("Output : " + findMaxLengthEfficient(new int[]{0, 1, 0}));
        System.out.println("Output : " + findMaxLengthEfficient(new int[]{0, 1, 1, 0, 0, 1, 1}));
        System.out.println("Output lc 325: " + maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
        System.out.println("Output lc 325: " + maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));
        System.out.println("Output lc 209: " + minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("Output lc 209: " + minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    // Brute force approach O(n2)
    public static int findMaxLength(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
                if (zeroCount == oneCount) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // Efficient O(n) approach
    public static int findMaxLengthEfficient(int[] nums) {
        // [0,1,0]
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //map.put(0, -1);
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count += -1;
            } else {
                count += 1;
            }

            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return max;
    }

    // Leetcode#325 Input: nums = [1,-1,5,-2,3], k = 3 Output: 4
    // [-2, -1, 2, 1], k = 1 output  = 2
    public static int maxSubArrayLen(int[] nums, int k) {
        /*
        The core idea is, as you go on calculating sum by adding each value to global sum, check whether sum-k is already present. And in order to keep track of sum-k:
        1)  If sum-k is already present in the hashmap then don't modify it. This is because we want longest subarray.
        2)  Since array starts from 0 hence I have put (0, -1) before starting the calculation. For example if I find sum = k at index 3, then sum-k = 0 which is already present in the hashmap with entry (0, -1).
            Then the answer would be current index(which is 3) - index of sum-k(which is -1) = 3 - (-1) = 4. So the base entry is just because arrays starts from 0.
         */
        Map<Integer, Integer> index = new HashMap();
        index.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!index.containsKey(sum)) {
                index.put(sum, i);
            }
            if (index.containsKey(sum - k)) {
                max = Math.max(max, i - index.get(sum - k));
            }
        }
        return max;
    }

    //leetcode#209. Minimum Size Subarray Sum
    public static int minSubArrayLen(int target, int[] nums) {
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                min = Math.min(min, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }
}

