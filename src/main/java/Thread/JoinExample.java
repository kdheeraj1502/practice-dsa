package Thread;

public class JoinExample {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(
                () ->{
                    System.out.println("Thread 1 is running");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread 1 is finished" + Thread.currentThread().getName());
                }
        );

        Thread t2 = new Thread(
                () ->{
                    System.out.println("Thread 2 is running");
                    try {
                        Thread.sleep(2000);
                        t1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread 2 is finished" + Thread.currentThread().getName());
                }
        );

        Thread t3 = new Thread(
                () ->{
                    System.out.println("Thread 3 is running");
                    try {
                        Thread.sleep(2000);
                        t2.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread 3 is finished" + Thread.currentThread().getName());
                }
        );

        t1.start();
        t2.start();
        t3.start();


        System.out.println("main thread " + Thread.currentThread().getName());
    }
}
