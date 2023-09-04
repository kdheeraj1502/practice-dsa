package DesginPattern.factory;

public class SmsNotification implements Notification{
    @Override
    public void send() {
        System.out.println("send notification by sms");
    }
}
