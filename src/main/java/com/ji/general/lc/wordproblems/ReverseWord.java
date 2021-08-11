package com.ji.general.lc.wordproblems;

import java.util.*;

public class ReverseWord {
    public static void main(String[] args) {
        System.out.println("Output 344 : " + reverseWord("hello"));
        System.out.println("Output 151 : " + reverseWords151("the sky is blue"));
        System.out.println("Output 151 : " + reverseWords151("a good   example"));
        System.out.println("Output 151 :" + reverseWords151("  hello world  "));
        System.out.println("Output 151 other approach :" + reverseWords151OtherApproach("hello world"));
        System.out.println("Output 345 :" + reverseVowels("leetcode"));
        System.out.println("Output 345 :" + reverseVowelsOtherTechnique("leetcode"));
        System.out.println("Output 1844 :" + replaceDigits("a1c1e1"));
        System.out.println("Output 1844 :" + replaceDigits("a1c1e1"));
        System.out.println( (char)('a'+ ('1' - '0')));
        System.out.println( (char)('a'+ ('c')));
    }

    // 344. Reverse String //
    public static String reverseWord(String str) {
        char[] arr = str.toCharArray();
        char temp = ' ';
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }

    // 557. Reverse Words in a String III //
    public static String reverseWords557(String s) {
        return null;
    }

    // 151. Reverse Words in a String //
    public static String reverseWords151(String s) {
        StringBuilder sb = new StringBuilder();
        String s1 = s.replaceAll("\\s+", " ");
        String[] arr = s1.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return new String(sb);
    }
    public static String reverseWords151OtherApproach(String s) {
        List<String> list = Arrays.asList(s.split(" "));
        Collections.reverse(list);
        String join = String.join(" ", list);
        return join;
    }

    // LC 345 //
    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (i < j && !set.contains(arr[i])) {
                i++;
            }
            while (i < j && !set.contains(arr[j])) {
                j--;
            }
            char temp;
            temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;

        }
        return new String(arr);
    }

    public static String reverseVowelsOtherTechnique(String s) {
        // s = "leetcode" output : "leotcede" //
        Set<Character> set = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (set.contains(arr[i]) && set.contains(arr[j])) {
                char temp;
                temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            } else if (set.contains(arr[i]) && !set.contains(arr[j])) {
                j--;
            } else if (!set.contains(arr[i]) && set.contains(arr[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return String.valueOf(arr);
    }

    //Leetcode#1844  Replace All Digits with Characters
    //s = "a1c1e1" Output: "abcdef"
    public static String replaceDigits(String s) {
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0) {
                output += (char)(s.charAt(i - 1) + (s.charAt(i) - '0'));
            } else {
                output += s.charAt(i);
            }
        }
        return output;
    }
}

