package com.ji.datastructures.trees.bst;

public class Node {
    private int data;
    private Node leftNode;
    private Node rightNode;

    public Node(int data) {
        this.data = data;
        leftNode = null;
        rightNode = null;
    }

    public void traverseNodeInOrder() {
        if (leftNode != null) {
            leftNode.traverseNodeInOrder();
        }
        System.out.println(data); // visiting node here //
        if (rightNode != null) {
            rightNode.traverseNodeInOrder();
        }
    }

    public void traverseNodePreOrder() {
        System.out.println(data); // visiting node here //
        if (leftNode != null) {
            leftNode.traverseNodePreOrder();
        }
        if (rightNode != null) {
            rightNode.traverseNodePreOrder();
        }
    }

    public void traverseNodePostOrder() {
        if (leftNode != null) {
            leftNode.traverseNodePostOrder();
        }
        if (rightNode != null) {
            rightNode.traverseNodePostOrder();
        }
        System.out.println(data); // visiting node here //
    }

    public void insert(int data) {

        if (data == this.data) {
            return;
        }
        if (data < this.data) {
            if (leftNode == null) {
                leftNode = new Node(data);
            } else {
                leftNode.insert(data);
            }
        } else {
            if (rightNode == null) {
                rightNode = new Node(data);
            } else {
                rightNode.insert(data);
            }
        }

    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
