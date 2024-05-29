package DesginPattern.creational.abstractFactory.prototype;

public abstract class Dress implements Cloneable{

    private int quantity=0;
    private double unitPrice=0;

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    @Override
    public String toString() {
        return "Dress{" +
                "quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
