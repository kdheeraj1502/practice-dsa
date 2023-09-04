package stack;

import java.util.*;
import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        java.util.Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '(');
        map.put(']', '[');
        for(char ch : s.toCharArray()){
            if(!map.containsKey(ch)){
                stack.push(ch);
            }
           else if(!stack.isEmpty() && map.get(ch) != null && stack.peek() == map.get(ch)){
                    stack.pop();
           }
        }
        return stack.size() == 0 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
