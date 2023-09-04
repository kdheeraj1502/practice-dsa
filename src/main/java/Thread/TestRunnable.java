package Thread;

public class TestRunnable implements Runnable{


    @Override
    public void run() {
        System.out.println("runnable1");
    }

    public static void main(String[] args) {
        TestRunnable t = new TestRunnable();
        Thread thread = new Thread(t);
        thread.start();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnabe2");
            }
        };
        Runnable runnable1 = ()-> System.out.println("runnable3");

        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable1);
        thread2.start();
    }


}
