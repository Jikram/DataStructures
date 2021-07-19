package com.ji.general.lc.wordproblems;

public class ReverseWord {
    public static void main(String[] args) {
        System.out.println("Output : " + reverseWord("hello"));
        System.out.println("Output 151 : " + reverseWords151("the sky is blue"));
        System.out.println("Output 151 : " + reverseWords151("a good   example"));
        System.out.println("Output 151 :" + reverseWords151("  hello world  "));
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
}

