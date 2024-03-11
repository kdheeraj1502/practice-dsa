package array;

import java.util.ArrayList;
import java.util.List;

interface A  {

}

interface B extends A {

}
class C implements B, A {

}

public class AddIntegerInArray {
    public static void main(String[] args) {
        List<? super Number> list1 = new ArrayList<Object>();
        Number d = new  Double(7);
        Number f = new  Float(7);
        Number l = new  Long(7);
        Number i = new  Integer(7);


     //   ? must be super of XYZ   ==> Object is super of Number
        list1.add(1);
        list1.add(2l);
        list1.add(2.0);
        list1.add(5.8f);
        System.out.println(list1);

        List<? extends Integer> list2 = new ArrayList<>();
       // list2.add(9);

        System.out.println(list2);
    }
}

