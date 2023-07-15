package java8.stream;

import jdk.nashorn.internal.objects.annotations.Function;
import sun.security.pkcs11.wrapper.Functions;

import java.util.*;
import java.util.stream.Collectors;

public class CountOfChars {
    public static void main(String[] args) {
        String word = "AAABBCCA";
        Map<Object, Integer> charCount = word.chars().boxed()
                .collect(Collectors.toMap(k -> k, i -> 1, Integer::sum, LinkedHashMap::new));

        System.out.println(charCount);
    }
}
