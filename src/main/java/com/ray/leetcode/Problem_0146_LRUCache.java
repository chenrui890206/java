package com.ray.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
Follow up:
Could you do get and put in O(1) time complexity?

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

Constraints:

1 <= capacity <= 3000
0 <= key <= 3000
0 <= value <= 104
At most 3 * 104 calls will be made to get and put.

*/
public class Problem_0146_LRUCache {

    public Map<Integer, DoubleNode> map = null;
    public DoubleNode head = null;
    public DoubleNode tail = null;
    private int size = 0;
    private int capacity = 0;

    class DoubleNode{
        private DoubleNode pre;
        private DoubleNode next;
        private int value;
        private int key;

        public DoubleNode() {}

        public DoubleNode(int k,int v) {
            this.value = v;
            this.key = k;
        }
    }

    public Problem_0146_LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new DoubleNode();
        tail = new DoubleNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DoubleNode node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
        }
        return node.value;
    }

    public void moveToHead(DoubleNode node) {
        removeNode(node);
        addHead(node);
    }

    public void addHead(DoubleNode node) {
        DoubleNode n = head.next;
        head.next = node;
        node.pre = head;
        node.next = n;
        n.pre = node;
    }

    public void removeNode(DoubleNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void removeTail() {
        removeNode(tail.pre);
    }

    public void put(int key, int value) {

        if (map.get(key) == null) {
            DoubleNode node = new DoubleNode(key, value);
            map.put(key, node);
            if (size >= capacity) {
                map.remove(tail.pre.key);
                removeTail();
                addHead(node);
            } else {
                addHead(node);
                size++;
            }
        } else {
            DoubleNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        Problem_0146_LRUCache lRUCache = new Problem_0146_LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }
}
