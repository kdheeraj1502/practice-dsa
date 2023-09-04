package exceptions;

import java.util.*;

public class AvoidConcurrentModification_1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(19);
        list.add(6);
        list.add(14);
        list.add(12);
        list.add(66);
        list.add(8);
        System.out.println(list);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer val = it.next();
            if (val.equals(6)) {
                // list.remove(6);
                it.remove();
            }
        }

        System.out.println(list);
    }

}
