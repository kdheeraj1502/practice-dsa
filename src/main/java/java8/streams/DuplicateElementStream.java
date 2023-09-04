//package java8.streams;
//
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//public class DuplicateElementStream {
//
//    public static void main(String[] args) {
//        List<String> str = new ArrayList<>();
//        Set<String> set = new HashSet<>();
//        List<String> ans = str.stream().filter(s -> !set.add(s)).collect(Collectors.toList());
//
//
//        System.out.println(ans);
//        System.out.println(str.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
//
//        System.out.println("-------------");
//
//        Optional.of(str).ifPresent(a -> a.forEach(
//                System.out::println
//        ));
//
//        //Select * from employee where salary in (select Max(Salary) from employee);
//        StringBuilder
//
//    }
//}
