package DesginPattern.abstractFactory;

public class VintageFurnitureFactory implements FurnitureFactory{
    @Override
    public Table createTable() {
        return new VintageTable();
    }

    @Override
    public Chair createChair() {
        return new VintageChair();
    }
}
