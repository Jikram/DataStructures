package com.ji.sorting;

import java.util.Arrays;
 /*
    Index:    0  1  2  3  4  5  6  7  8  9  10
    Array:  [10, 3, 7, 2, 1, 6, 3, 9, 8, 4, 5]
                             |
    */

public class MergeSortAlgo {
    public static void main(String[] args) {
        int[] array = new int[]{10, 3, 7, 2, 1, 6, 3, 9, 8, 4, 5};
        System.out.println("Merge sort in action below :");
        mergeSort(array, 0, array.length - 1);
        System.out.println("Merge sorted array :" + Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int sizeOfL = mid - start + 1;
        int sizeOfR = end - mid;
        int[] leftArray = new int[sizeOfL];
        int[] rightArray = new int[sizeOfR];
        // Copying subarrays from array to two arrays //
        for (int i = 0; i < sizeOfL; i++) {
            leftArray[i] = array[start + i];
        }
        for (int i = 0; i < sizeOfR; i++) {
            rightArray[i] = array[mid + 1 + i];
        }
        int l = leftArray.length;
        int r = rightArray.length;
        int i = 0;
        int j = 0;
        int k = start;
        while (i < l && j < r) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < l) {
            array[k] = leftArray[i];
            k++;
            i++;
        }
        while (j < r) {
            array[k] = rightArray[j];
            k++;
            j++;
        }
    }
}
