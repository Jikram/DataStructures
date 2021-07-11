package com.ji.datastructures.linkedlist.execise;

public class MidPointLL {
    public static void main(String[] args) {
        LLNode head1 = new LLNode(1);
        head1.next = new LLNode(2);
        head1.next.next = new LLNode(3);
        head1.next.next.next = new LLNode(4);
        head1.next.next.next.next = new LLNode(5);

    }
    public static class LLNode {
        int value;
        LLNode next;

        public LLNode(int value) {
            this.value = value;
        }


    }
}