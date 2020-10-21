package com.ji.datastructures.hashtable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashTableTest {
    HashTable hashTable = new HashTable();

    @Before
    public void setup() {
    }

    @Test
    public void get() throws Exception {
        hashTable.put("One", "1");
        hashTable.put("two", "2");
        hashTable.put("five","5");
        Assert.assertEquals("1", hashTable.get("one"));
        Assert.assertEquals("2", hashTable.get("two"));
        Assert.assertEquals("5", hashTable.get("five"));

    }
}