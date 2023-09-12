package DesginPattern.prototype;

import java.util.Scanner;

public class Appplication {

    public static void main(String[] args) throws CloneNotSupportedException {
        Registry registry = new Registry();

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter your Order Type:");
        String type=sc.next();
        System.out.println("Enter your Quantity");
        int quantity=sc.nextInt();

        Dress order=registry.clone(type);
        order.setQuantity(quantity);

        System.out.println("Your Order is "+order.getQuantity()+" "+order);
        System.out.println("The unit price of a "+order+" is "+order.getUnitPrice()+" LKR");
        System.out.println("total bill is" + order.getQuantity()* order.getUnitPrice());
    }
}
