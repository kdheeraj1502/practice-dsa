package String;

import java.util.*;

public class IsIsomorphoicStrings {
    public static boolean areIsomorphic(String str1,String str2)
    {
        if(str1.length() != str2.length())
            return false;
        int n = str1.length();
        Map<Character,Character> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if(map.isEmpty()  || (!map.containsKey(c1) && !map.containsValue(c2))) {
                map.put(c1,c2);
            }
            else {
                if(map.containsKey(c1) && map.get(c1) != c2)
                    return false;
                if(!map.containsKey(c1) && map.containsValue(c2))
                    return false;
            }
        }
        return true;
    }
}
