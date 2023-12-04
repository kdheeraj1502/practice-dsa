package linkedlist.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put("puja" , "1");
        lruCache.put("dheeraj" , "2");
        lruCache.put("nisha" , "3");

        System.out.println(lruCache.get("dheeraj"));
        lruCache.put("aarushi", "4");
        System.out.println(lruCache.get("aarushi"));


    }
}

class LRUCache {
    Node head = new Node("", "");
    Node tail = new Node("","");

    Map<String , Node> map = new HashMap<>();
    int capacity;
    LRUCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.previous = head;
    }

    public void put(String key , String value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity) {
            remove(tail.previous);
        }
        insert(new Node(key, value));
    }

    public String get(String data){
        if(map.containsKey(data)){
            Node node = map.get(data);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return "-1";
        }
    }

    private void insert(Node node) {
        map.put(node.key , node);
        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        headNext.previous = node;
        node.previous = head;

    }

    private void remove(Node node) {

        map.remove(node.key);
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

}

class Node {

    String key;
    String value;
    Node next ;
    Node previous;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
