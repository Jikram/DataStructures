package com.ji.general.fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trees {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println("Visible node from left output : " + visibleNode(treeNode));
        System.out.println("leetcode#102 output : " + levelOrder(treeNode));
        System.out.println("leetcode#199 output : " + rightSideView(treeNode));
    }

    public static int visibleNode(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> visibleFromLeft = new ArrayList<>();
        if (root == null) {
            return 0;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curNode = q.remove();
                if (i == 0) {
                    visibleFromLeft.add(curNode.val);
                }
                if (curNode.left != null) {
                    q.add(curNode.left);
                }
                if (curNode.right != null) {
                    q.add(curNode.right);
                }
            }
        }
        return visibleFromLeft.size();
    }

    //leetcode#102 bfs - level order traversal - Input: root = [3,9,20,null,null,15,7] Output: [[3],[9,20],[15,7]]
        /*
            3
          /   \
        9       20
               /  \
            15      7
         */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curNode = q.remove();
                curLevel.add(curNode.val);

                if (curNode.left != null) {
                    q.add(curNode.left);
                }
                if (curNode.right != null) {
                    q.add(curNode.right);
                }
            }
            result.add(curLevel);
        }
        return result;
    }

    // leetcode#199 BinaryTree right side view
    public static List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> visibleFRight = new ArrayList<Integer>();
        if (root == null) {
            return visibleFRight;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curNode = q.remove();
                if (i == levelSize - 1) {
                    visibleFRight.add(curNode.val);
                }
                if (curNode.left != null) {
                    q.add(curNode.left);
                }
                if (curNode.right != null) {
                    q.add(curNode.right);
                }
            }
        }
        return visibleFRight;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

