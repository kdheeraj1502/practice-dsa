package array;

import java.util.*;

public class CommonCharacter1 {
    public static String[] commonCharacters(String[] strings) {
        String smallestString = getSmallestString(strings);
        Set<Character> potentialCharacters = new HashSet<>();
        for(char ch : smallestString.toCharArray()){
            potentialCharacters.add(ch);
        }

        for(String str : strings){
            removeNonExisting(str, potentialCharacters);
        }
        String result[] = new String[potentialCharacters.size()];
        int index = 0;
        for(Character ch : potentialCharacters){
            result[index] = Character.toString(ch);
        }
        return result;
    }

    public static String getSmallestString(String[] strings){
        String result = strings[0];
        for(String str : strings){
            if(str.length() < result.length()){
                result = str;
            }
        }
        return result;
    }

    public static Set<Character> removeNonExisting(String str, Set<Character> potentialCharacters){
        Iterator<Character> it = potentialCharacters.iterator();
        while(it.hasNext()){
            char ch = it.next();
            if(!str.contains("" + ch)){
                // potentialCharacters.remove(ch);
                it.remove();
            }
        }
        return potentialCharacters;
    }

    public static void main(String[] args) {
        String strings[] = { "abc", "bcd", "cbad" };
        System.out.println(Arrays.toString(commonCharacters(strings)));
        System.out.println(strings[0].contains("a"));
        System.out.println(strings[0].contains("d"));
    }
}
