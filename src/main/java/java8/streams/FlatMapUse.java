package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapUse {

    public static void main(String[] args) {

        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        Object []  result = Stream.of(array).flatMap(Stream::of).toArray();
        System.out.println(Arrays.toString(result));
        List<Object> output = Stream.concat(Stream.of(array), Stream.of(result)).collect(Collectors.toList());
        System.out.println(output);
    }
}
