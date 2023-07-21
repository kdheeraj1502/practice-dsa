package java8.stream;


import java.util.stream.IntStream;

public class IterateOverStreamWithIndicesInJava8 {
    public static void main(String[] args) {
        String str = "GeeksForGeeks";
        IntStream.range(0, str.toCharArray().length).mapToObj(i -> String.format("%d :: %s", i, str.toCharArray()[i]))
                .forEach(System.out::println);

    }
}
