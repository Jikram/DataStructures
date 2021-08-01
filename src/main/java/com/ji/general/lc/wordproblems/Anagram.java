package com.ji.general.lc.wordproblems;

import java.util.Arrays;

// leetcode#242 . It can handle both cases: small and capital
public class Anagram {
    public static void main(String[] args) {
        System.out.println("Anagram valid using array counter : " + isAnagram("bfs","fbs"));
        System.out.println("Anagram valid using array counter : " + isAnagram("car","rcp"));
        System.out.println("Anagram valid using array counter : " + isAnagram("anagram","nagaram"));
        System.out.println("Anagram valid using array counter : " + isAnagram("ANAGRAM","NAGARAM"));

    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[52];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A']++;
            arr[t.charAt(i) - 'A']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
