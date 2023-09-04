package java8.stream.reduce;

import java.util.*;

public class ReduceArrayList {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(12,3,10,5);
        int even = number.stream().filter(x -> x%2 == 0).reduce(0, (ans, i) -> ans + 1);
        System.out.println(even);

    }
}
