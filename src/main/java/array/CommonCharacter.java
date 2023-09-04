package array;

import java.util.Arrays;
import java.util.*;

public class CommonCharacter {
    public static String[] commonCharacters(String[] strings) {
        Map<Character, Integer> characterCounts = new HashMap<>();
        for(int i = 0; i < strings.length; i++){
            Set<Character> uniqueCharcters = new HashSet<>();
            for(char ch : strings[i].toCharArray()){
                uniqueCharcters.add(ch);
            }
            for(Character ch : uniqueCharcters){
                characterCounts.put(ch, characterCounts.getOrDefault(ch, 0) + 1);
            }
        }
        List<Character> resultList = new ArrayList<>();
        for(Map.Entry<Character, Integer> counts : characterCounts.entrySet()){
            Character ch = counts.getKey();
            Integer count = counts.getValue();
            if(count == strings.length){
                resultList.add(ch);
            }
        }
        String output[] = new String[resultList.size()];
        int index = 0;
        for(Character ch : resultList){
            output[index++] = Character.toString(ch);
        }
        return output;
    }

    public static void main(String[] args) {
        String strings[] = { "abc", "bcd", "cbad" };
        System.out.println(Arrays.toString(commonCharacters(strings)));

        System.out.println(strings[0].contains("" + 'b'));
    }
}
