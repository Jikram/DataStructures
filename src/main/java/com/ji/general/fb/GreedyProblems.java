package com.ji.general.fb;

import java.util.Arrays;

public class GreedyProblems {
    public static void main(String[] args) {
        System.out.println("Seating  Arrangement output :" + minOverallAwkwardness(new int[]{5, 10, 6, 8}));
        System.out.println("Seating  Arrangement output :" + minOverallAwkwardness(new int[]{1, 2, 5, 3, 7}));
        System.out.println("Element Swapping output :" + Arrays.toString(findMinArray(new int[]{5, 3, 1}, 2)));
        System.out.println("Element Swapping output :" + Arrays.toString(findMinArray(new int[]{8, 9, 11, 2, 1}, 3)));
        System.out.println("slow sums output :" + getTotalTime(new int[]{2, 3, 9, 8, 4}));
        System.out.println("slow sums output :" + getTotalTime(new int[]{2, 3, 9, 8, 4}));
        System.out.println("leetcode#122 output :" + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("leetcode#121 output :" + maxProfit121(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("leetcode#409 output :" + longestPalindrome("racdefcecacdefr"));
        System.out.println("leetcode#409 output :" + longestPalindrome("abccccdd"));
        System.out.println("leetcode#409 output :" + longestPalindrome("bb"));
        System.out.println("leetcode#409 output :" + longestPalindrome("ab"));
    }

    /*
    There are n guests attending a dinner party, numbered from 1 to n. The ith guest has a height of arr[i-1] inches.
    The guests will sit down at a circular table which has n seats, numbered from 1 to n in clockwise order around the table. As the host, you will choose how to arrange the guests, one per seat. Note that there are n! possible permutations of seat assignments.
    Once the guests have sat down, the awkwardness between a pair of guests sitting in adjacent seats is defined as the absolute difference between their two heights. Note that, because the table is circular, seats 1 and n are considered to be adjacent to one another,
    and that there are therefore n pairs of adjacent guests.The overall awkwardness of the seating arrangement is then defined as the maximum awkwardness of any pair of adjacent guests. Determine the minimum possible overall awkwardness of any seating arrangement.
    Seating Arrangements: arr = [5, 10, 6, 8] output = 4; arr = [1, 2, 5, 3, 7]  output = 4
    // Arrange the sorted arr in this way:
    // 0,2,4,...N-1,...,5,3,1
    // Adjacent ones are:
    // i and i - 2
    // 0, 1
    // N - 1, N - 2
    */
    public static int minOverallAwkwardness(int[] arr) {
        // 5,6,8,10
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            diff = Math.max(diff, arr[i] - arr[i - 2]);
        }
        return diff;
    }

    /*
    Element swapping
    * k = 2 arr = [5, 3, 1] output = [1, 5, 3] // k = 3 arr = [8, 9, 11, 2, 1] output = [2, 8, 9, 11, 1]
    * We can swap the 2nd and 3rd elements, followed by the 1st and 2nd elements, to end up with the sequence [1, 5, 3].
    * This is the lexicographically smallest sequence achievable after at most 2 swaps.
    * */

    public static int[] findMinArray(int[] arr, int k) {
        int currentIndex = 0;
        while (k > 0 && currentIndex < arr.length - 1) {
            int min = Integer.MAX_VALUE;
            int indexOfMin = 0;
            int limit = Math.min(k, arr.length - 1);
            for (int i = currentIndex; i <= currentIndex + limit; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    indexOfMin = i;
                }
            }
            for (int i = indexOfMin; i > currentIndex; i--) {
                int temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
                k--;
            }
            currentIndex++;
        }
        return arr;
    }


    /*slow sums arr = [4, 2, 1, 3] output = 26 // arr = [2, 3, 9, 8, 4] output = 88
    First, add 4 + 3 for a penalty of 7. Now the array is [7, 2, 1]. Add 7 + 2 for a penalty of 9. Now the array is [9, 1]
    Add 9 + 1 for a penalty of 10. The penalties sum to 26.*/
    public static int getTotalTime(int[] arr) {
        Arrays.sort(arr);
        int sum = arr[arr.length - 1];
        int penalty = 0;
        int end = arr.length - 1;
        for (int i = end - 1; i >= 0; i--) {
            sum += arr[i];
            penalty += sum;
        }
        return penalty;
    }


    //leetcode409. length of Longest Palindrome
    public static int longestPalindrome(String s) {
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        int odd = 0;
        for (int i : arr) {
            if (i % 2 == 1) {
                odd++;
            }
        }
        return odd < 1 ? s.length() : s.length() - odd + 1;
    }


    //leetcode#121 Input: prices = [7,1,5,3,6,4] Output: 5
    public static int maxProfit121(int[] prices) {
        if (prices.length == 0 || prices == null) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }

    // leetcode#122 Input: prices = [7,1,5,3,6,4] Output: 7
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null) {
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
