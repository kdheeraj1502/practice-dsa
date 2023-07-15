package array;

import java.util.Comparator;
import java.util.HashMap;

public class CustomArrayListDemo {
    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>(10);

        list.add(1);
        list.add(2);
        list.add(3);
       //list.remove(2);
        System.out.println(list.get(1));
        list.print();

       // HashMap

        System.out.println();

        int n = 16; //                 1111
        ///   11011011011010011010110000110  alll zero

        //                           00110
       int hash = list.hashCode();
        System.out.println(hash);
       int a =  (n - 1) & hash;
        System.out.println( "Value is " + a);

    }
}
