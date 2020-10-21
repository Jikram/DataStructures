package com.ji.datastructures.hashtable;

// Hashtable implementation using array of linkedlist.
public class HashTable {
    private int initialSize = 16;
    LinkedListData[] linkedListData;

    // Below class act as linked list node.
    public class LinkedListData {
        String key;
        String value;
        LinkedListData next;

        public LinkedListData(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public HashTable() {
        linkedListData = new LinkedListData[initialSize];
    }

    // Hashtable operations:
    public void put(String key, String value) {
        int index = getIndex(key);
        LinkedListData newEntry = new LinkedListData(key, value);
        LinkedListData entries = linkedListData[index];
        if (linkedListData[index] == null) {
            linkedListData[index] = newEntry;
        } else {
            while (entries.next != null) {
                entries = entries.next;
            }
            entries.next = newEntry;
        }
    }

    public String get(String key) throws Exception {
        int index = getIndex(key);
        LinkedListData linkedList = linkedListData[index];
        if (linkedListData[index] == null) {
            throw new Exception("key not found");
        } else {
            while (!linkedList.key.equals(key) && linkedList.next != null) {
                linkedList = linkedList.next;
            }
            return linkedList.value;
        }
    }

    // Calculate Index
    public int getIndex(String key) {
        int largeHashIndex = key.hashCode();
        int smallHashIndex = (largeHashIndex & 0xfffffff) % initialSize;
        return smallHashIndex;
    }


}
