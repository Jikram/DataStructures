package com.ji.algo.recursion;

public class Recursion {
    public static void main(String[] args) {
        System.out.println("Adding all numbers up to n :" + addNNumbers(5));
        System.out.println("Factorial of a given number :" + factorial(5));
        System.out.println("FactorialOptimized of a given number :" + factorialOptimized(1000, 1));
        System.out.println("Fibinocci of a given number :" + fibinocci(10));
        System.out.println("FibinocciOptimized of a given number :" + fibinocciOptimized(10, 0, 1));
        System.out.println("HeadRecursion number : ");
        headAddNNumber(5);
        System.out.println("TailRecursion number : ");
        tailAddNNumber(5);
        int[] arr = new int[]{4, 6, 2, 3, 5, 8};
        System.out.println("Linear search recursively : " + linearSearchRecursively(arr, 5, 0));
        int[] arr1 = new int[]{4, 6, 7, 8, 9, 10, 15, 20, 22};
        System.out.println("Binary  search recursively : " + binarySearchRecursively(arr1, 15, 0, arr1.length - 1));

    }

    public static int addNNumbers(int n) {
        if (n == 1) return 1;
        return n + addNNumbers(n - 1);
    }

    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static int factorialOptimized(int n, int result) {
        if (n == 1) return result;
        return factorialOptimized(n - 1, n * result);
    }

    public static void headAddNNumber(int n) {
        if (n == 0) return;
        headAddNNumber(n - 1);
        System.out.println("recursive backtracking" + n);

    }

    public static void tailAddNNumber(int n) {
        if (n == 0) return;
        System.out.println("recursive backtracking" + n);
        tailAddNNumber(n - 1);
    }

    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
    public static int fibinocci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibinocci(n - 1) + fibinocci(n - 2);
    }

    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
    public static int fibinocciOptimized(int n, int x, int y) {
        if (n == 0) return x;
        if (n == 1) return y;
        return fibinocciOptimized(n - 1, y, x + y);
    }

    public static int linearSearchRecursively(int[] arr, int item, int index) {
        if (index > arr.length - 1) {
            return -1;
        }
        if (arr[index] == item) {
            return index;
        }
        return linearSearchRecursively(arr, item, index + 1);
    }

    // Binary search requires sorted array //
    // {4, 6, 7, 8, 9, 10, 15, 20, 22} //
    public static int binarySearchRecursively(int[] arr, int item, int left, int right) {
        int mid = (left + right) / 2;
        if (left > right) return -1;
        if (arr[mid] == item) return mid;
        if (arr[mid] > item) {
            return binarySearchRecursively(arr, item, left, mid);
        } else {
            return binarySearchRecursively(arr, item, mid, right);
        }
    }


}
