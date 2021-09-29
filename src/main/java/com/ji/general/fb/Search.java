package com.ji.general.fb;

import java.util.Arrays;
// Binary search algo TC: O(logN)
public class Search {
    public static void main(String[] args) {
        System.out.println("getmilestonedays output :" + Arrays.toString(getMilestoneDays(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100}, new int[]{100, 200, 500})));
        System.out.println("getmilestonedays output :" + Arrays.toString(getMilestoneDays(new int[]{100, 200, 300, 400, 500}, new int[]{300, 800, 1000, 1400})));
        System.out.println("getBillion users output :" + getBillionUsersDayBruteF(new float[]{1.1f, 1.2f, 1.3f}));
        System.out.println("getBillion users output :" + getBillionUsersDayBruteF(new float[]{1.01f, 1.02f}));
        System.out.println("getBillion users output :" + getBillionUsersDay(new float[]{1.1f, 1.2f, 1.3f}));
        System.out.println("getBillion users output :" + getBillionUsersDay(new float[]{1.01f, 1.02f}));

    }
    /*
    On days 4, 5, and 6, org has total revenue of $100, $150, and $210 respectively. Day 6 is the first time that org has >= $200 of total revenue.
    revenues = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
    milestones = [100, 200, 500]
    output = [4, 6, 10]
    */

    public static int[] getMilestoneDays(int[] revenues, int[] milestones) {
        int[] res = new int[milestones.length];
        for (int j = 1; j < revenues.length; j++) {
            revenues[j] += revenues[j - 1];
        }
        for (int i = 0; i < milestones.length; i++) {
            res[i] = getDayOfMilestoneHelper(revenues, milestones[i]);
        }
        return res;
    }

    private static int getDayOfMilestoneHelper(int[] revenues, int milestone) {
        int p = 0;
        int q = revenues.length - 1;
        while (p <= q) {
            int mid = p + (q - p) / 2; // just to avoid the integer overflow
            if (milestone == revenues[mid]) {
                return mid + 1;
            } else if (milestone < revenues[mid]) {
                q = mid - 1;
            } else {
                p = mid + 1;
            }
        }
        return p + 1;
    }

    public static int getBillionUsersDayBruteF(float[] growthRates) {
        double user = 0;
        int day = 1;
        while (user < 1e9) {
            user = 0;
            for (int i = 1; i <= growthRates.length; i++) {
                user += Math.pow(growthRates[i - 1], day);
            }
            day++;
        }
        return day - 1;
    }

    /*
    We have N different apps with different user growth rates. At a given time t, measured in days,
    the number of users using an app is g^t (for simplicity we'll allow fractional users), where g is the growth rate for that app.
    These apps will all be launched at the same time and no user ever uses more than one of the apps. We want to know how many total users there
    are when you add together the number of users from each app.After how many full days will we have 1 billion total users across the N apps?
     */
    public static int getBillionUsersDay(float[] growthRates) {
        int p = 1, q = Integer.MAX_VALUE;
        while (p < q) {
            int mid = p + (q - p) / 2;
            if (growthRateHelper(mid, growthRates)) {
                q = mid;
            } else {
                p = mid + 1;
            }
        }
        return p;
    }

    private static boolean growthRateHelper(int mid, float[] growthRates) {
        int billion = 1000000000;
        double totalUsers = 0;
        for (int i = 0; i < growthRates.length; i++) {
            totalUsers += Math.pow(growthRates[i], mid);
        }
        return (int) totalUsers >= billion;
    }
}
