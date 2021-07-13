package com.ji.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// All combination of array 1,2,3
public class Subsets {
    public static void main(String[] args) {
        System.out.println("Output of subsetLC78 : " + subsetsLC78(new int[]{1, 2, 3}));
        System.out.println("Output of subsetLC90 : " + subsetsLC90(new int[]{1, 2, 2}));
    }

    public static List<List<Integer>> subsetsLC78(int[] nums) {
/* Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.*/
        List<List<Integer>> result = new ArrayList<>();
        dfsLC78(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public static void dfsLC78(int[] nums, int index, ArrayList<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            dfsLC78(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsLC90(int[] nums) {
       /*Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
       The solution set must not contain duplicate subsets. Return the solution in any order.*/
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfsLC90(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void dfsLC90(int[] nums, int index, ArrayList<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            if (i == index || nums[i] != nums[i - 1]) {
                current.add(nums[i]);
                dfsLC90(nums, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}

