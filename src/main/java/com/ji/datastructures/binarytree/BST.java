package com.ji.datastructures.binarytree;

public class BST {

    // Operations: Insert, find, delete, traverse, min, max

    private Node root;


    //find
    String findValue(String key) {

        return null;
    }

    //insert
    void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            root.insert(data);
        }
    }

    // In-order traversal should print in sort order
    public void traversalInOrder() {
        if (root != null) {
            root.traverseNodeInOrder();
        }
    }

    // Pre-order traversal
    public void traversalPreOrder() {
        if (root != null) {
            root.traverseNodePreOrder();
        }

    }

    public void traversePostOrder() {
        if (root != null) {
            root.traverseNodePostOrder();
        }
    }


}
