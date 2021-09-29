package com.ji.search;

public class RecursiveDemo {
    public static void main(String[] args) {
        //simple recursion
        //reduceByOne(3);
        // recursion for linear search
        //System.out.println(recursiveLinearSearch(new int[]{1, 2, 5, 9, 12, 4, 7}, 0, 9));
        // recursion for binary search
        System.out.println(recursiveBinarySearch(new int[]{1, 2, 5, 9, 12, 4, 7}, 0, 6, 12));

    }

    public static void reduceByOne(int number) {
        if (number >= 0) {
            reduceByOne(number - 1);
        }
        System.out.println("recursive call : " + number);
    }

    public static int recursiveLinearSearch(int[] arr, int i, int x) {
        if (i > arr.length - 1) return -1;
        else if (arr[i] == x) return i;
        else {
            System.out.println("index =" + i);
            return recursiveLinearSearch(arr, i + 1, x);
        }
    }

    public static int recursiveBinarySearch(int[] arr, int p, int r, int x) {
        while (p <= r) {
            int q = (p + r) / 2;
            if (arr[p] == x) return p;
            else if (arr[q] > x) r = q - 1;
            else if (arr[q] < x) r = q + 1;
            else return recursiveBinarySearch(arr, p + 1, r, x);
        }
        return -1;
    }

}
