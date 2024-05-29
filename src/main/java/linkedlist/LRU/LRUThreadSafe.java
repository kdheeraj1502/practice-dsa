package linkedlist.LRU;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public class LRUThreadSafe {

        private AtomicReference<Queue<String>> que;
        private Map<String, String> map;
        private int capacity;

    LRUThreadSafe(int capacity) {
            this.capacity = capacity;

            que = new AtomicReference<>(new LinkedList<>());
            map = new HashMap<>();
        }

        public String get(String key) {
            if (map.containsKey(key)) {
                String data = map.get(key);
                Queue<String> currentQueue = que.get();
                currentQueue.remove(key);
                currentQueue.offer(key);
                que.set(currentQueue);
                return data;
            } else {
                return "-1";
            }
        }

        public void put(String key, String data) {
            if (map.size() >= capacity) {
                Queue<String> currentQueue = que.get();
                String removedKey = currentQueue.poll();
                map.remove(removedKey);
                que.set(currentQueue);
            }
            map.put(key, data);
            Queue<String> currentQueue = que.get();
            currentQueue.offer(key);
            que.set(currentQueue);
        }

        public static void main(String[] args) {
            LRUQueue lruCache = new LRUQueue(3);
            lruCache.put("puja", "1");
            lruCache.put("dheeraj", "2");
            lruCache.put("nisha", "3");

            System.out.println(lruCache.get("dheeraj"));
            lruCache.put("aarushi", "4");
            System.out.println(lruCache.get("aarushi"));
        }
    }

