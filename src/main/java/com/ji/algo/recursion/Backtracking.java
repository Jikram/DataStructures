package com.ji.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
*/
public class Backtracking {
    public static void main(String[] args) {
        System.out.println("Output LC 39: " + combinationSumLeetCode39(new int[]{2, 3, 6, 7}, 7));
        System.out.println("Output LC 40: " + combinationSumLeetCode40(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));

    }

    public static List<List<Integer>> combinationSumLeetCode39(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private static void dfs(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(current));
        }
        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }

    /*
        Input: candidates = [10,1,2,7,6,1,5], target = 8
        Output:
                [
                [1,1,6],
                [1,2,5],
                [1,7],
                [2,6]
                ]
        */
    public static List<List<Integer>> combinationSumLeetCode40(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfslc40(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private static void dfslc40(int[] candidates, int index, int target, ArrayList<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));

        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i == index || candidates[i] != candidates[i - 1]) {
                list.add(candidates[i]);
                dfslc40(candidates, i + 1, target - candidates[i], list, result);
                list.remove(list.size() - 1);
            }
        }
    }
    /*
    377. Combination Sum IV

     */

    // DP problem //
    public int combinationSum4(int[] nums, int target) {
        return 0;

    }
}

