package com.ji.general.fb;

import java.util.Arrays;
import java.util.Stack;
/*
The value at index i must be the maximum element in the contiguous subarrays, and
These contiguous subarrays must either start from or end on index i.
arr = [3, 4, 1, 6, 2]
        output = [1, 3, 1, 5, 1]
        Explanation:
        For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
        For index 1 - [4], [3, 4], [4, 1]
        For index 2 - [1]
        For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
        For index 4 - [2]
        So, the answer for the above input is [1, 3, 1, 5, 1]
 O(N) solution in java using stack
*/
public class CSubarray {
    public static void main(String[] args) {
        System.out.println("The contiguous subarray : " + Arrays.toString(countSubarrays(new int[]{3, 4, 1, 6, 2})));
        // output = [1, 3, 1, 5, 1]
    }
    public static int[] countSubarrays(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[i] += res[stack.pop()];
            }
            stack.push(i);
            res[i]++;
        }
        stack.clear();
        int[] temp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int idx = stack.pop();
                res[i] += temp[idx];
                temp[i] += temp[idx];
            }
            stack.push(i);
            temp[i]++;
        }
        return res;
    }
}
