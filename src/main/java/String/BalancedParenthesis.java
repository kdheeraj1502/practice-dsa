package String;

import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        String input = "(()()()()))))))((()))(()()()()()()()())))))";
        int result = longestValidParanthesis(input);
        System.out.println(result);
        String s1 = ")()())";
      //  Output: 4
        String s2 = "";
        //Output: 0
        String s3 = "(   ()()()()   ))))))   ((()))    (  ()()()()()()()()   )))))";
        //   Output: 16

    }

    private static int longestValidParanthesis(String input) {

        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int maxLen = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stk.push(i);
            } else {
                stk.pop();
                if (stk.isEmpty()) {
                    stk.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stk.peek());
                }
            }
        }

        return maxLen;

    }
}