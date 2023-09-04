package Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueExample {

    public static void main(String[] args) {

        //ForkJoinPool
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        new Thread(new Producer(-1, blockingQueue)).start();
        new Thread(new Consumer(-1, blockingQueue)).start();
    }
}
