package com.ji.datastructures.trees.bst.bstexercise;

import com.ji.datastructures.trees.bst.BST;

/*
Input: root = [2,1,3]
Output: true
*/
public class ValidateBST {
    public static void main(String[] args) {
        // Constructing two binary trees //
        BNode bTree1 = new BNode(6);
        bTree1.left = new BNode(4);
        bTree1.right = new BNode(8);

        BNode bTree2 = new BNode(3);
        bTree2.left = new BNode(4);
        bTree2.right = new BNode(8);

        System.out.println("Validating whether the binary tree is bst");
        System.out.println(isValidBST(bTree1));
        System.out.println(isValidBST(bTree2));


    }


    public static class BNode {
        int val;
        BNode left;
        BNode right;

        public BNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static boolean isValidBST(BNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private static boolean isValidBSTHelper(BNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        } else if (max != null && root.val >= max || min != null && root.val <= min) {
            return false;
        } else {
            return isValidBSTHelper(root.left, root.val, min) && isValidBSTHelper(root.right, max, root.val);
        }
    }
}
