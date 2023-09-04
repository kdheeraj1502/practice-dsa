package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Grouping {
    public static void main(String[] args) {
        String str = "AAABBCCCCDDDBBB";

        String out = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c))
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + String.valueOf(entry.getValue().size()))
                .collect(Collectors.joining());

        System.out.println(out);

        String result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c))
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + String.valueOf(entry.getValue().size()))
                .collect(Collectors.joining());

        System.out.println(result);

       Map<Object, List<Character>> outpiut =  str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(c -> c));

      // .entrySet().stream()
    //            .map(entry -> entry.getKey() + String.valueOf(entry.getValue())).collect(Collectors.joining());
        System.out.println(outpiut);

        Map<Character, Long> result1 = str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result1);
    }
}
