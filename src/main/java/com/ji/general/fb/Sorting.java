package com.ji.general.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        Sides tri1 = new Sides(2, 2, 3);
        Sides tri2 = new Sides(3, 2, 2);
        Sides tri3 = new Sides(2, 5, 6);
        ArrayList<Sides> list = new ArrayList<>();
        list.add(tri1);
        list.add(tri2);
        list.add(tri3);
        System.out.println("count distinct triangles :" + countDistinctTriangles(list));
        int[] arr1 = new int[]{1, 5, 7, 1};
        int[] arr2 = new int[]{12, 7, 6, 7, 6};
        System.out.println("Balanced Split exists :" + balancedSplitExists(arr1));
        System.out.println("Balanced Split exists :" + balancedSplitExists(arr2));

    }

    public static boolean balancedSplitExists(int[] arr) {
        /*Given an array of integers (which may include repeated integers), determine if there's a way to split
        the array into two subsequences A and B such that the sum of the integers in both arrays is the same,
        and all of the integers in A are strictly smaller than all of the integers in B. Note: Strictly smaller
        denotes that every integer in A must be less than, and not equal to, every integer in B.
        arr = [1, 5, 7, 1] output = true // arr = [12, 7, 6, 7, 6] output = false*/
        long total = 0;
        for (int v : arr) total += v;
        if (total == 0) return true;

        long totalLeft = 0;
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int p[] = quickPartition(arr, i, j);
            int pL = p[0];  // leftmost pivot index.
            int pR = p[1];  // rightmost pivot index.
            long left = 0;

            // Count values less than or equal to pivot.
            for (int x = i; x <= pR; x++) {
                left += arr[x];
            }

            // If said values are not enough, add them to the left side and then
            // partition the right side next.
            if ((totalLeft + left) * 2 <= total) {
                totalLeft += left;
                i = pR + 1;
            } else {
                // If said values would be too high, leave the pivot values on the
                // right and partition the left side next time.
                j = pL - 1;
            }
            if (totalLeft * 2 == total) return true;
        }
        return false;
    }

    private static int[] quickPartition(int[] arr, int i, int j) {
        int pivot = j;
        int pivotValue = arr[pivot];

        int insertLeft = i;
        int insertRight = j;
        for (int scan = i; scan <= insertRight; ) {
            if (arr[scan] < pivotValue) {
                arr[insertLeft++] = arr[scan];
                scan++;
            } else if (arr[scan] > pivotValue) {
                if (insertRight == pivot) {
                    arr[insertRight--] = arr[scan];
                    scan++;
                } else {
                    int k = arr[insertRight];
                    arr[insertRight--] = arr[scan];
                    arr[scan] = k;
                }
            } else {
                scan++;
            }
        }

        arr[insertLeft] = pivotValue;
        for (int scan = insertLeft; scan <= insertRight; scan++) {
            arr[scan] = pivotValue;
        }
        return new int[]{insertLeft, insertRight};
    }

    public static int countDistinctTriangles(ArrayList<Sides> arr) {
        /*
        arr = [[2, 2, 3], [3, 2, 2], [2, 5, 6]] output = 2
        arr = [[8, 4, 6], [100, 101, 102], [84, 93, 173]] output = 3
        arr = [[5, 8, 9], [5, 9, 8], [9, 5, 8], [9, 8, 5], [8, 9, 5], [8, 5, 9]]output = 1
        Given a list of N triangles with integer side lengths, determine how many different triangles there are.
        Two triangles are considered to be the same if they can both be placed on the plane such that their
        vertices occupy exactly the same three points.*/
        // Time: O(n log n) for sort each triangle sides and doing it for n triangles -> n * n log n, Space: O(n) triangle
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < arr.size(); i++) {
            Sides t = arr.get(i);
            int[] sidesOfTri = new int[]{t.a, t.b, t.c};
            Arrays.sort(sidesOfTri);
            String s = Arrays.toString(sidesOfTri);
            System.out.println(s);
            set.add(s);
        }
        return set.size();
    }

    private static class Sides {
        int a;
        int b;
        int c;

        Sides(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
