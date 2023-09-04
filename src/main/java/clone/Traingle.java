package clone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class Traingle implements Cloneable{

    int a,b,c;
    //Creating a constructor
    Traingle(int x, int y, int z){
        a = x;
        b = y;
        c = z;
    }

    //Displaying the values by making an instance show()
    void show() {
        System.out.println("Sides of triangle are: "+a+b+c);

    }

    public Traingle copy() throws CloneNotSupportedException {
        return (Traingle) this.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Traingle t1 = new Traingle(1,2,5);
        t1.show();
        System.out.println(t1.hashCode());
        Traingle t2 = t1.copy();
        t2.show();
        System.out.println(t2.hashCode());


    }
}
