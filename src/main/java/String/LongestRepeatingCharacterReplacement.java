package String;

import java.util.*;

public class LongestRepeatingCharacterReplacement {
// ABAB
    public static int characterReplacement(String s, int k) {
        int winStart = 0, maxRepeatCharCount = 0, maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int winEnd = 0; winEnd < s.length(); winEnd++){
            char ch = s.charAt(winEnd);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxRepeatCharCount = Math.max(maxRepeatCharCount, map.get(ch));
            if(winEnd - winStart + 1 - maxRepeatCharCount  > k){
                char charFirst = s.charAt(winStart++);
                map.put(charFirst, map.get(charFirst) - 1);
            } else{
                maxLength = Math.max(maxLength, winEnd - winStart + 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str =  "ABAB";
        int k = 2;
        System.out.println(characterReplacement(str, k));
    }
}
