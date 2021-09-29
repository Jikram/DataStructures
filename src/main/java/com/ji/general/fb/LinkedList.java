package com.ji.general.fb;
/*
You are given a singly-linked list that contains N integers. A subpart of the list is a contiguous set of even elements, bordered either by either end of the list or an odd element. For example, if the list is [1, 2, 8, 9, 12, 16], the subparts of the list are [2, 8] and [12, 16].
Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list, [1, 8, 2, 9, 16, 12].
The goal of this question is: given a resulting list, determine the original order of the elements.
Input:
N = 6
list = [1, 2, 8, 9, 12, 16]
Output:
[1, 8, 2, 9, 16, 12]
 */

public class LinkedList {
    public static void main(String[] args) {

    }

    public static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }
}
