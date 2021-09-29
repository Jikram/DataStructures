package com.ji.sorting;

import java.util.Arrays;

// Selection sort scan the array for either min or max value to sort the numbers in either lexico or reverse order.
// need to keep track of min or max index so that a swapping can happen at the end of complete scan of an array.
// T.C: O(n^2), in-place , Not-Stable
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr1 = new int[]{64, 25, 12, 22, 11};
        int[] arr2 = new int[]{22, 25, 11, 64, 12};
        int[] arr3 = new int[]{22, 25, 11, 64, 12};
        selectionSort(arr1);
        selectionSort(arr2);
        System.out.println("Selection sort :" + Arrays.toString(arr1));
        System.out.println("Selection sort :" + Arrays.toString(arr2));
        selectionSortReverse(arr3);
        System.out.println("Selection sort :" + Arrays.toString(arr3));
    }

    // sort by using min
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Reverse sort by using max
    public static void selectionSortReverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
