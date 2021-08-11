package com.ji.general.fb;

import java.util.*;

public class MPairs {
    public static void main(String[] args) {
        String s1 = "abcd", t1 = "adcb";
        String s2 = "mno", t2 = "mno";
        String s3 = "abcde", t3 = "adcbe";
        String s4 = "abcd", t4 = "abcd";
        String s5 = "abcd", t5 = "efgh";
        String s6 = "abcd", t6 = "abce";
        String s7 = "abczz", t7 = "abcee";
        System.out.println(mPair(s1, t1));
        System.out.println(mPair(s2, t2));
        System.out.println(mPair(s3, t3));
        System.out.println(mPair(s4, t4));
        System.out.println(mPair(s5, t5));
        System.out.println(mPair(s6, t6));
        System.out.println(mPair(s7, t7));
        System.out.println(mPairBruteForce(s1, t1));
        System.out.println(mPairBruteForce(s2, t2));
    }

    private static int mPair(String s, String t) {
        Set<Character> set = new HashSet<>();
        boolean hasDup = false;
        int res = 0;
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                sb1.append(s.charAt(i));
                sb2.append(t.charAt(i));
            } else {
                if (!set.add(s.charAt(i)))
                    hasDup = true;
                res++;
            }
        }
        if (sb1.length() == 0) {
            if (hasDup)
                return res;
            return res - 2;
        }
        // s1 = "abcd", t1 = "adcb"
        Map<Character, Integer> mapS = new HashMap<>(), mapT = new HashMap<>();
        for (int i = 0; i < sb1.length(); i++) {
            if (mapS.containsKey(sb2.charAt(i))) {
                res++;
            }
            if (mapS.getOrDefault(sb2.charAt(i), -1) == mapT.getOrDefault(sb1.charAt(i), -2))
                return res + 1;
            mapS.put(sb1.charAt(i), i);
            mapT.put(sb2.charAt(i), i);
        }
        return res + (sb1.length() == 1 ? -1 : 0);
    }

    public static int mPairBruteForce(String s, String t) {
        // s1 = "abcd", t1 = "adcb"
        int n = s.length();
        int res = 0;
        char[] sArray = s.toCharArray(), tArray = t.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                sArray[i] = s.charAt(j);
                sArray[j] = s.charAt(i);
                int count = 0;
                for (int k = 0; k < n; k++)
                    if (sArray[k] == tArray[k]) count++;
                res = Math.max(res, count);
                sArray[i] = s.charAt(i);
                sArray[j] = s.charAt(j);
            }
        }
        return res;
    }


}

