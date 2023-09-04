package searchAndSorting;

public class ThreeThread1 {

    public static void main(String[] args) {
        Worker1 worker = new Worker1();
        Thread t1 = new Thread(worker, "1");
        Thread t2 = new Thread(worker, "2");
        Thread t3 = new Thread(worker, "0");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Worker1 implements Runnable {

    volatile int count = 1;
    @Override
    public void run(){
        while(count < 20){
            synchronized (this){
                if(count % 3 != Integer.parseInt(Thread.currentThread().getName())){
                    try{
                        this.wait();
                    } catch(Exception ex){

                    }
                } else{
                    System.out.println("Count is : " + count + " By " + Thread.currentThread().getName());
                    count++;

                }
                this.notify();
            }
        }
    }
}
