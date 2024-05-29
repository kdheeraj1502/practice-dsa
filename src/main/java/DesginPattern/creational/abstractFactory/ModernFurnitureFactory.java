package DesginPattern.creational.abstractFactory;

public class ModernFurnitureFactory implements FurnitureFactory{
    @Override
    public Table createTable() {
        return new ModernTable();
    }

    @Override
    public Chair createChair() {
        return new ModernChair();
    }
}
