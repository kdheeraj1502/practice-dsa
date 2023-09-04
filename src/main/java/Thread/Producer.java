package Thread;

import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

public class Producer implements Runnable{

    private final Integer POISON;
    private BlockingQueue<Integer> que;

    public Producer(Integer poison, BlockingQueue<Integer> queue) {
        POISON = poison;
        this.que = queue;
    }
    @Override
    public void run() {

        try {
            process();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void process() throws InterruptedException {
        int range = 20;

        IntStream.range(0, 20).forEach(n -> {
            System.out.println("[Producer] Put : " + n);
            try {
                que.put(n);
                System.out.println("[Producer] Queue remainingCapacity : " + que.remainingCapacity());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        que.put(POISON);
    }
}
