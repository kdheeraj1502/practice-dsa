package threads;

public class AlternatePrinting extends Thread {
    private static final Object lock = new Object();
    private static boolean isThread1Turn = true;

    @Override
    public void run(){
        while (true) {
            synchronized (lock) {
                try {
                    if (!isThread1Turn) {
                        lock.wait();
                    }
                    System.out.print("A ");
                    isThread1Turn = false;
                    lock.notify();
                    Thread.sleep(500); // Pause for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> printA());
        Thread thread2 = new Thread(() -> printB());

        thread1.start();
        thread2.start();
    }

    public static void printA() {
        while (true) {
            synchronized (lock) {
                try {
                    if (!isThread1Turn) {
                        lock.wait();
                    }
                    System.out.print("A ");
                    isThread1Turn = false;
                    lock.notify();
                    Thread.sleep(500); // Pause for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void printB() {
        while (true) {
            synchronized (lock) {
                try {
                    if (isThread1Turn) {
                        lock.wait();
                    }
                    System.out.print("B ");
                    isThread1Turn = true;
                    lock.notify();
                    Thread.sleep(500); // Pause for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

