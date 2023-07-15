package java8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class FindLastElement {

    public static void main(String[] args) {
        String stream[] = {"Geek_First", "Geek_2", "Geek_3", "Geek_4", "Geek_Last"};
        System.out.println(Stream.of(stream).reduce((o1, o2) -> o2).orElse(null));
    }
}
