package com.ji.datastructures.binarytree.bstexercise;
/*

You are given a pointer to the root of a binary search tree and values to be inserted into the tree.
Insert the values into their appropriate position in the binary search tree and return the root of the updated binary tree.

         4
        / \
       2   7
      / \
     1   3

     Input: 6 to bst
     Expected output: 4 2 1 3 7 6

*/

import java.util.Scanner;

public class InsertNode {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            if (root.data > data) {
                if (root.left == null) {
                    root.left = new Node(data);
                } else {
                    insert(root.left, data);
                }
            } else {
                if (root.right == null) {
                    root.right = new Node(data);
                } else {
                    insert(root.right, data);
                }
            }
            return root;
        }
    }

    private static void preOrder(Node root) {
        System.out.println(root.data);
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }

    }

    public static void main(String[] args) {

        int[] data = new int[]{4, 2, 1, 3, 7, 6};
        Node root = null;
        for (int datum : data) {
            root = insert(root, datum);
        }
        preOrder(root);
    }

}



