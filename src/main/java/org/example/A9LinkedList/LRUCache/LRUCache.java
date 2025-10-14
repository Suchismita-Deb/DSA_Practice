package org.example.A9LinkedList.LRUCache;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/description/
/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Example 1.

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]
*/
public class LRUCache {

    Map<Integer, Node> mp = new HashMap<>();

    class Node {
        Node prv, next;
        int key, value;

        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    Node head = new Node(0, 0);

    Node tail = new Node(0, 0);

    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prv = head;
    }

    public int get(int key) {
        if (mp.containsKey(key)) {
            Node node = mp.get(key);
            node.prv.next = node.next;
            node.next.prv = node.prv;
            // node.next = head.next;
            // head.next.prv = node;
            // head.next = node;
            // node.prv = head;
            node.next = head.next;
            node.prv = head;
            head.next.prv = node;
            head.next = node;
            return mp.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            Node node = mp.get(key);
            node.value = value;
            node.prv.next = node.next; // node.prv = node.next; The pointer position node.prv.next.
            node.next.prv = node.prv;

            node.next = head.next;
            node.prv = head;
            head.next.prv = node;
            head.next = node;
            return;
        }
        Node newNode = new Node(key, value);

        if (mp.size() == capacity) {
            Node node = tail.prv;
            mp.remove(node.key);
            tail.prv = node.prv;
            node.prv.next = tail;
        }
        newNode.next = head.next;
        newNode.prv = head;
        head.next.prv = newNode;
        head.next = newNode;
        mp.put(key, newNode); // It is the main point to add the position after the value in the list.
    }

}