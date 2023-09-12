package DesginPattern.objectpool;

import java.util.LinkedList;
import java.util.Queue;

public class EmailClientPoolManager {

    private static final EmailClientPoolManager EMAIL_CLIENT_POOL_MANAGER = new EmailClientPoolManager();

    private static final int POOL_SIZE = 5;

    private final Queue<EmailClient> pool;


    public EmailClientPoolManager() {
        this.pool = new LinkedList<>();
        for(int i =0; i<POOL_SIZE ; i++){
            pool.offer(new EmailClient(i));
        }
    }

    public static EmailClient borrowCLient() throws InterruptedException{

        System.out.println("Thread ["+Thread.currentThread().getName()+"] is waiting for borrow request");
        synchronized (EMAIL_CLIENT_POOL_MANAGER.pool){
            while(EMAIL_CLIENT_POOL_MANAGER.pool.isEmpty()){
                EMAIL_CLIENT_POOL_MANAGER.pool.wait();
            }

            return EMAIL_CLIENT_POOL_MANAGER.pool.poll();
        }
    }

    public static void returnCLient(EmailClient client) throws InterruptedException{
        System.out.println("Thread ["+Thread.currentThread().getName()+"] is returning the client");

        synchronized (EMAIL_CLIENT_POOL_MANAGER.pool){
            EMAIL_CLIENT_POOL_MANAGER.pool.offer(client);
            EMAIL_CLIENT_POOL_MANAGER.pool.notify();
        }

    }
}
