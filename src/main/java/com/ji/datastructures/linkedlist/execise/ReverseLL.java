package com.ji.datastructures.linkedlist.execise;

import java.util.Stack;

/*
 Input:  1->2->3->4->5->null
 Output: 5->4->3->2->1->null

 Solution complete using 3 approaches
*/
public class ReverseLL {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(4);
        head3.next.next.next.next = new ListNode(5);

        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(3);
        head4.next.next.next = new ListNode(4);
        head4.next.next.next.next = new ListNode(5);

        ListNode head5 = new ListNode(3);
        head5.next = new ListNode(5);

        System.out.println("Original ll is below : ");
        displayLL(head1);
        System.out.println("Reverse ll Iteratively is below : ");
        displayLL(reverseLLIteratively(head1));

        System.out.println("Original ll is below : ");
        displayLL(head2);
        System.out.println("Reverse ll Recursively is below : ");
        displayLL(reverseLLRecursively(head2));

        System.out.println("Original ll is below : ");
        displayLL(head3);
        System.out.println("Reverse ll Using Stack Implementation is below : ");
        displayLL(reverseWithStack(head3));

        System.out.println("Original ll is below : ");
        displayLL(head4);
        System.out.println("Reverse between ll Iteratively is below : ");
        displayLL(reverseBetween(head4, 2, 4));
        //displayLL(reverseBetween(head5, 1, 1));
        displayLL(reverseBetween(head5, 1, 2));

    }

    public static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode reverseLLIteratively(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static ListNode reverseLLRecursively(ListNode head) {
        return recursiveHelper(head);
    }

    private static ListNode recursiveHelper(ListNode curr) {
        if (curr == null || curr.next == null) {
            return curr;
        }
        ListNode lastNode = recursiveHelper(curr.next);
        curr.next.next = curr;
        curr.next = null;
        return lastNode;
    }

    public static ListNode reverseWithStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode headRev = stack.pop();
        ListNode curr = headRev;
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
        curr.next = null;
        return headRev;
    }

    // LC 92 [1,2,3,4,5] to [1,4,3,2,5]//
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (right - left == 0 || head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev, curr;
        curr = head;
        prev = dummy;
        dummy.next = head;
        for (int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }
        ListNode pHead = prev, tail = curr, next = curr.next;
        for (int i = left; i < right; i++) {
            prev = curr;
            curr = next;
            next = curr.next;
            curr.next = prev;
        }
        pHead.next = curr;
        tail.next = next;
        return dummy.next;
    }

    public static void displayLL(ListNode current) {
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
