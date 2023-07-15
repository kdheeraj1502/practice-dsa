package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupingByInJAVA8 {
    public static void main(String[] args) {
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
        Map<String, Long> result =  items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
        char c [] = "AAABBCCCCDDDBBB".toCharArray();

        Map<Character, Long> output = Pattern.compile("").splitAsStream("AAABBCCCCDDDBBB")
                .map(i -> i.charAt(0)).collect(Collectors.groupingBy(Function.identity(),  Collectors.counting()));
        System.out.println(output);
      //  Character ch[] = new Character[];

        Map<String, Long> charCount = IntStream.range(0, "AAABBCCCCDDDBBB".length())
                .mapToObj(i -> "AAABBCCCCDDDBBB".substring(i, i + 1))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(charCount);

     //   Map<Character, Long> map = Arrays.stream(c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
     //   map.entrySet().stream().forEach(System.out::println);

        int arr[] = {11, 3,45,6,7,8};
        long ans = IntStream.of(arr).asLongStream().sum();
        System.out.println(ans);
    }
}
