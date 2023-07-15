package java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicateElements {

    public static void main(String[] args) {
        Set<Integer> items = new HashSet<>();
        int nums[] = { 5, 13, 4, 21, 13, 27, 2, 59, 59, 34 };
        System.out.println(Arrays.toString(Arrays.stream(nums).filter(n -> !items.add(n))
                .collect(HashSet::new, HashSet::add, HashSet::addAll).toArray()));

        Set<Integer> list = new HashSet<>();
        for(int nu : nums){
            if(!list.add(nu)) {
                System.out.println(nu);
            }
        }
    }}
