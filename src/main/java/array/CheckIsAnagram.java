package array;

import java.util.*;

public class CheckIsAnagram {
    public static  boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch : t.toCharArray()){
            if(map.containsKey(ch))
                map.put(ch, map.get(ch) - 1);
            else{
                return false;
            }
        }
        Collection<Integer> list = map.values();
        for(int in : list){
            if(in > 0) return false;
        }
        return true;
    }

    public static void main(String  [] args) {
        String s = "a", t = "ab";
        System.out.println(isAnagram(s, t));
    }
}
