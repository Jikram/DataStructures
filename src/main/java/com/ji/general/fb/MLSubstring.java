package com.ji.general.fb;

import java.util.HashMap;

public class MLSubstring {
    public static void main(String[] args) {
        System.out.println("leetcode#76 output :" + minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("leetcode#76 output :" + minWindow("a", "a"));
        System.out.println("leetcode#76 output :" + minWindow("a", "aa"));
        System.out.println("output of :" + minLengthSubstring("dcbefebce", "fd"));
    }
    // Completed
    public static int minLengthSubstring(String s, String t) {
        /* s and t are non-empty strings that contain less than 1,000,000 characters each. Return the minimum length of the substring of s. If it is not possible, return -1*/
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        //int minStringStart = 0;
        int count = t.length();
        int minL = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r++);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count--;
                }
            }
            while (l < s.length() && count == 0) {
                if (minL > r - l) {
                    minL = r - l;
                    //minStringStart = l;
                }
                char c1 = s.charAt(l++);
                if (map.containsKey(c1)) {
                    map.put(c1, map.get(c1) + 1);
                    if (map.get(c1) > 0)
                        count++;
                }
            }
        }
        return minL < Integer.MAX_VALUE ? minL : -1;
    }

    //leetcode#76 completed
    // Algo: Having the count starting from t.length() and move right pointer and keep subtracting one until find all the letter and stop
    // at count = 0. Then move left pointer further until count become non zero. Also update may key frequencies while
    // traversing for both the pointer left and right.
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0, minStringStart = 0;
        int count = t.length();
        int minL = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r++);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count--;
                }
            }
            while (l < s.length() && count == 0) {
                if (minL > r - l) {
                    minL = r - l;
                    minStringStart = l;
                }
                char c1 = s.charAt(l++);
                if (map.containsKey(c1)) {
                    map.put(c1, map.get(c1) + 1);
                    if (map.get(c1) > 0)
                        count++;
                }
            }
        }
        return minL < Integer.MAX_VALUE ? s.substring(minStringStart, minStringStart + minL) : "";
    }
}


