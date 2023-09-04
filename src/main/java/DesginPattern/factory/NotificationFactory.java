package DesginPattern.factory;

public class NotificationFactory {

    public Notification createFactory(String channel){
        if(channel== null || channel.isEmpty()){
            return null;
        }

        switch (channel){
            case "SMS" :
                return new SmsNotification();
            case "EMAIL" :
                return new EmailNotification();
            default:
                throw new IllegalArgumentException("no channel found");
        }
    }
}
