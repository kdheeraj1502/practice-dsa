package linkedlist.LRU;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUQueue {

    private Queue<String> que;
    private Map<String ,String> map ;
    int capacity;

    LRUQueue(int capacity){
        this.capacity = capacity;
        que = new LinkedList<>();
        map = new HashMap<>();
    }

    public String get(String key){
        if(map.containsKey(key)){
            String data = map.get(key);
            que.remove(key);
            que.offer(key);
            return data;
        } else {
            return "-1";
        }
    }

    public void put(String key, String data){
        if(map.size()>=capacity){
            String removedKey = que.poll();
            map.remove(removedKey);
        }
        map.put(key, data);
        que.offer(key);
    }

    public static void main(String[] args) {
        LRUQueue lruCache = new LRUQueue(3);
        lruCache.put("puja" , "1");
        lruCache.put("dheeraj" , "2");
        lruCache.put("nisha" , "3");

        System.out.println(lruCache.get("dheeraj"));
        lruCache.put("aarushi", "4");
        System.out.println(lruCache.get("aarushi"));

    }

}
