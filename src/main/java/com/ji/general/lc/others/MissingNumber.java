package com.ji.general.lc.others;

import java.util.HashSet;
import java.util.Set;

//leetcode#41 First Missing Positive
// nums = [3,4,-1,1] output 2 or
// nums = [7,8,9,11,12] output 1 or
// nums = [1,2,0] output 3
public class MissingNumber {
    public static void main(String[] args) {

        System.out.println("Output : " + firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println("Output : " + firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println("Output : " + firstMissingPositive(new int[]{1, 2, 0}));

    }

    public static int firstMissingPositiveEfficient(int[] nums) {
        return -1;

    }

    // Brute force approach T: O(n) S: O(n)
    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) return i;
        }
        return -1;
    }
}



