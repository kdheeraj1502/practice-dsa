package stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32,10);
        //
        List<Integer> evenNumber = list.stream().filter(no -> no%2==0).collect(Collectors.toList());
        System.out.println(evenNumber);

        //find all the number statring with 1

        System.out.println("print all number starts with 1");
        list.stream().map(s-> s+"")
                .filter(s-> s.startsWith("1"))
                .forEach(System.out::println);

        System.out.println("duplicate numbers");

        Set<Integer> set = new HashSet<>();
        list.stream().filter(n-> !set.add(n)).forEach(System.out::println);

        System.out.println("find first element of the list");

        //find first element of the list
        list.stream().findFirst().ifPresent(System.out::println);

        System.out.println("find the total number of elements present in the list using Stream functions?");
        System.out.println(list.stream().count());

        System.out.println("max value");
        System.out.println(list.stream().max(Integer::compare).get());


        //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        System.out.println(result);
        System.out.println("find firts non-repeated character");
        String input = "Java articles are Awesome";

        Character result1 = input.chars().mapToObj(s-> Character.toLowerCase((char) s))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(result1);


        // find the first repeated character in it using Stream functions?
        System.out.println("find the first repeated character in it using Stream functions?");
        Character resutl2 = input.chars().mapToObj(s->Character.toLowerCase(Character.toLowerCase((char) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue()>1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('N');
        System.out.println(resutl2);

        //find count of all element in the string
        System.out.println("find the count of all character");
        Map<Character, Long> result3= input.chars().mapToObj(s->Character.toLowerCase((char) s))
                .filter(s-> !s.equals(' '))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result3);


        //3 apple, 2 banana, others 1
        List<String> items1 =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result4=
                items1.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        System.out.println(result4);

        // Given a list of integers, sort all the values present in it using Stream functions?
        System.out.println(" Given a list of integers, sort all the values present in it using Stream functions?");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        List<Integer> sortedList = myList.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        //Given a list of integers, sort all the values present in it in descending order using Stream functions?
        System.out.println("Given a list of integers, sort all the values present in it in descending order using Stream functions?");

        List<Integer> sortedListDesc = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedListDesc);

        //Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
        System.out.println("Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.");


        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));

        //Write a Java 8 program to concatenate two Streams?
        System.out.println("Write a Java 8 program to concatenate two Streams?");
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");

        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());

        // Concatenated the list1 and list2 by converting them into Stream

        concatStream.forEach(str-> System.out.print(str + " "));

        // Java 8 program to perform cube on list elements and filter numbers greater than 50.
        System.out.println(" Java 8 program to perform cube on list elements and filter numbers greater than 50.");
        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
        integerList.stream().map(i-> i*i*i).filter(i-> i>50).forEach(System.out::println);
        //Write a Java 8 program to sort an array and then convert the sorted array into Stream?
        System.out.println("Write a Java 8 program to sort an array and then convert the sorted array into Stream?");
        int arr[] = { 99, 55, 203, 99, 4, 91 };
        Arrays.parallelSort(arr);
        // Sorted the Array using parallelSort()

        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        /* Converted it into Stream and then
           printed using forEach */

        //How to use map to convert object into Uppercase in Java 8?
        System.out.println("How to use map to convert object into Uppercase in Java 8?");
        items1.stream().map(String::toUpperCase).forEach(System.out::println);

        //How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
        System.out.println("How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?");
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));

        noteLst.add(new Notes(6, "note4", 66));

        Map<String, Integer> resultMap = noteLst.stream().sorted(Comparator.comparingLong(Notes::getId).reversed())
                .collect(Collectors.toMap(Notes::getName, Notes::getLabel , (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(resultMap);

        //How to count each element/word from the String ArrayList in Java8?
        System.out.println("How to count each element/word from the String ArrayList in Java8?");
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> result5 = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result5);

        //How to find only duplicate elements with its count from the String ArrayList in Java8?
        System.out.println("How to find only duplicate elements with its count from the String ArrayList in Java8?");
        List<String> names1 = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> result6 = names1.stream().filter(x -> Collections.frequency(names, x)> 1).
        collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result6);

        // How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
        System.out.println(" How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?");
        List<String> names2 = Arrays.asList("AA", "BB", "AA", "", "CC");
        Optional.ofNullable(names2).orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull)
                . forEach(System.out::println);

        //display the longest string
        List<String> words = Arrays.asList("GFG", "Geeks", "for",
                "GeeksQuiz", "GeeksforGeeks");
        System.out.println(words.stream().reduce((word1, word2)-> word1.length()> word2.length() ? word1 : word2).get());;

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        int sum = listOfNumbers.parallelStream().reduce(0, Integer::sum) + 5;
        System.out.println(sum);

    }

    public static boolean containsDuplicate(int[] nums) {
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(list);
        return set.size() != list.size();
    }



}
