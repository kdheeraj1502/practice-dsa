package DesginPattern.behavioural.strategy;

public class RestConnector {

    public IRestStrategy strategy;
    RestConnector(IRestStrategy strategy){
        this.strategy = strategy;
    }

    public String getRestTemplateBasedOnStratgey(){
        return strategy.createRestTemplate();
    }
}
