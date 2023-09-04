package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMapExample {

    public static void main(String[] args) {
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6),
                Arrays.asList(7, 8)

        );

        List<Integer> result = numbers.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(result);

        List<String> fruits = Arrays.asList("apple", "banana", "cherry");

        List<Character> chars = fruits.stream().flatMap(c -> c.chars().mapToObj(ci->(char)ci)).collect(Collectors.toList());
        System.out.println(chars);

        List<String> uppercaseWods = fruits.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(uppercaseWods);
        //Suppose you have a list of words, and you want to find all the unique characters in those words.
        // Write a Java program that takes a list of strings and returns a sorted list of the unique characters in those strings.
        List<String> words = Arrays.asList("hello", "world", "java", "java8/stream");
        List<Character> uniqueChar = words.stream()
                .flatMap(w -> w.chars().mapToObj(c -> (char)c)).sorted().distinct().collect(Collectors.toList());

        System.out.println(uniqueChar);

        //Suppose you have a list of integers, and you want to calculate the sum of the squares of all the even integers in that list.
        // Write a Java program that takes a list of integers and returns the sum of the squares of the even integers in that list.
        List<Integer> no = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = no.stream().filter(n -> n%2==0).map(n-> n*n).mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
