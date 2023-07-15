package threads;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Publisher implements Runnable {
    private BlockingQueue<Integer> queue;

    public Publisher(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (queue.size() < 10) {
                int num = random.nextInt(100);
                queue.put(num);
                System.out.println("Publisher added: " + num + " The size is : " + queue.size());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

 class Subscriber implements Runnable {
    private BlockingQueue<Integer> queue;

    public Subscriber(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int num = queue.take();
                System.out.println("Subscriber received: " + num + " The size is : " + queue.size());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

