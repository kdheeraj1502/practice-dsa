package stackAndQueue;

import java.util.Stack;

public class BalancePranthesis {

    public static void main(String[] args) {
        String x = "{}{(}))}";
        boolean ans = ispar(x);
        System.out.println(ans);
    }

    private static boolean ispar(String x) {
        char[] ch1 = x.toCharArray();
        java.util.Stack<Character> stk = new Stack<>();

        for(char ch : ch1){

            if(ch=='(' || ch=='{' || ch=='['){
                stk.push(ch);
            } else if(ch==')'  || ch=='}' || ch==']'){
                if(stk.isEmpty()){
                    return false;
                } else if( (stk.peek()=='(' && ch==')')||
                        (stk.peek()=='{' && ch=='}') || (stk.peek()=='[' && ch==']')){
                    stk.pop();
                } else {
                    stk.push(ch);
                }
            }
        }

        return stk.isEmpty();
    }
}
