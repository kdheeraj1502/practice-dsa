package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numThreads = 3; // number of threads to wait for
        CyclicBarrier barrier = new CyclicBarrier(numThreads, new BarrierAction());

        // create and start threads
        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(new Worker1(barrier));
            thread.start();
        }
    }
}

class Worker1 implements Runnable {
    private CyclicBarrier barrier;

    public Worker1(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        // do some work
        System.out.println(Thread.currentThread().getName() + " started");
        try {
            Thread.sleep(1000);
            // wait for other threads
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}

class BarrierAction implements Runnable {
    @Override
    public void run() {
        System.out.println("All threads have reached the barrier");
    }
}

