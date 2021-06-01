package com.ji.datastructures.binarytree;

public class BST {

    // Operations: Insert, find, delete, traverse, min, max

    public Node root;


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

    // In-order
    public void traversalInOrder() {
        if (root != null) {
            root.traverseNodeInOrder();
        }
    }

    // Pre-order
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

    public String serializePreOrder(Node root) {
        StringBuilder stringBuilder = new StringBuilder();
        serializePreOrderHelper(root, stringBuilder);
        return stringBuilder.toString();
    }

    public void serializePreOrderHelper(Node root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("null,");
            return;
        }
        stringBuilder.append(root.getData() + ",");
        serializePreOrderHelper(root.getLeftNode(), stringBuilder);
        serializePreOrderHelper(root.getRightNode(), stringBuilder);
    }

    public Node deserialize(String str) {

        // yet to be written //

        return null;

    }

    // Height of bst in terms of edges but if want height in terms of nodes then should return 0 instead of -1 //
    public int heightOfBST(Node root) {
        if (root == null) {
            return -1;
        }
        int lh = heightOfBST(root.getLeftNode());
        int rh = heightOfBST(root.getRightNode());
        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public int sumOfBst(Node root) {
        if (root == null) {
            return 0;
        }

        int ls = sumOfBst(root.getLeftNode());
        int rs = sumOfBst(root.getRightNode());
        int ts = ls + rs + root.getData();
        return ts;
    }

    public int sizeOfBst(Node root) {
        if (root == null) {
            return 0;
        }

        int ls = sizeOfBst(root.getLeftNode());
        int rs = sizeOfBst(root.getRightNode());
        int ts = ls + rs + 1;

        return ts;
    }

    public int maxOfBST(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int ls = maxOfBST(root.getLeftNode());
        int rm = maxOfBST(root.getRightNode());
        int tm = Math.max(Math.max(ls, rm), root.getData());
        return tm;
    }

    public int minOfBst(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int ml = minOfBst(root.getLeftNode());
        int mr = minOfBst(root.getRightNode());
        int tm = Math.min(Math.min(ml, mr), root.getData());
        return tm;

    }
}
