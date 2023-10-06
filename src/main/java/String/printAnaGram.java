package String;

import java.util.*;

public class printAnaGram {
    public static List<List<String>> Anagrams(String[] string_list) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : string_list) {
            char tempArray[] = str.toCharArray();
            Arrays.sort(tempArray);
            String input = new String(tempArray);
            if(map.containsKey(input)){
                List<String> list = map.get(input);
                list.add(str);
                map.put(input , list);
            } else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(input , list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        Set<Map.Entry<String, List<String>>> set =  map.entrySet();
        for(Map.Entry<String, List<String>> s : set){
            result.add(s.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        String str[] = { "act", "god", "cat", "dog", "tac" };
        System.out.println(Anagrams(str));
    }
}
