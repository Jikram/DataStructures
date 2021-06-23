package com.ji.datastructures.matrix2d;

/*

{1,  2,  3,  4,   5}
{6,  7,  8,  9,  10}
{11, 12, 13, 14, 15}
{16, 17, 18, 19, 20}
{21, 22, 23, 24, 25}

Rotate matrix by 90 degree. Using layer by layer approach.
*/
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] img = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        rotateMatrix(img);
        print2DArray(img);
    }

    public static void rotateMatrix(int[][] img) {
        int n = img.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = img[i][j];
                img[i][j] = img[n - 1 - j][i];
                img[n - 1 - j][i] = img[n - 1 - i][n - 1 - j];
                img[n - 1 - i][n - 1 - j] = img[j][n - 1 - i];
                img[j][n - 1 - i] = temp;
            }
        }
    }

    public static void print2DArray(int[][] array2D) {
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[0].length; j++) {
                System.out.print(array2D[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
