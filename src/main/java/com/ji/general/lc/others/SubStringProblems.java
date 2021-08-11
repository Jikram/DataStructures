package com.ji.general.lc.others;

import java.util.HashMap;
import java.util.HashSet;

//leetcode#459
//Input: s = "abab"
//Output: true
//Explanation: It is the substring "ab" twice.
public class SubStringProblems {
    public static void main(String[] args) {
        System.out.println("output of 459 :" + repeatedSubstringPattern("ababab"));
        System.out.println("output of 459 :" + repeatedSubstringPattern("abab"));
        System.out.println("output of 459 :" + repeatedSubstringPattern("aba"));
        System.out.println("output of 459 :" + repeatedSubstringPattern("abcabcabcabc"));
        System.out.println("output of 28 :" + strStr("hello", "ll"));
        System.out.println("output of 28 :" + strStr("aaaaa", "bba"));
        System.out.println("output of 28 :" + strStr("", "a"));
        System.out.println("output of 3 :" + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("output of 3 :" + lengthOfLongestSubstring("bbbbb"));
        System.out.println("output of 3 using map:" + lengthOfLongestSubstringUsingHashMap("abcabcbb"));
        System.out.println("output of 3 using map:" + lengthOfLongestSubstringUsingHashMap("bbbbb"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();
        int l = s.length();
        for (int i = l / 2; i > 0; i--) {
            //if (s.length() % i != 0) continue;
            if (l % i == 0) {
                int times = l / i;
                String substring = s.substring(0, i);
                for (int j = 0; j < times; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s)) return true;
                sb.setLength(0);
            }

        }
        return false;
    }

    //leetcode#28
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i - j;
                }
                j++;
            } else {
                if (j > 0) {
                    i = i - j;
                    j = 0;
                }
            }
            i++;
        }
        return -1;
    }

    //leetcode#3 - s = "abcabcbb" Output: 3
    // s = "bbbbb" Output: 1
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < s.length()) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!set.contains(ci)) {
                set.add(ci);
                max = Math.max(max, set.size());
                i++;
            } else {
                set.remove(cj);
                j++;
            }
        }
        return max;
    }

    //leetcode#3 - s = "abcabcbb" Output: 3
    // s = "bbbbb" Output: 1
    public static int lengthOfLongestSubstringUsingHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < s.length() && j < s.length()) {
            char ci = s.charAt(i);
            //char cj = s.charAt(j);
            if (!map.containsKey(ci)) {
                map.put(ci, i);
                i++;
            } else {
                j++;
            }
            max = Math.max(max, map.get(ci) - j + 1);
        }
        return max;
    }
}
