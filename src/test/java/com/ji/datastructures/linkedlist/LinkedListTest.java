package com.ji.datastructures.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
    LinkedList linkedList = new LinkedList();

    @Before
    public void populatingLinkedList() {
        linkedList.addToFront(10);
        linkedList.addToFront(20);
        linkedList.addToFront(30);
        // Inserting at the back.
        linkedList.addToBack(50);
    }

    @Test
    public void addToBack() throws Exception {
        Assert.assertEquals(50, linkedList.getLast());
    }

    @Test
    public void getFirst() throws Exception {
        Assert.assertEquals(30, linkedList.getFirst());
        System.out.println("First node = " + linkedList.getFirst());
    }

    @Test
    public void getLast() throws Exception {
        Assert.assertEquals(50, linkedList.getLast());
        System.out.println("Last node = " + linkedList.getLast());
    }

    @Test
    public void delete() throws Exception {
        System.out.println("Initial size = " + linkedList.size());
        linkedList.delete(20);
        Assert.assertEquals(3, linkedList.size());
        System.out.println("After delete size = " + linkedList.size());
    }


}