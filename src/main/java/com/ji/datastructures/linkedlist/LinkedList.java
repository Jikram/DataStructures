package com.ji.datastructures.linkedlist;

// Singly linked list implementation.
public class LinkedList {
    private Node head;

    public void addToFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addToBack(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public int getFirst() throws Exception {
        if (head == null) {
            throw new Exception("Empty list");
        }
        Node current = head;
        return current.data;
    }

    public int getLast() throws Exception {
        if (head == null) {
            throw new Exception("Empty list");
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    public void delete(int data) throws Exception {
        if (head == null) {
            throw new Exception("Linked list already empty");
        }
        if (head.data == data) {
            head = head.next;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    public int size() {
        int count = 1;
        if (head == null) {
            return 0;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        return count;
    }
}
