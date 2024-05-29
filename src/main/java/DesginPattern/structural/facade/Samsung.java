package DesginPattern.structural.facade;

public class Samsung implements Mobile{
    @Override
    public void price() {
        System.out.println("300000");
    }

    @Override
    public void model() {
        System.out.println("Samsung");
    }
}
