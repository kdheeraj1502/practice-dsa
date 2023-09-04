package exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
public class AvoidConcurrentModificationException {
    public static void main(String[] args) {
        try{
            List < String > myList = new ArrayList< String >();

            myList.add("1");
            myList.add("2");
            myList.add("3");
            myList.add("4");
            myList.add("5");

            for (int i = 0; i < myList.size(); i++) {
                System.out.println("List value: " + myList.get(i));
                if (myList.get(i).equals("3")) {
                    myList.remove(i);
                    i--;
                    myList.add("6");
                }
            }
            System.out.println("List Size:" + myList.size());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}