package com.ji.sorting;

import com.ji.designpatterns.factory.implementation.Rectangle;

import java.util.Random;

/* Input: arr[] = {7, 10, 4, 3, 20, 15} kth smallest = 3 Output: 7 kth largest output = 10 */
public class QuickSelect {
    public static void main(String[] args) {
        int[] arr1 = new int[]{7, 10, 4, 3, 20, 15};
        int[] arr2 = new int[]{7, 10, 4, 3, 20, 15};
        int[] arr3 = new int[]{7, 10, 4, 3, 20, 15};
        System.out.println(quickSelectForKthSmallest(arr1, 0, arr1.length - 1, 3));
        System.out.println(quickSelectForKthLargest(arr2, 0, arr2.length - 1, 3));
        System.out.println("Leetcode#215 Kth largest with Random pivot :" + findKthLargest(arr3, 3));
    }

    public static int quickSelectForKthSmallest(int[] arr, int start, int end, int k) {
        if (start == end) {
            return arr[start];
        }
        int pivot = partitioningPivot(arr, start, end);
        if (pivot < k) {
            return quickSelectForKthLargest(arr, pivot + 1, end, k - 1);
        } else if (pivot > k) {
            return quickSelectForKthLargest(arr, start, pivot - 1, k - 1);
        } else {
            return arr[pivot];
        }
    }

    public static int quickSelectForKthLargest(int[] arr, int start, int end, int k) {
        if (start == end) {
            return arr[start];
        }
        int pivot = partitioningPivot(arr, start, end);
        if (pivot > k) {
            return quickSelectForKthLargest(arr, start, pivot - 1, k);
        } else if (pivot < k) {
            return quickSelectForKthLargest(arr, pivot + 1, end, k);
        } else {
            return arr[pivot];
        }
    }

    private static int partitioningPivot(int[] arr, int start, int end) {
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

    //Leetcode#215 using quickselect & random pivot
    public static int findKthLargest(int[] nums, int k) {
        return qsFindKthLargest(nums, 0, nums.length - 1, k);
    }

    private static int qsFindKthLargest(int[] arr, int start, int end, int k) {
        if (start == end) {
            return arr[start];
        }
        int piv = partitioningRandomPivot(arr, start, end);
        if (piv > k) {
            return qsFindKthLargest(arr, start, piv - 1, k);
        } else if (piv < k) {
            return qsFindKthLargest(arr, piv + 1, end, k);
        } else {
            return arr[piv];
        }
    }

    private static int partitioningRandomPivot(int[] arr, int start, int end) {
        Random r = new Random();
        int randomPivotIndex = r.nextInt(end - start) + start;
        int temp = arr[end];
        arr[end] = arr[randomPivotIndex];
        arr[randomPivotIndex] = temp;
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (arr[j] <= arr[pivot]) {
                i++;
                int temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
            }
        }
        int temp2 = arr[i];
        arr[i] = arr[end];
        arr[end] = arr[i];
        return i;
    }
}
