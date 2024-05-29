package stackAndQueue;

import java.util.Stack;
public class EvaluatePostFix {

    public static void main(String[] args) {
        String S = "123+*8-";
        System.out.println(evaluatePostFix(S));

    }

    public static int evaluatePostFix(String S)
    {
        char[] chars = S.toCharArray();

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(char ch : chars){

            if(Character.isDigit(ch)){
                stack.push(Character.getNumericValue(ch));
            } else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                switch(ch){
                    case '+' :
                        stack.push(op1 + op2);
                        break;
                    case '-' :
                        stack.push(op1 - op2);
                        break;
                    case '*' :
                        stack.push(op1 * op2);
                        break;
                    case '/' :
                        stack.push(op1 / op2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);

                }
            }
        }

        return stack.pop();
    }
}
