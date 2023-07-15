package exceptions;

import java.util.*;

public class AvoidConcurrentModification {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 6, 2, 7, 4, 6, 8, 9, 0, 15);
        Iterator<Integer> it = list.iterator();
        try {
            while (it.hasNext()) {
                int val = it.next();
                System.out.print(val + ", ");
                if (val == 2)
                    it.remove();
            }
        } catch (Exception exception) {
            System.out.println("Exception " + exception.getMessage());
        }
        System.out.println();
        try {
            for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
                Integer integer = iterator.next();
                System.out.print(integer + ", ");
                if (integer == 2) {
                    iterator.remove();
                }
            }
        } catch (Exception exception) {
            System.out.println("Exception 2 " + exception.getMessage());
        }
        System.out.println();
        try {
            List < String > myList = Arrays.asList("4", "6", "2", "7", "4", "6", "8", "9", "0", "15");

            myList.add("4");
            myList.add("6");
            myList.add("2");
            myList.add("7");
            myList.add("4");
            myList.add("6");
            myList.add("8");
            myList.add("9");
            myList.add("0");
            myList.add("15");

            for (int i = 0; i < myList.size(); i++) {
                System.out.print( myList.get(i) + ", ");
                if (myList.get(i).equals("2")) {
                    myList.remove(i);
                    i--;
                    myList.add("6");
                }
            }
        } catch (Exception exception) {
            System.out.println("Exception 3 " + exception.getMessage());
        }

    }
}
