package com.ji.datastructures.matrix2d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Input:
[1 2 3]
[4 5 6]
[7 8 9]

Output:
[1,2,3,6,9,8,7,4,5]
*/
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("spiral traversal of 2d array");
        System.out.println(spiralMatrix(input));
    }

    public static List<Integer> spiralMatrix(int[][] matrix) {
        // These are all bounds //
        List<Integer> list = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int size = matrix.length * matrix[0].length;
        while (list.size() < size) {
            for (int i = left; i <= right && list.size() < size; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom && list.size() < size; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
