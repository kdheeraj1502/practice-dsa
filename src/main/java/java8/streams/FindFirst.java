package java8.streams;

import java.util.Optional;
import java.util.stream.Stream;

public class FindFirst {
    public static void main(String[] args) {
        String [] input = { "Geek_First", "Geek_2", "Geek_3", "Geek_4", "Geek_Last" };
       // Optional<String> result = Stream.of(input).findFirst();
        String a = null;
        Optional<String> result = Optional.empty();
        if(result.isPresent()){
            System.out.println(result.get());
        }
    }
}
