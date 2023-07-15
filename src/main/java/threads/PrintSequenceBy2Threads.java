package threads;

public class PrintSequenceBy2Threads extends Thread {
    volatile int count = 1;
    String val = "A";

    public void run() {
        while (true) {
            try {
                 Thread.sleep(1000);
                synchronized (this) {
                    if(count % 2 == Integer.parseInt(Thread.currentThread().getName())){
                        this.wait();
                    }
                    System.out.println(val);
                    count++;
                    if(Thread.currentThread().getName() == "0"){
                        val = "B";
                    }
                    if(Thread.currentThread().getName() == "1"){
                        val = "A";
                    }
                    this.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String args[]) {
        PrintSequenceBy2Threads worker = new PrintSequenceBy2Threads();
        Thread t1 = new Thread(worker, "0");
        Thread t2 = new Thread(worker, "1");
        t1.start();
        t2.start();
    }
}
