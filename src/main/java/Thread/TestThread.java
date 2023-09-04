package Thread;

public class TestThread extends Thread{

    @Override
    public void run(){
        System.out.println("thread run");
    }

    public static void main(String[] args) {

        TestThread testThread = new TestThread();
        testThread.start();

        Thread t = new Thread(){
            public void run(){
                System.out.println("thread2");
            }
        };

        t.start();

    }


}
