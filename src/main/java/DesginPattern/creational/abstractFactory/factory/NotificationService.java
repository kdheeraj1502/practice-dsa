package DesginPattern.creational.abstractFactory.factory;

public class NotificationService {

    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        Notification notification = factory.createFactory("EMAIL");
        notification.send();
    }
}
