package DesginPattern.factory;

public class EmailNotification implements Notification{
    @Override
    public void send() {
        System.out.println("send notification by email");
    }
}
