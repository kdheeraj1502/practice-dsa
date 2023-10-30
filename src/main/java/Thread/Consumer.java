package Thread;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private final Integer POISON;
    private final BlockingQueue<Integer> que;
    Consumer(Integer poison, BlockingQueue<Integer> que){
        POISON = poison;
        this.que = que;
    }
    @Override
    public void run() {

        while(true){
            try {
                Integer take = que.take();
                process(take);
                // if this is a poison pill, break, exit
                if (take.equals(POISON)) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void process(Integer take) throws InterruptedException {
        System.out.println("[Consumer] Take : " + take);
        Thread.sleep(500);
    }
}
