package String;

import java.util.*;
// pwwkew
public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        int winStart = 0;
        int winEnd = 0;
        int maxlen = 0;
        Set<Character> set = new HashSet<>();
        while(winStart < s.length() && winEnd < s.length()){
            if(!set.contains(s.charAt(winEnd))){
                set.add(s.charAt(winEnd++));
                maxlen = Math.max(maxlen, winEnd - winStart);
            } else{
                set.remove(s.charAt(winStart++));
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String s = "abcabcabc";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
