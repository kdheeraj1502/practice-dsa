package threads;

public class PrintSequenceBy3Threads extends Thread {
    volatile int count = 1;

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                synchronized (this) {
                    if(count % 3 == Integer.parseInt(Thread.currentThread().getName())){
                        System.out.println("Count is : " + count);
                        count++;
                        this.notifyAll();
                    }
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String args[]) {
        PrintSequenceBy3Threads worker = new PrintSequenceBy3Threads();
        Thread t1 = new Thread(worker, "0");
        Thread t2 = new Thread(worker, "1");
        Thread t3 = new Thread(worker, "2");
        t1.start();
        t2.start();
        t3.start();
    }
}
