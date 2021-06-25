package com.ji.datastructures.trees.bst;
 /*  BST1
            5
         /    \
        3       7
      /  \     /   \
     2    4   6      8


   BST2
          8
        /   \
      3      10
     / \       \
    1   6      14
       / \     /
      4   7   13

Preorder Serialize:[8,3,1,null,null,6,4,null,null,7,null,null,10,null,14,13,null,null,null]


*/


import com.ji.datastructures.trees.bst.bstexercise.ValidateBST;

public class DriverBST {
    public static void main(String[] args) {
        BST bst1 = new BST();
        bst1.insert(5);
        bst1.insert(3);
        bst1.insert(7);
        bst1.insert(2);
        bst1.insert(4);
        bst1.insert(6);
        bst1.insert(8);
        System.out.println("Display binary tree below in-order traversal");
        bst1.traversalInOrder();
        System.out.println("Display binary tree below pre-order traversal");
        bst1.traversalPreOrder();
        System.out.println("Display binary tree below post-order traversal");
        bst1.traversePostOrder();
        BST bst2 = new BST();
        bst2.insert(8);
        bst2.insert(3);
        bst2.insert(1);
        bst2.insert(6);
        bst2.insert(4);
        bst2.insert(7);
        bst2.insert(10);
        bst2.insert(14);
        bst2.insert(13);
        System.out.println("Preorder traversal of bst2 below");
        bst2.traversalPreOrder();
        System.out.println("Serialize bst2 with preorder : " + bst2.serializePreOrder(bst2.root));
        System.out.println("Height of bst2 : " + bst2.heightOfBST(bst2.root));
        System.out.println("Sum of the bst2 : " + bst2.sumOfBst(bst2.root));
        System.out.println("Size of the bst2 : " + bst2.sizeOfBst(bst2.root));
        System.out.println("Min of bst2 : " + bst2.minOfBst(bst2.root));
        System.out.println("Max of bst2 : " + bst2.maxOfBST(bst2.root));



    }

}
