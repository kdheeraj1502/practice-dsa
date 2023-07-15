package recursion;

import java.util.*;

public class GenerateBlackets {

    public static void generateBrackets(int left, int right, String s, List<String> result){
        if(left == 0 && right == 0){
            result.add(s);
        }
        if(left > right || left < 0 || right < 0){
            return;
        }
        s += '(';
        generateBrackets(left - 1, right, s, result);
        s = s.substring(0, s.length() - 1);
        s += ')';
        generateBrackets(left, right - 1, s, result);
        s = s.substring(0, s.length() - 1);

    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        generateBrackets(3, 3, "", list);
        System.out.println(list);
    }
}
