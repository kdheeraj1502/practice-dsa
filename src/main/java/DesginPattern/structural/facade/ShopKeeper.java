package DesginPattern.structural.facade;


public class ShopKeeper {

    public Mobile displayMobile(String model){
        switch (model){
            case "iphone":
                return new Iphone();
            case "samsung":
                return new Samsung();
            default:
                System.out.println("we do not have this available in stock");
                return null;

        }
    }
}
