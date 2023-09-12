package DesginPattern.objectpool;

import java.util.Random;

public class EmailSender extends Thread{

    public EmailSender(int id){
        super(String.format("T-%03d",id));
    }

    @Override
    public void run() {

        try{
            EmailClient client = EmailClientPoolManager.borrowCLient();
            System.out.println("Thread ["+Thread.currentThread().getName()+"] borrowed  Email  Client  with ID ["+client.getId()+"]");
            // Do Something using client, like "send email"
            Thread.sleep(new Random().nextInt(10)*1000);
            EmailClientPoolManager.returnCLient(client);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
