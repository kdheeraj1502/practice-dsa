package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountDownLatchEx {

    public static void main(String[] args) throws InterruptedException {
        List<String> outpurScrapper = new CopyOnWriteArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(5);

        List<Thread> worker = Stream.generate(()-> new Thread(new Worker(outpurScrapper, countDownLatch))).limit(5).collect(Collectors.toList());
        System.out.println(worker);

        worker.forEach(Thread::start);

            countDownLatch.await();
        outpurScrapper.add("released lock");

        System.out.println(outpurScrapper);
    }



}
