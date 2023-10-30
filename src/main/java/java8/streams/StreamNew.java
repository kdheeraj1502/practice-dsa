package java8.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamNew {

    public static void main(String[] args) {
        List<String> lists = Arrays.asList("puja", "test1" , "puja");

        List<String> disticintList = lists.stream().distinct().collect(Collectors.toList());

        System.out.println(disticintList);

        Map<String , Integer> findLength = disticintList.stream().collect(Collectors.toMap(e ->e , String::length));

        System.out.println(findLength);


    }

}

