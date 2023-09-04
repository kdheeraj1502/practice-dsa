package Thread;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{


    List<String> outputScraper;
    private CountDownLatch countDownLatch;

    public Worker(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        outputScraper.add("Counted down");
        countDownLatch.countDown();
        System.out.println(countDownLatch.getCount());
    }
}
