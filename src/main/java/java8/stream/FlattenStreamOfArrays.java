package java8.stream;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlattenStreamOfArrays {

    public static void main(String[] args) {
        int arr[][] = {{ 1, 2 }, { 3, 4, 5, 6 }, { 7, 8, 9 }};

        List<Character> a = Arrays.asList('G', 'e', 'e', 'k', 's');
        List<Character> b = Arrays.asList('F', 'o', 'r');
        List<Character> c = Arrays.asList('G', 'e', 'e', 'k', 's');

        List<List<Character> > list = new ArrayList<List<Character> >();
        list.add(a);
        list.add(b);
        list.add(c);

        System.out.println(list.stream().flatMap(Collection::stream).collect(Collectors.toList()));

        System.out.println(Arrays.toString(Arrays.stream(arr).flatMapToInt(IntStream::of).toArray()));
    }
}
