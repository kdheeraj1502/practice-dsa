package lru.cache;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache<K, V> implements Cache<K, V> {
    private int size;
    private Map<K, LinkedListNode<CacheElement<K, V>>> linkedListNodeMap;  // cache storage
    private DoublyLinkedList<CacheElement<K, V>> doublyLinkedList; // eviction history
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    CyclicBarrier barrier;

    public LRUCache(int size, CyclicBarrier barrier) {
        this.size = size;
        this.linkedListNodeMap = new ConcurrentHashMap<>(size);
        this.doublyLinkedList = new DoublyLinkedList<>();
        this.barrier = barrier;
    }

    @Override
    public boolean put(K key, V value) {
        this.lock.writeLock().lock();
        try {
            CacheElement<K, V> item = new CacheElement<K, V>(key, value);
            LinkedListNode<CacheElement<K, V>> newNode;
            if (this.linkedListNodeMap.containsKey(key)) {
                LinkedListNode<CacheElement<K, V>> node = this.linkedListNodeMap.get(key);
                newNode = doublyLinkedList.updateAndMoveToFront(node, item);
            } else {
                if (this.size() >= this.size) {
                    this.evictElement();
                }
                newNode = this.doublyLinkedList.add(item);
            }
            if (newNode.isEmpty()) {
                return false;
            }
            this.linkedListNodeMap.put(key, newNode);
            return true;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    @Override
    public Optional<V> get(K key) throws InterruptedException, BrokenBarrierException {
        this.lock.readLock().lock();

        //barrier.await();
        /// 4 thread

        try {
            LinkedListNode<CacheElement<K, V>> linkedListNode = this.linkedListNodeMap.get(key);
            if (linkedListNode != null && !linkedListNode.isEmpty()) {
                // 4 thread
                linkedListNodeMap.put(key, this.doublyLinkedList.moveToFront(linkedListNode));
                return Optional.of(linkedListNode.getElement().getValue());
            }
        //    3 thread
            Thread.sleep(500000);
            return Optional.empty();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @Override
    public int size() {
        this.lock.readLock().lock();
        try {
            return doublyLinkedList.size();
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        this.lock.writeLock().lock();
        try {
            linkedListNodeMap.clear();
            doublyLinkedList.clear();
        } finally {
            this.lock.writeLock().unlock();
        }
    }


    private boolean evictElement() {
        this.lock.writeLock().lock();
        try {
            LinkedListNode<CacheElement<K, V>> linkedListNode = doublyLinkedList.removeTail();
            if (linkedListNode.isEmpty()) {
                return false;
            }
            linkedListNodeMap.remove(linkedListNode.getElement().getKey());
            return true;
        } finally {
            this.lock.writeLock().unlock();
        }
    }
}