package com.ji.sorting;

import java.util.Arrays;

/*
 Index:    0  1  2  3  4  5  6  7  8  9  10
 Array:  [10, 3, 7, 2, 1, 6, 3, 9, 8, 4, 5]
*/
// quick sort is also called partitioning
public class QuickSortAlgo {

    public static void main(String[] args) {
        int[] array1 = {10, 3, 7, 2, 1, 6, 3, 9, 8, 4, 5};
        int[] array2 = {10, 3, 7, 2, 1, 6, 3, 9, 8, 4, 5};
        int[] array3 = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("Calling quick sort on array 1 ");
        quickSort(array1, 0, array1.length - 1);
        System.out.println(Arrays.toString(array1));

        System.out.println("Calling quick sort on array 2 ");
        quickSort(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));

        System.out.println("Calling quick sort on array 3 ");
        quickSort(array3, 0, array3.length - 1);
        System.out.println(Arrays.toString(array3));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            int pivot = partitioningPivot(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }
    // [10, 3, 7, 2, 1, 6, 3, 9, 8, 4, 5]
    private static int partitioningPivot(int[] arr, int start, int end) {
        // Two pointers starting i & j from -1 and 0 indexes respectively
        int pivot = end;
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (arr[j] <= arr[pivot]) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }
}
