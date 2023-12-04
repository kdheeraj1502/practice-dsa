import java.util.Stack;

public class ValidParanthisis {
    public static void main(String[] args) {
        String input = "(()()()()))))))((()))(()()()()()()())))))))";
        int result = longestValidParanthesis(input);
        System.out.println(result);



    }

    private static int longestValidParanthesis(String s) {

        Stack<Integer> stack = new Stack<>();
        int start = -1;
        int count = 0;
        int max_length= 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max_length = Math.max(max_length, i - start);
                    } else {
                        max_length = Math.max(max_length, i - stack.peek());
                    }
                } else {
                    start = i;
                }
            }
        }

        return max_length;

    }
}
