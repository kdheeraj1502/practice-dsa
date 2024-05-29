package DesginPattern.structural.facade;

public class Iphone implements Mobile{
    @Override
    public void price() {
        System.out.println("1,200000");
    }

    @Override
    public void model() {
        System.out.println("Iphone7");
    }
}
