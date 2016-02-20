package round2;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(1);
        lru.set(2, 1);
        System.out.println(lru.get(2));
        lru.set(3, 2);
        System.out.println(lru.get(2));
        System.out.println(lru.get(3));
    }

    public void print() {
        Node node = head.next;
        while (node != head) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static int capacity;
    private int cur;
    private Map<Integer, Node> map;
    Node head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0, 0);
        head.pre = head;
        head.next = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;
        removeNode(node);
        addToHead(node);
        return node.val;
    }

    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            removeNode(node);
        } else {
            node = new Node(key, value);
            cur++;
            if (cur > capacity) {
                Node tmp = head.pre;
                map.remove(tmp.key);
                removeNode(tmp); // remove tail
                cur--;
            }
            map.put(key, node);
        }
        addToHead(node);
    }

    static class Node {
        int key;
        int val;
        Node pre;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private void addToHead(Node node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}
