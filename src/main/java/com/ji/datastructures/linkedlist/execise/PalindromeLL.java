package com.ji.datastructures.linkedlist.execise;

public class PalindromeLL {
    public static void main(String[] args) {
        LLNode head1 = new LLNode(1);
        head1.next = new LLNode(2);
        head1.next.next = new LLNode(3);
        head1.next.next.next = new LLNode(2);
        head1.next.next.next.next = new LLNode(1);
        displayLL(head1);
        System.out.println("head1 palindrome check : " + isLLPalindrome(head1));

        LLNode head2 = new LLNode(1);
        head2.next = new LLNode(2);
        head2.next.next = new LLNode(2);
        head2.next.next.next = new LLNode(1);
        displayLL(head2);
        System.out.println("head2 palindrome check : " + isLLPalindrome(head2));
    }

    public static class LLNode {
        int value;
        LLNode next;

        public LLNode(int value) {
            this.value = value;
        }
    }

    // LC#234 [1 2 3 2 1] or [1 2 2 1]
    public static boolean isLLPalindrome(LLNode head) {
        if (head == null) {
            return true;
        }
        LLNode fast = head;
        LLNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        LLNode firstHead = head;
        LLNode secondHead = reversell(slow.next);
        while (firstHead != null && secondHead != null) {
            if (firstHead.value != secondHead.value) {
                return false;
            }
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        return true;
    }

    //  p c
    // [1 2 3 2 1]
    private static LLNode reversell(LLNode head) {
        LLNode temp = null;
        LLNode prev = null;
        LLNode curr = head;
        while (curr != null) {
            temp = curr.next;  // temp = 3
            curr.next = prev;  // curr.next = 1;
            prev = curr;       // prev = 2
            curr = temp;       // curr = 3
        }
        return prev;
    }


    public static void displayLL(LLNode current) {
        if (current == null) {
            System.out.println("empty linked list ");
        }
        while (current != null) {
            System.out.print(current.value);
            current = current.next;
        }
        System.out.println(" ");
    }


}