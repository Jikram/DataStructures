package com.ji.search;

import java.util.Arrays;

// Basic condition for binary search is sorted array

public class BinarySearchDemo {
    public static void main(String[] args) {
        System.out.println("before");
        int[] array1 = new int[]{2, 4, 6, 8, 9, 10, 11, 12, 15};
        int[] array2 = new int[]{2, 4, 6, 8, 9, 10, 11, 12, 15, 17};
        System.out.println("Result of binary search = " + binarySearchMethod(array1, 15));
        System.out.println("after");
        System.out.println("Result of binary search = " + binarySearchMethod(array2, 15));
        System.out.println("Result of binary search = " + binarySearchMethod(array2, 17));
    }

    private static int binarySearchMethod(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2; // to avoid integer overflow
            if (arr[mid] == x) return mid;
            else if (arr[mid] > x) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
