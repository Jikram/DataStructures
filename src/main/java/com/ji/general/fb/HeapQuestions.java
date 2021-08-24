package com.ji.general.fb;

import java.util.*;

public class HeapQuestions {
    public static void main(String[] args) {
        System.out.println("LTripleProduct : " + Arrays.toString(findMaxProduct(new int[]{1, 2, 3, 4, 5})));
        System.out.println(maximumProduct(new int[]{1, 2, 3}));
        System.out.println("Kth Largest number in array is : " + kthNumberInArray(new int[]{3, 1, 5, 6, 4, 7, -1, 0}, 2));
        System.out.println("Highest number in array is : " + highest(new int[]{3, 1, 5, 6, 4, 7, -1, 0}));
        System.out.println("Thirdmax number in array is : " + thirdMax(new int[]{3, 1, 5, 6, 4, 7, -1, 0}));
        System.out.println("Thirdmax number in array is : " + thirdMax(new int[]{2, 1}));
        System.out.println("Thirdmax number in array is : " + thirdMax(new int[]{2, 2, 1, 5}));
        System.out.println("Find median in array is : " + Arrays.toString(findMedian(new int[]{5, 15, 1, 3})));
        System.out.println("Find median in array is : " + Arrays.toString(findMedian(new int[]{1, 2})));
        System.out.println("Find max candies can be eaten : " + maxCandies(new int[]{2, 1, 7, 4, 2}, 3));
        System.out.println("Find max candies can be eaten: " + maxCandies(new int[]{19, 78, 76, 72, 48, 8, 24, 74, 29}, 3));
    }

    /*
    You have N bags of candy. The ith bag contains arr[i] pieces of candy, and each of the bags is magical!
    It takes you 1 minute to eat all of the pieces of candy in a bag (irrespective of how many pieces of candy are inside),
    and as soon as you finish, the bag mysteriously refills. If there were x pieces of candy in the bag at the beginning of the minute,
    then after you've finished you'll find that floor(x/2) pieces are now inside.
    You have k minutes to eat as much candy as possible. How many pieces of candy can you eat?
    arr = [2, 1, 7, 4, 2]    output = 14
    arr = [19, 78, 76, 72, 48, 8, 24, 74, 29], k = 3 output = 228
    */
    public static int maxCandies(int[] arr, int k) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        for (int e : arr) {
            maxPq.add(e);
        }
        int sum = 0;
        while (k > 0) {
            int curr = maxPq.poll();
            sum += curr;
            maxPq.add(curr / 2);
            k--;
        }
        return sum;
    }


    /*
    arr = [5, 15, 1, 3] output = [5, 10, 5, 4] // arr = [1, 2] output = [1, 1]
     */
    public static int[] findMedian(int[] arr) {
        PriorityQueue<Integer> lHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (lHeap.isEmpty() || arr[i] < lHeap.peek()) {
                lHeap.add(arr[i]);
            } else {
                rHeap.add(arr[i]);
            }
            if (lHeap.size() > rHeap.size() + 1) {
                rHeap.add(lHeap.remove());
            } else if (rHeap.size() > lHeap.size() + 1) {
                lHeap.add(rHeap.remove());
            }
            int median = 0;
            if (lHeap.size() == rHeap.size()) {
                median = (lHeap.peek() + rHeap.peek()) / 2;

            } else if (lHeap.size() > rHeap.size()) {
                median = lHeap.peek();
            } else {
                median = rHeap.peek();
            }
            arr[i] = median;
        }
        return arr;
    }


    public static int[] findMaxProduct(int[] arr) {
        /*
        You're given a list of n integers arr[0..(n-1)]. You must compute a list output[0..(n-1)] such that, f
        or each index i (between 0 and n-1, inclusive), output[i] is equal to the product of the three largest
        elements out of arr[0..i] (or equal to -1 if i < 2, as arr[0..i] then includes fewer than three elements).
        arr = [1, 2, 3, 4, 5]     output = [-1, -1, 6, 24, 60]
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() < 3) {
                arr[i] = -1;
            } else {
                int x = pq.poll();
                int y = pq.poll();
                int z = pq.poll();
                int res = x * y * z;
                arr[i] = res;
                pq.add(x);
                pq.add(y);
                pq.add(z);
            }
        }
        return arr;
    }

    //leetcode#628
    public static int maximumProduct(int[] nums) {
        int max1, max2, max3, min1, min2;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        min1 = min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
            } else if (min2 > nums[i]) {
                min2 = nums[i];
            }
            if (max1 < nums[i]) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (max2 < nums[i]) {
                max3 = max2;
                max2 = nums[i];
            } else if (max3 < nums[i]) {
                max3 = nums[i];
            }
        }
        return Math.max((max1 * max2 * max3), (max1 * min1 * min2));
    }

    public static int kthNumberInArray(int[] array, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap
        //PriorityQueue<Integer> pq = new PriorityQueue<>(array.length, Comparator.reverseOrder()); // max heap
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        for (int i = 0; i < array.length; i++) {
            pq.add(array[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.remove();
    }

    // [3, 1, 5, 6, 4, 7, -1, 0]
    // Leetcode#414 Finding 3rd highest number in array //

    public static int thirdMax(int[] nums) {
        int max = nums[0];
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max3 = max2;
                max2 = max;
                max = nums[i];
            } else if (nums[i] > max2 && nums[i] < max) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3 && nums[i] < max2) {
                max3 = nums[i];
            }
        }
        return max3 == Integer.MIN_VALUE ? max : max3;
    }


    // [3, 1, 5, 6, 4, 7, -1, 0]
    // Finding largest element in array //
    public static int highest(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

}
