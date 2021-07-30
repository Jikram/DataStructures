package com.ji.general.fb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
A = [1, 2, 3, 4]
B = [1, 4, 3, 2]
Leetcode#1460 . it is also given that both target and arr can be between 1 to 1000
*/
public class ReverseToMakeEqual {
    public static void main(String[] args) {
        System.out.println("ReverseToMakeEqual : " + canBeEqual(new int[]{1, 2, 3, 4}, new int[]{1, 4, 3, 2}));
        System.out.println("ReverseToMakeEqualUsingMap : " + canBeEqualUsingMap(new int[]{1, 2, 3, 4}, new int[]{1, 4, 3, 2}));

    }

    public static boolean canBeEqual(int[] target, int[] arr) {
//        Arrays.sort(target);
//        Arrays.sort(arr);
//        return Arrays.equals(target,arr);
        int[] array = new int[1001];
        for (int i = 0; i < target.length; i++) {
            array[target[i]]++;
            array[arr[i]]--;
        }
        for (int i = 0; i < 1001; i++) {
            if (array[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean canBeEqualUsingMap(int[] a, int[] b) {
        int m = a.length, n = b.length;
        if (m != n) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            map.put(b[i], map.getOrDefault(b[i], 0) - 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) != 0) return false;
        }
        return true;
    }
}

