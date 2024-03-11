package lru.cache;

import java.util.Optional;
import java.util.concurrent.BrokenBarrierException;

public interface Cache<K, V> {
    boolean put(K key, V value);

    Optional<V> get(K key) throws InterruptedException, BrokenBarrierException;

    int size();

    boolean isEmpty();

    void clear();
}
