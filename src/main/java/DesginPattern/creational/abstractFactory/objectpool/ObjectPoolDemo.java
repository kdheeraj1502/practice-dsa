package DesginPattern.creational.abstractFactory.objectpool;

public class ObjectPoolDemo {

    public static void main(String[] args){
        //Create Multiple Email Sender Threads
        for(int i=0; i<10; i++){
            new EmailSender(i).start();
        }
    }
}
