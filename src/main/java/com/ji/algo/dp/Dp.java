package com.ji.algo.dp;

import java.util.HashMap;
import java.util.Map;

public class Dp {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        System.out.println("fibonacci number TopToBottom memoization : " + fibonacciTDMemoization(9, map));
        System.out.println("fibonacci number BottomUp tabular : " + fibonacciBUTabular(9, map));
    }

    public static int fibonacciTDMemoization(int n, Map<Integer, Integer> map) {
        if (!map.containsKey(n)) {
            map.put(n, fibonacciTDMemoization(n - 1, map) + fibonacciTDMemoization(n - 2, map));
        }
        return map.get(n);
    }

    public static int fibonacciBUTabular(int n, Map<Integer, Integer> map) {

        for (int i = 2; i <= n; i++) {
            map.put(i, fibonacciBUTabular(i - 1, map) + fibonacciBUTabular(i - 2, map));
        }
        return map.get(n);
    }
}
