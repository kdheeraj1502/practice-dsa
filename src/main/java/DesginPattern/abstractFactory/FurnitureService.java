package DesginPattern.abstractFactory;

public class FurnitureService {
    public static void main(String[] args) {

        FurnitureFactory factory = new ModernFurnitureFactory();
        Chair chair = factory.createChair();
        chair.sitOn();
    }
}
