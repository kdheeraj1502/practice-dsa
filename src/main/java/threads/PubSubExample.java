package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PubSubExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Publisher publisher = new Publisher(queue);
        Subscriber subscriber = new Subscriber(queue);

        Thread publisherThread = new Thread(publisher);
        Thread subscriberThread = new Thread(subscriber);

        publisherThread.start();
        subscriberThread.start();
    }
}

