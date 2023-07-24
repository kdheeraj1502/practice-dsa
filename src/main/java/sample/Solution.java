package sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    static Map<Character, Character> blacketsMap = new HashMap<>();

    static {
        blacketsMap.put(')', '(');
        blacketsMap.put('}', '{');
    }
    public static int longestLength(String input){
        Stack<Character> charPairs = new Stack<>();
        // { } ( ) { } }
        for(char ch : input.toCharArray()){
            if(!charPairs.isEmpty() && charPairs.peek() == blacketsMap.get(ch)){
                charPairs.pop();
            }else{
                charPairs.push(ch);
            }
        }
        return input.length() - charPairs.size();
    }

    public static void main(String[] args) {
        String input = "{}(){}}";
        System.out.println(longestLength(input));
    }
}
