package com.ji.datastructures.trees.bst.bstexercise;
/*

1) You are given a pointer to the root of a binary search tree and values to be inserted into the tree.
Insert the values into their appropriate position in the binary search tree and return the root of the updated binary tree.

         4
       /    \
      2      7
     / \    / \
    1   3  6   null

     Input: 6 to bst
     Expected output: 4 2 1 3 7 6

 2) Also added serialization of the bst method.

*/

import java.util.Arrays;

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

    private static String serializePreOrder(Node root) {
        // serialization is actually traversing the tree and storing it in string or array. In this case it is pre-order.

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.data);
        System.out.println(root.data);
        if (root.left != null) {
            stringBuilder.append(serializePreOrder(root.left));
        }
        if (root.right != null) {
            stringBuilder.append(serializePreOrder(root.right));
        }
        return String.valueOf(stringBuilder);
    }

    public static void main(String[] args) {
        System.out.println("Expected output: 4 2 1 3 7 6");
        int[] data = new int[]{4, 2, 1, 3, 7, 6};
        Node root = null;
        for (int datum : data) {
            root = insert(root, datum);
        }
        preOrder(root);
        System.out.println("Serializing a BST to array here");
        String s = serializePreOrder(root);
        char[] chars = s.toCharArray();
        System.out.println("Serialized arrays is : " + Arrays.toString(chars));
    }

}



