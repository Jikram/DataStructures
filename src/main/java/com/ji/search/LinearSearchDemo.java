package com.ji.search;

public class LinearSearchDemo {

    public static void main(String[] args) {

        System.out.println("result is her =" + search(new int[]{1, 2, 5, 9, 12, 45}, 0));


    }

    public static int search(int[] arr, int x) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
}
