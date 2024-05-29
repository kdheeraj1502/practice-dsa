package DesginPattern.behavioural.strategy;

public class RestWithSSLStrategy implements IRestStrategy{
    @Override
    public String createRestTemplate() {
        return "I am rest enabled";
    }
}
