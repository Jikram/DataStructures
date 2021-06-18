package com.ji.sorting;

import java.util.Arrays;

/*
 Index:    0  1  2  3  4  5  6  7  8  9  10
 Array:  [10, 3, 7, 2, 1, 6, 3, 9, 8, 4, 5]
*/
public class InsertionSortAlgo {
    public static void main(String[] args) {
        int[] array = {10, 3, 7, 2, 1, 6, 3, 9, 8, 4, 5};
        System.out.println("Calling insertion sort on array ");
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(int[] array) {
        // sorted array|unsorted array and start adding from first element and put elements from the logical unsorted array to sorted array //
        // sorted and unsorted array are logical array in the same array //
        for (int i = 1; i < array.length; i++) {
            int temp = array[i], j = i;
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }
}
