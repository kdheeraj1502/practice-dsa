package recursion;

import java.util.*;

public class BalancedParenthesis {

    static void generateParenthesis(int left, int right, String s, List<String> answer) {
        if (left == 0 && right == 0) {
            answer.add(s);
        }
        if (left > right || left < 0 || right < 0) {
            return;
        }
        s += "(";
        generateParenthesis(left - 1, right, s, answer);
        s = s.substring(0, s.length() - 1);
        s += ")";
        generateParenthesis(left, right - 1, s, answer);
        s = s.substring(0, s.length() - 1);
    }

    public static void main(String[] args) {
        int size = 3;
        List<String> ans = new ArrayList<>();
        String s = "";
        generateParenthesis(size, size, s, ans);
        for (String k : ans) {
            System.out.println(k);
        }
    }
}

//     (((       )))