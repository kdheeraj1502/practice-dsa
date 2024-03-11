package lru.cache;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Application {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4);

        LRUCache<Integer, String> cache = new LRUCache<>(3, barrier);
        cache.put(1, "One");
        cache.put(2, "two");
        cache.put(3, "three");

        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                try {
                    cache.get(1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        System.out.println("Completed");
    }
}
