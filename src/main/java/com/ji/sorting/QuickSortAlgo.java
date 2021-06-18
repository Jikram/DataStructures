package com.ji.sorting;

import java.util.Arrays;

/*
 Index:    0  1  2  3  4  5  6  7  8  9  10
 Array:  [10, 3, 7, 2, 1, 6, 3, 9, 8, 4, 5]
*/
public class QuickSortAlgo {

    public static void main(String[] args) {
        int[] array = {10, 3, 7, 2, 1, 6, 3, 9, 8, 4, 5};
        System.out.println("Calling quick sort on array ");
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = partitioningArrayReturningPivotIndex(array, start, end);
            // Below call will be for left and right side of the pivot //
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }

    public static int partitioningArrayReturningPivotIndex(int[] array, int start, int end) {
        // Pivot can be arbitrary but here end index value is taken as pivot //
        int pivot = end;
        int lp = start - 1;
        for (int rp = start; rp <= end; rp++) {
            // Where ever right pointer is less that pivot we first increment left pointer then swap left with right pointer.
            if (array[rp] <= array[pivot]) {
                lp++;
                int temp;
                temp = array[lp];
                array[lp] = array[rp];
                array[rp] = temp;
            }
        }
        return lp;
    }
}
