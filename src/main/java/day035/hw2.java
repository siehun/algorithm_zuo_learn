package day035;

import java.util.HashMap;

// 实现LRU结构
public class hw2 {
    // 测试链接 : https://leetcode.cn/problems/lru-cache/
    class LRUCache {
        class Dnode {
            // 双向链表key, value结构
            public int key;
            public int val;
            public Dnode pre;
            public Dnode next;
            public Dnode() {}
            public Dnode(int k, int v) {
                key = k;
                val = v;
            }
        }
        class Dlist {
            public Dnode head;
            public Dnode tail;
            public Dlist() {
                head = null;
                tail = null;
            }
            public void addNode(Dnode newNode) {
                if (newNode == null) {
                    return;
                }
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    newNode.pre = tail;
                    tail = newNode;
                }
            }
            public void moveNodeToTail(Dnode node) {
                if (tail == node) {
                    return;
                }
                // 先断开
                if (head == node) {
                    head = node.next;
                    head.pre = null;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                node.pre = tail;
                node.next = null;
                tail.next = node;
                tail = node;
            }
            public Dnode removeHead() {
                if (head == null) {
                    return null;
                }
                Dnode ans = head;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.pre = null;
                    ans.next = null;
                }
                return ans;
            }
        }
        private HashMap<Integer, Dnode> map;
        private Dlist dlist;
        private final int capa;
        public LRUCache(int capacity) {
            map = new HashMap<>();
            dlist = new Dlist();
            capa = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Dnode node = map.get(key);
                int ans = node.val;
                dlist.moveNodeToTail(node);
                return ans;
            }
            return -1;

        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Dnode node = map.get(key);
                node.val = value;
                dlist.moveNodeToTail(node);
            } else {
                if (map.size() == capa) {
                    map.remove(dlist.removeHead().key);
                }
                Dnode newNode = new Dnode(key, value);
                dlist.addNode(newNode);
                map.put(key, newNode);
            }


        }
    }
}
