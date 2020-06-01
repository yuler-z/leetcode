package com.yuler.q146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目链接：
 *  https://leetcode-cn.com/problems/lru-cache/
 * 题目描述：
 *   运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 *   获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 *   写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *   LRUCache cache = new LRUCache(2);
 *   cache.put(1,1);
 *   cache.put(2,2);
 *   cache.get(1);       // 返回  1
 *   cache.put(3,3);    // 该操作会使得密钥 2 作废
 *   cache.get(2);       // 返回 -1 (未找到)
 *   cache.put(4,4);    // 该操作会使得密钥 1 作废
 *   cache.get(1);       // 返回 -1 (未找到)
 *   cache.get(3);       // 返回  3
 *   cache.get(4);       // 返回  4
 *
 *   两个操作的时间复杂度均为O(1)
*
 * 解题思路：
 *    这里用到了LinkedHashMap，它继承于HashMap
 *
 *
 *
 * @Author: yuler
 * @Date: 2020/5/25 16:39
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return map.size() > capacity;
            }
        };

    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}