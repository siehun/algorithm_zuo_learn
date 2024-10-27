package day035;

import java.util.HashMap;
import java.util.HashSet;

// 全O(1)的数据结构
// 测试链接 : https://leetcode.cn/problems/all-oone-data-structure/
public class hw7 {
    class AllOne {
        // 先把桶建出来
        class Bucket {
            public HashSet<String> set;
            public int cnt;
            public Bucket next;
            public Bucket last;
            public Bucket(String s, int c) {
               cnt = c;
               set = new HashSet<>();
               set.add(s);
            }
        }
        HashMap<String, Bucket> map;
        Bucket head;
        Bucket tail;
        public AllOne() {
            head = new Bucket("", 0);
            tail = new Bucket("", Integer.MAX_VALUE);
            head.next = tail;
            tail.last= head;
            map = new HashMap<>();
        }
        private void insert(Bucket cur, Bucket pos) {
            pos.next = cur.next;
            cur.next.last = pos;
            cur.next = pos;
            pos.last = cur;
        }
        private void remove(Bucket cur) {
            cur.last.next = cur.next;
            cur.next.last = cur.last;
        }

        public void inc(String key) {
            if (!map.containsKey(key)) {
                if (head.next.cnt == 1) {
                    head.next.set.add(key);
                    map.put(key, head.next);
                } else {
                    Bucket bucket = new Bucket(key, 1);
                    insert(head, bucket);
                    map.put(key, bucket);
                }
            } else {
                Bucket bucket = map.get(key);
                if (bucket.next.cnt == bucket.cnt + 1) {
                    map.put(key, bucket.next);
                    bucket.next.set.add(key);
                } else {
                    Bucket b = new Bucket(key, bucket.cnt + 1);
                    map.put(key, b);
                    insert(bucket, b);
                }
                bucket.set.remove(key);
                if (bucket.set.isEmpty()) {
                    remove(bucket);
                }
            }
        }

        public void dec(String key) {
            Bucket bucket = map.get(key);
            if (bucket.cnt == 1) {
                map.remove(key);
            } else {
                if (bucket.last.cnt == bucket.cnt - 1) {
                    map.put(key, bucket.last);
                    bucket.last.set.add(key);
                } else {
                    Bucket newBucket = new Bucket(key, bucket.cnt - 1);
                    map.put(key, newBucket);
                    insert(bucket.last, newBucket);
                }
            }
            bucket.set.remove(key);
            if (bucket.set.isEmpty()) {
                remove(bucket);
            }
        }

        public String getMaxKey() {
            Bucket max = tail.last;
            return max.set.iterator().next();
        }

        public String getMinKey() {
            Bucket min = head.next;
            return min.set.iterator().next();
        }
    }
}
