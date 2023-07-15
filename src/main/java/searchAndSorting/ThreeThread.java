package searchAndSorting;

public class ThreeThread {

    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t1 = new Thread(worker, "Thread 1");
        Thread t2 = new Thread(worker, "Thread 2");
        Thread t3 = new Thread(worker, "Thread 3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Worker implements Runnable {

    volatile int count = 1;
    @Override
    public void run(){
        while(count < 20){
            synchronized (this){
                if(count % 3 == 0 && Thread.currentThread().getName() == "Thread 3"){
                    System.out.println("Count is : " + count + " By " + Thread.currentThread().getName());
                    count++;
                } else if(count % 3 == 2 && Thread.currentThread().getName() == "Thread 2"){
                    System.out.println("Count is : " + count + " By " + Thread.currentThread().getName());
                    count++;
                } else if((count % 3 == 1 || count == 0) && Thread.currentThread().getName() == "Thread 1"){
                    System.out.println("Count is : " + count + " By " + Thread.currentThread().getName());
                    count++;
                } else {
                    try{
                        this.wait();
                    } catch(Exception ex){

                    }
                }
                this.notify();
            }
        }
    }
}
