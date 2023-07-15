package java8.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringToListOfChars {

    public static void main(String[] args) {
        String str = "Geeks";
        System.out.println(Arrays.toString(str.chars().mapToObj(c -> Character.valueOf((char) c)).collect(Collectors.toList()).toArray()));

    }
}
