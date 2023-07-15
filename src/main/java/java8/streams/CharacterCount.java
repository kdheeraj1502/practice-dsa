package java8.streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharacterCount {
    public static void main(String[] args) {
        String input = "aaaabbbccaaccc";
        String output = getCharacterCount(input);
        System.out.println(output);
    }

    public static String getCharacterCount(String input) {
        Map<Character, Integer> charCountMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        c -> c,
                        c -> 1,
                        Integer::sum,
                        LinkedHashMap::new
                ));

        StringBuilder sb = new StringBuilder();
        charCountMap.forEach((character, count) -> sb.append(character).append(count));

        return sb.toString();
    }
}
