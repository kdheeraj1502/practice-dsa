package java8.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindDuplicateElements {

    public static void main(String[] args) {
        Set<Integer> items = new HashSet<>();
        int nums[] = { 5, 13, 4, 21, 13, 27, 2, 59, 59, 34 };
        System.out.println(Arrays.stream(nums).boxed().filter(n -> !items.add(n))
                .collect(Collectors.toSet()));

        Set<Integer> list = new HashSet<>();
        for(int nu : nums){
            if(!list.add(nu)) {
                System.out.println(nu);
            }
        };


       List<Integer> duplicates =  Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                        .entrySet().stream().filter(entry -> entry.getValue()>1l)
                        .map(Map.Entry::getKey)
                                .collect(Collectors.toList());

        System.out.println(duplicates);



    }}
