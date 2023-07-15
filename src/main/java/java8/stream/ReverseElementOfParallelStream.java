package java8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseElementOfParallelStream {
    public static void main(String[] args) {
        List<Integer> lists = Arrays.asList(11, 22, 33, 44);
        List<Integer> result = lists.parallelStream().collect(Collectors.collectingAndThen(Collectors.toList(),
                list -> {
                    Collections.reverse(list);
                    return list;
                }));
        System.out.println(result);
    }
}
