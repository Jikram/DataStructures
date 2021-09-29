package com.ji.general.fb;

public class Recursion {
    public static void main(String[] args) {
        System.out.println("findEncryptedWord output a : " + findEncryptedWord("a"));
        System.out.println("findEncryptedWord output ab : " + findEncryptedWord("ab"));
        System.out.println("findEncryptedWord output abc : " + findEncryptedWord("abc"));
        System.out.println("findEncryptedWord output abcd : " + findEncryptedWord("abcd"));
        System.out.println("findEncryptedWord output abcde : " + findEncryptedWord("abcde"));
        System.out.println("findEncryptedWord output abcxcba : " + findEncryptedWord("abcxcba"));
        System.out.println("findEncryptedWord output facebook : " + findEncryptedWord("facebook"));
        System.out.println("findEncryptedWordOther output facebook : " + findEncryptedWordOther("facebook"));
        System.out.println("findEncryptedWordOther output abcd : " + findEncryptedWordOther("abcd"));
        System.out.println("findEncryptedWordOther output abc : " + findEncryptedWordOther("abc"));
        System.out.println("findEncryptedWordOther output abc : " + canGetExactChange(94, new int[]{5, 10, 25, 100, 200}));
        System.out.println("findEncryptedWordOther output abc : " + canGetExactChange(75, new int[]{4, 17, 29}));

    }

    /*
    Change in a Foreign Currency: Given a list of the available denominations, determine if it's possible to receive exact change for an amount of money targetMoney.
    Both the denominations and target amount will be given in generic units of that currency.
     */
    public static boolean canGetExactChange(int targetMoney, int[] denominations) {
        //recursion, although O(2^N) time complexity.
        return canGetExactChangeHelper(targetMoney, denominations, 0);
    }

    public static boolean canGetExactChangeHelper(int targetMoney, int[] denominations, int index) {
        if (targetMoney == 0) return true;
        if (targetMoney < 0) return false;
        if (targetMoney > 0 && index >= denominations.length) return false;
        return canGetExactChangeHelper(targetMoney - denominations[index], denominations, index) || canGetExactChangeHelper(targetMoney, denominations, index + 1);
    }


    /*
    Encrypted Words
     */// below one needs to be fixed
    public static String findEncryptedWord(String s) {
        if (s.length() < 2) return s;
        int mid = s.length() / 2;
        if (s.length() % 2 == 0) mid -= 1;
        return s.charAt(mid) + findEncryptedWord(s.substring(0, mid) + findEncryptedWord(s.substring(mid + 1)));
    }

    static String findEncryptedWordOther(String s) {
        /*
        When you encrypt a string S, you start with an initially-empty resulting string R and append characters to it as follows:
Append the middle character of S (if S has even length, then we define the middle character as the left-most of the two central characters)
Append the encrypted version of the substring of S that's to the left of the middle character (if non-empty)
Append the encrypted version of the substring of S that's to the right of the middle character (if non-empty)
For example, to encrypt the string "abc", we first take "b", and then append the encrypted version of "a" (which is just "a") and the encrypted version of "c" (which is just "c") to get "bac"
xample 1
S = "abc"
R = "bac"
Example 2
S = "abcd"
R = "bacd"
Example 3
S = "abcxcba"
R = "xbacbca"
Example 4
S = "facebook"
R = "eafcobok"
         */
        String res = "";
        int mid = s.length() / 2;
        if (s.length() % 2 == 0)
            mid -= 1;
        res += s.substring(mid, mid + 1);
        if (mid > 0) {
            String ls = s.substring(0, mid);
            res += findEncryptedWordOther(ls);
        }
        if (mid < s.length() - 1) {
            String rs = s.substring(mid + 1);
            res += findEncryptedWordOther(rs);
        }
        return res;
    }
}

