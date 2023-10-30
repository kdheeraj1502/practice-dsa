package Thread;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue<T> {

    private final Queue<T> que = new LinkedList<>();
    private final int capacity;

    CustomBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(T item) throws InterruptedException {
        while (que.size() >= capacity) {
            wait();
        }
        que.offer(item);
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (que.isEmpty()) {
            wait();
        }
        T item = que.poll();
        notifyAll();
        return item;
    }

    public synchronized int size() {
        return que.size();
    }

    public static void main(String[] args) {
        CustomBlockingQueue<Integer> blockingQueue = new CustomBlockingQueue<Integer>(3);
        Thread producer = new Thread(() -> {

            try {
                for (int i = 0; i <= 5; i++) {
                    //System.out.println("Producing thread" + Thread.currentThread().getName());
                    blockingQueue.put(i);
                    System.out.println("Put: " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        });

        Thread consumer = new Thread(() -> {

            try {
                for (int i = 0; i <= 5; i++) {
                    //System.out.println("Cnsuming thread" + Thread.currentThread().getName());
                    Integer item = blockingQueue.take();
                    System.out.println("take: " + item);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        });

        producer.start();
        consumer.start();
    }
}
