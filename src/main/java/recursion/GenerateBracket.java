package recursion;

import java.util.*;

public class GenerateBracket {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int vals[] = new int[2];
        append(result, "", 0, 0, n, vals);
        return result;
    }
// ((()
/// (( l = 2 r = 0
    private static void append(List<String> result, String str, int left, int right, int n, int vals[]) {
        if(str.length() == 2 * n) {
            vals[0] = left;
            vals[1] = right;
            result.add(str);
            return;
        }
        vals[0] = left;
        if(left < n) {
       //     str = str + '(';
            append(result, str , left + 1, right, n, vals);
        }
        vals[1] = right;
        if(right < left) {
        //    str = str + ')';
            append(result, str, left, right + 1, n, vals);
        }
        vals[0] = left;
        vals[1] = right;
        return;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
