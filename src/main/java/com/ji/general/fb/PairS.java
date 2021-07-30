package com.ji.general.fb;
// arr = [1, 2, 3, 4, 3] k = 6 output = 2
//arr = [1, 5, 3, 3, 3] k = 6 output = 4

import java.util.HashMap;

public class PairS {
    public static void main(String[] args) {
        System.out.println("Output " + numberOfWays(new int[]{1, 2, 3, 4, 3}, 6));
        System.out.println("Output " + numberOfWays(new int[]{1, 5, 3, 3, 3}, 6));

    }

    public static int numberOfWays(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 0);
            }
            map.put(arr[i], map.get(arr[i]) + 1);
        }
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(k - arr[i]) != null)
                counter += map.get(k - arr[i]);
            if (k - arr[i] == arr[i])
                counter--;
        }
        return counter / 2;
    }
}





