package com.ji.sorting;

import java.util.Arrays;

/*
 Index:    0  1  2  3  4  5  6  7  8  9  10
 Array:  [10, 3, 7, 2, 1, 6, 3, 9, 8, 4, 5]
*/
public class BubbleSortAlgo {
    public static void main(String[] args) {
        int[] array = {10, 3, 7, 2, 1, 6, 3, 9, 8, 4, 5};
        System.out.println("Bubble sort below ");
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        // In bubble sort first iteration will place biggest element at the end of the array and following iterations
        // will follow the same
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
