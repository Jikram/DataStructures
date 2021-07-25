package com.ji.general.lc.wordproblems;

// Leetcode 14
public class LCP {
    public static void main(String[] args) {
        System.out.println("LCP of array : " + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println("LCP of array : " + longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println("LCP of array : " + longestCommonPrefix(new String[]{"a"}));
        System.out.println("LCP of array : " + longestCommonPrefix(new String[]{"reflower", "flow", "flight"}));
        System.out.println("LCP of array : " + longestCommonPrefix(new String[]{"ab", "a"}));
        System.out.println("LCP of array other : " + longestCommonPrefixOther(new String[]{"flower", "flow", "flight"}));
        System.out.println("LCP of array other : " + longestCommonPrefixOther(new String[]{"dog", "racecar", "car"}));
        System.out.println("LCP of array other : " + longestCommonPrefixOther(new String[]{"a"}));
        System.out.println("LCP of array other : " + longestCommonPrefixOther(new String[]{"reflower", "flow", "flight"}));
        System.out.println("LCP of array other : " + longestCommonPrefixOther(new String[]{"ab", "a"}));
        System.out.println("is Subsequence : " + isSubsequence("abc", "ahbgdc"));
        System.out.println("is Subsequence : " + isSubsequence("axc", "ahbgdc"));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String lcPrefix = "";
        String prefix = strs[0];
        int index = 0;
        for (char c : prefix.toCharArray()) {
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || c != strs[i].charAt(index)) {
                    return lcPrefix;
                }
            }
            lcPrefix += c;
            index++;
        }
        return lcPrefix;
    }

    public static String longestCommonPrefixOther(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        boolean common = false;
        String lcPrefix = "";
        String prefix = strs[0];
        int index = 0;
        char[] arr = prefix.toCharArray();
        for (int j = 0; j < arr.length; j++) {
            for (int i = 1; i < strs.length; i++) {
                if (j < strs[i].length() && arr[j] == strs[i].charAt(j)) {
                    continue;
                } else {
                    return lcPrefix;
                }
            }
            lcPrefix += arr[j];
            index++;
        }
        return lcPrefix;
    }

    // LC 392 // s = "abc", t = "ahbgdc" // s = "axc", t = "ahbgdc" //
    public static boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(index) == t.charAt(i)) {
                index++;
            }
            if (index >= s.length()) {
                return true;
            }
        }
        return false;
    }
}
