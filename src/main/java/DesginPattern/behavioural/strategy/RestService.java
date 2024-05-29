package DesginPattern.behavioural.strategy;

public class RestService {

    public static void main(String[] args) {
        RestConnector restConnector = new RestConnector(new RestWithProxy());
        String resTemp = restConnector.getRestTemplateBasedOnStratgey();
        System.out.println(resTemp);
    }

}
