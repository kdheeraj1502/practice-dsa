package linkedlist.LFU;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache<K, V> {

    int capacity;
    Map<K, V> cache = new HashMap<>();
    Map<K, Integer> freqMap = new HashMap<>();
    Map<Integer, LinkedHashSet<K>> freqGrp = new HashMap<>();

    int minFreq = 0;

    LFUCache(int capacity){
        this.capacity = capacity;
        this.minFreq = 0;
    }


    public V get(K key){
        if(!cache.containsKey(key)){
            return null;
        }

        updateFrequency(key);
        return cache.get(key);
    }

    public void put(K key , V value){
        if(capacity<=0){
            return;
        }
        if(cache.size()>=capacity){
            evict();
        }
        if(cache.containsKey(key)){
            updateFrequency(key);
        } else {
            freqMap.put(key, 1);
            minFreq = 1;
            freqGrp.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        }
        cache.put(key, value);
    }

    private void evict() {

        LinkedHashSet<K> minFreqGrp = freqGrp.get(minFreq);
        if(minFreqGrp!=null && !minFreqGrp.isEmpty()){
            Iterator<K> itr = minFreqGrp.iterator();
            if (itr.hasNext()) {
                K evictedKey = itr.next();
                itr.remove();
                cache.remove(evictedKey);
                freqMap.remove(evictedKey);

                // If the minFrequency group becomes empty after eviction, update minFrequency
                if (freqGrp.isEmpty()) {
                    minFreq++;
                }
            }
        }
    }

    private void updateFrequency(K key) {
        int frequency = freqMap.get(key);
        freqMap.put(key , frequency+1);
        //remove key from its crrenct frwquncey group
        freqGrp.get(frequency).remove(key);
        freqGrp.computeIfAbsent(frequency+1 , k->new LinkedHashSet<>()).add(key);
        if (freqGrp.get(minFreq).isEmpty()) {
            minFreq++;
        }
    }

    public static void main(String[] args) {
        LFUCache<Integer, String> lfuCache = new LFUCache<>(3);

        lfuCache.put(1, "One");
        lfuCache.put(2, "Two");
        lfuCache.put(3, "Three");

        System.out.println("Initial Cache:");
        lfuCache.printCache();

        System.out.println("\nGet Value for Key 2: " + lfuCache.get(2));

        lfuCache.put(4, "Four"); // This may evict the least frequently used entry

        System.out.println("\nUpdated Cache:");
        lfuCache.printCache();
    }

    private void printCache() {

            LinkedHashSet<K> frequencyGroup = freqGrp.get(minFreq);
            if (frequencyGroup != null) {
                System.out.println("Frequency " + minFreq + ": " + frequencyGroup);
            }
    }

}
