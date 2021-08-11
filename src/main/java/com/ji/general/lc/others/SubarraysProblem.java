package com.ji.general.lc.others;

// All non empty subarrays of [1,2,3,4]
public class SubarraysProblem {
    public static void main(String[] args) {
        System.out.println("output : ");
        allSubarrays(new int[]{1, 2, 3, 4});
        System.out.println(" ");
        System.out.println("recursive solution for subarray");
        int[] arr = new int[]{1, 2, 3, 4};
        allSubarraysRecursive(arr, 0, arr.length);
        System.out.println(2 / 10);
    }

    public static void allSubarrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.println("");
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]);
                }
            }
        }
    }

    // [1, 2, 3, 4]
    public static void allSubarraysRecursive(int[] arr, int start, int end) {
//        if (size == 1) {
//            System.out.println(arr[index]);
//            return;
//        }
//
//        allSubarraysRecursive(arr, index + 1, size);
//    }
    }
}
