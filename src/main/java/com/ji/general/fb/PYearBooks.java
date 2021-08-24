package com.ji.general.fb;

import java.util.*;

/* Explanation
Each student has an ID i. At each stage, all the students pass the book they hold to the person at index equal to their id - 1 (i-1).
For example, students are Alice, Bob, and Charlie where Alice.id = 1, Bob.id = 2, Charlie.id = 3.
Now, the input for the problem is a given order of the students. E.g. arr = [Charlie, Alice, Bob].
At time 0 everybody have their book: yearBookArr_0 = [3,1,2]
At all stages:
Charlie.id = 3, so he should give his book to arr[3-1] = arr[2] = Bob.
Bob.id = 2, so he should give his book to arr[2-1] = arr[1] = Alice.
Alice.id = 1, so he should give his book to arr[1-1] = arr[0] = Charlie.
At time 1 all the above changes happen at the same time so: yearBookArr_1 = [1,2,3].
I hope it's clear. Can you compute yearBookArr_2?
*/
public class PYearBooks {
    public static void main(String[] args) {
        int[] nums1 = {2, 1};
        int[] nums2 = {1, 2};
        System.out.println(Arrays.toString(pYearBook(nums1)));
        System.out.println(Arrays.toString(pYearBook(nums2)));
        System.out.println(Arrays.toString(pYearBooksOtherI(nums1)));
        System.out.println(Arrays.toString(pYearBooksOtherI(nums2)));
        System.out.println(Arrays.toString(pYearBookOtherII(nums1)));
        System.out.println(Arrays.toString(pYearBookOtherII(nums2)));
    }

    private static int[] pYearBook(int[] nums) {
        int[] res = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
        }
        Set<Integer> visited = new HashSet<>();
        for (int k : map.keySet()) {
            if (!visited.contains(k)) {
                Set<Integer> round = new HashSet<>();
                while (!visited.contains(k)) {
                    round.add(k);
                    visited.add(k);
                    k = map.get(k);
                }
                for (int i : round) {
                    res[i - 1] = round.size();
                }
            }
        }
        return res;
    }

    public static int[] pYearBooksOtherI(int[] arr) {
        int[] res = new int[arr.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i] - 1;
            while (arr[i] != arr[j]) {
                res[i]++;
                j = arr[j] - 1;
            }
        }
        return res;
    }

    public static int[] pYearBookOtherII(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; ++i) {
            int j = i;
            int c = 0;
            while (set.add(j)) {
                ++c;
                j = arr[j] - 1;
            }

            if (!set.isEmpty()) {
                for (Integer k : set) {
                    ans[i] = c;
                }

                set = new HashSet<>();
            }
        }

        return ans;
    }
}

/*
Example 1
n = 2
arr = [2, 1]
output = [2, 2]
Pass 1:
Student 1 signs their own yearbook. Then they pass the book to the student at arr[0], which is Student 2.
Student 2 signs their own yearbook. Then they pass the book to the student at arr[1], which is Student 1.
Pass 2:
Student 1 signs Student 2's yearbook. Then they pass it to the student at arr[0], which is Student 2.
Student 2 signs Student 1's yearbook. Then they pass it to the student at arr[1], which is Student 1.
Pass 3:
Both students now hold their own yearbook, so the process is complete.
Each student received 2 signatures.
Example 2
n = 2
arr = [1, 2]
output = [1, 1]
Pass 1:
Student 1 signs their own yearbook. Then they pass the book to the student at arr[0], which is themself, Student 1.
Student 2 signs their own yearbook. Then they pass the book to the student at arr[1], which is themself, Student 2.
Pass 2:
Both students now hold their own yearbook, so the process is complete.
Each student received 1 signature.
 */
