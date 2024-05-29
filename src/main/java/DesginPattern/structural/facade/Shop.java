package DesginPattern.structural.facade;

public class Shop {

    public static void main(String[] args) {
        ShopKeeper shopKeeper = new ShopKeeper();
        Mobile mobile = shopKeeper.displayMobile("nokia");
        mobile.model();
        mobile.price();

    }
}
