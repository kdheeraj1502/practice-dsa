package DesginPattern.adapter;

public class BallPen implements Pen{
    @Override
    public void write() {
        System.out.println("write by pen");
    }
}
