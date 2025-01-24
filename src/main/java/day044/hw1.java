package day044;

import java.util.HashMap;

public class hw1 {
    class Trie1 {
        class TrieNode {
            public int pass;
            public int end;
            public TrieNode[] nexts;
            public TrieNode() {
                pass = 0;
                end = 0;
                nexts = new TrieNode[26];
            }
        }
        public TrieNode root;
        public Trie1() {
            root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode cur = root;
            cur.pass++;
            for (int i = 0; i < word.length(); i++) {
                char w = word.charAt(i);
                if (cur.nexts[w - 'a'] == null) {
                    cur.nexts[w - 'a'] = new TrieNode();
                }
                cur = cur.nexts[w - 'a'];
                cur.pass++;
            }
            cur.end++;
        }

        public boolean search(String word) {
            TrieNode cur = root;
            for (int i = 0;  i < word.length(); i++) {
                char w = word.charAt(i);
                if (cur.nexts[w - 'a'] == null) {
                    return false;
                }
                cur = cur.nexts[w - 'a'];
            }
            return cur.end != 0;
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char w = prefix.charAt(i);
                if (cur.nexts[w - 'a'] == null) {
                    return false;
                }
                cur = cur.nexts[w - 'a'];
            }
            return true;
        }
    }
    class Trie {
        class TrieNode {
            public int pass;
            public int end;
            public HashMap<Integer, TrieNode> nexts;
            public TrieNode() {
                pass = 0;
                end = 0;
                nexts = new HashMap<>();
            }
        }
        public TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            cur.pass++;
            for (int i = 0; i < word.length(); i++) {
                int path = word.charAt(i) - 'a';
                if (!cur.nexts.containsKey(path)) {
                    cur.nexts.put(path, new TrieNode());
                }
                cur = cur.nexts.get(path);
                cur.pass++;
            }
            cur.end++;
        }

        public boolean search(String word) {
            TrieNode cur =root;
            for (int i = 0; i < word.length(); i++) {
                int path = word.charAt(i) - 'a';
                if (!cur.nexts.containsKey(path)) {
                    return false;
                }
                cur = cur.nexts.get(path);
            }
            return cur.end != 0;
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                int path = prefix.charAt(i) - 'a';
                if (!cur.nexts.containsKey(path)) {
                    return false;
                }
                cur = cur.nexts.get(path);
            }
            return true;
        }
    }
}
