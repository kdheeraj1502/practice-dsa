
public class Worker extends Thread {
    int count = 1;
    String val = "A";

    public void run(){
        while(true){
            try {
              //  Thread.sleep(3000);
                synchronized (this){
                    if((count%Integer.parseInt(Thread.currentThread().getName())) != 0){
                        this.wait();
                    } else{
                        System.out.println(val);
                        count++;
                        if(Thread.currentThread().getName() == "1"){
                            val = "B";
                        }
                        if(Thread.currentThread().getName() == "2"){
                            val = "A";
                        }
                    }
                    this.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String args[]) {
        Worker worker = new Worker();
        Thread t1 = new Thread(worker, "1");
        Thread t2 = new Thread(worker, "2");
        t1.start();
        t2.start();
    }
}
