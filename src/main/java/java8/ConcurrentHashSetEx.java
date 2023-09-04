package java8;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashSetEx {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> numbersMap = new ConcurrentHashMap<>();
        Set<Integer> numbersSet = numbersMap.keySet();
        numbersMap.put(1, "One");
        numbersMap.put(2, "Two");
        numbersMap.put(3, "Three");

        System.out.println("Map before remove: "+ numbersMap);
        System.out.println("Set before remove: "+ numbersSet);

        numbersSet.remove(2);

        System.out.println("Set after remove: "+ numbersSet);
        System.out.println("Map after remove: "+ numbersMap);
    }
}
