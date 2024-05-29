package DesginPattern.creational.abstractFactory;

public class VintageTable implements Table{
    @Override
    public void useFor() {
        System.out.println("for client who look for vintage table");
    }
}
