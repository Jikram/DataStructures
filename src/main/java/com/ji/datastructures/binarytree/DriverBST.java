package com.ji.datastructures.binarytree;
 /*  BST
            5
         /    \
        3       7
      /  \     /   \
     2    4   6      8
*/


public class DriverBST {
    public static void main(String[] args){
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.println("Display binary tree below in-order traversal");
        bst.traversalInOrder();
        System.out.println("Display binary tree below pre-order traversal");
        bst.traversalPreOrder();
        System.out.println("Display binary tree below post-order traversal");
        bst.traversePostOrder();




    }

}
