package com.ji.datastructures.matrix2d;

import java.util.Arrays;
// Populating data in 2D array. //
public class Array2D {
    public static int[][] displayMatrix() {
        int[][] array = new int[5][5];
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = count++;
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println("output of 2d : " + Arrays.deepToString(displayMatrix()));
    }
}
