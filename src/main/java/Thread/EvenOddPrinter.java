package Thread;

public class EvenOddPrinter {

    private static final int MAX_NUMBER = 20;
    private static int number = 1;

    private static final Object lock = new Object();
    public static void main(String[] args) {
        Thread evenThread = new Thread(new EvenRunnable());
        Thread oddThread = new Thread(new OddRunnable());

        evenThread.start();
        oddThread.start();

    }

    private static class EvenRunnable implements Runnable {
        @Override
        public void run() {

            while(number<=MAX_NUMBER){
                synchronized (lock){
                    if(number%2 == 0){
                        System.out.println("even nunber: "+ number);
                        number++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

    private static class OddRunnable implements Runnable {
        @Override
        public void run() {

            while(number<=MAX_NUMBER){
                synchronized (lock){
                    if(number%2 != 0){
                        System.out.println("odd nunber: "+ number);
                        number++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }
}
