package threads;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 5; // number of threads to wait for
        CountDownLatch latch = new CountDownLatch(numThreads);

        // create and start threads
        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(new Worker(latch));
            thread.start();
        }

        // wait for threads to finish
        latch.await();

        System.out.println("All threads have finished");
    }
}

class Worker implements Runnable {
    private CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        // do some work
        System.out.println(Thread.currentThread().getName() + " started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished");

        // signal that this thread has finished
        latch.countDown();
    }
}
