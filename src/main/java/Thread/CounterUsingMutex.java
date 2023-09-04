package Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class CounterUsingMutex {

    private Semaphore mutex;

    private int count;

    CounterUsingMutex(){
        mutex = new Semaphore(1);
        count= 0;

    }

    void increase() throws InterruptedException {
        mutex.acquire();
        this.count = this.count + 1;
        Thread.sleep(1000);
        mutex.release();

    }
    int getCount() {
        return this.count;
    }
    boolean hasQueueThreads(){
        return mutex.hasQueuedThreads();
    }

    public static void main(String[] args) {
        int count = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CounterUsingMutex counterUsingMutex = new CounterUsingMutex();
        IntStream.range(0, count).forEach( user -> executorService.execute( ()->{
        try {
            counterUsingMutex.increase();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
        ));;

        executorService.shutdown();
        System.out.println(counterUsingMutex.hasQueueThreads());
        System.out.println(count);
    }

}
