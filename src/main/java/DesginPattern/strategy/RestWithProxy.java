package DesginPattern.strategy;

public class RestWithProxy implements IRestStrategy{
    @Override
    public String createRestTemplate() {
        return "I am proxy enbaled";
    }
}
