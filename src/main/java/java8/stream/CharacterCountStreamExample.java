package java8.stream;

import java.util.ArrayList;
        import java.util.List;
        import java.util.Map;
        import java.util.stream.Collectors;

public class CharacterCountStreamExample {
    public static void main(String[] args) {
        String input = "AABBAA";
        List<CharacterCountPair> characterCountPairs = countCharacters(input);
        System.out.println(characterCountPairs);
    }

    public static List<CharacterCountPair> countCharacters(String input) {
        Map<Character, Long> counts = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(counts);

        List<CharacterCountPair> characterCountPairs = new ArrayList<>();
        for (Map.Entry<Character, Long> entry : counts.entrySet()) {
            Character character = entry.getKey();
            Long count = entry.getValue();
            characterCountPairs.add(new CharacterCountPair(character, count));
        }

        return characterCountPairs;
    }

    static class CharacterCountPair {
        private Character character;
        private Long count;

        public CharacterCountPair(Character character, Long count) {
            this.character = character;
            this.count = count;
        }

        @Override
        public String toString() {
            return character + " -> " + count;
        }
    }
}

