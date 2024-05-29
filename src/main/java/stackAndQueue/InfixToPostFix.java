package stackAndQueue;

import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        String ans = infixToPostfix(str);
        System.out.println(ans);
    }
    public static String infixToPostfix(String exp) {

        StringBuilder ans = new StringBuilder(new String(""));
        char[] ch = exp.toCharArray();

        Stack<Character> stk = new Stack<>();

        for(char c : ch){
            if(Character.isLetterOrDigit(c)){
                ans.append(c);
            } else if(c == '('){
                stk.push(c);
            } else if(c == ')'){
                while(!stk.isEmpty() && stk.peek()!= '('){
                    ans.append(stk.pop());

                }
                stk.pop();
            } else {
                while(!stk.isEmpty() && Prec(c)<=Prec(stk.peek())){
                    ans.append(stk.pop());
                }
                stk.push(c);
            }
        }
        while (!stk.isEmpty()) {
            if (stk.peek() == '(')
                return "Invalid Expression";
            ans.append(stk.pop());
        }

        return ans.toString();
        // Your code here
    }

    public static int Prec(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;

    }
}
