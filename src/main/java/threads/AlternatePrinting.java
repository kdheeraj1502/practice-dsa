package threads;

public class AlternatePrinting {
    private static final Object lock = new Object();
    private static volatile boolean isThread1Turn = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!isThread1Turn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Thread 1 got interrupted");
                        }
                    }
                    System.out.println("A");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    isThread1Turn = false;
                    lock.notify();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (isThread1Turn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Thread 2 got interrupted");
                        }
                    }
                    System.out.println("B");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    isThread1Turn = true;
                    lock.notify();
                }
            }
        });

        t1.start();
        t2.start();
    }
}



