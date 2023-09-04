package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class LoginQueueUsingSemaphore {

    private Semaphore semaphore;

    public LoginQueueUsingSemaphore(int slotLimit) {
        semaphore = new Semaphore(slotLimit);
    }

    boolean tryLogin() {
        return semaphore.tryAcquire();
    }

    void logout() {
        semaphore.release();
    }

    int availableSlots() {
        return semaphore.availablePermits();
    }

    public static void main(String[] args) {
        int slots = 10;
        ExecutorService executors = Executors.newFixedThreadPool(slots);
        LoginQueueUsingSemaphore loginQue = new LoginQueueUsingSemaphore(slots);

        IntStream.range(0, slots).forEach(users -> executors.execute(loginQue::tryLogin));
        executors.shutdown();
        System.out.println(loginQue.availableSlots());
        System.out.println(loginQue.tryLogin());
    }
}
