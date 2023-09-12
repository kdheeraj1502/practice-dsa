package Thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class EvenOddThreadSemaphore {

    private static final Semaphore evenSemaphore = new Semaphore(0); // Start with 0 permits
    private static final Semaphore oddSemaphore = new Semaphore(1);  // Start with 1 permit

    private static final Integer MAX_NUMBER = 10;

    public static void main(String[] args) {

        AtomicInteger number = new AtomicInteger(1);
        Thread evenThread = new Thread(() -> {
            while ((number.get()) <= MAX_NUMBER) {
                try {
                    evenSemaphore.acquire();
                    if ((number.get() <= MAX_NUMBER) && (number.get() % 2 == 0)) {
                        System.out.println("even: " + number);
                        number.getAndIncrement(); // Increment after printing
                    }

                    oddSemaphore.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while ((number.get()) <= MAX_NUMBER) {
                try {
                    oddSemaphore.acquire();
                    if ((number.get() <= MAX_NUMBER) && (number.get() % 2 == 0)) {
                        System.out.println("odd: " + number);
                        number.getAndIncrement(); // Increment after printing
                    }

                    evenSemaphore.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        evenThread.start();
        oddThread.start();
    }
}
