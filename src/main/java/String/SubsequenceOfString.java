package String;

import java.util.*;
class SubsequenceOfString{
    static void solve(int i, String s, String f, List<String> result) {
        if (i == s.length()) {
            result.add(f);
            return;
        }
        //picking
        //f = f + s.charAt(i);
        solve(i + 1, s,  f+s.charAt(i), result);
        //poping out while backtracking
        //f.pop_back();
        solve(i + 1, s,  f, result);
    }
    public static void main(String args[]) {
        String s = "abc";
        String f = "";
        System.out.println("All possible subsequences are: ");
        List<String> result = new ArrayList<>();
        solve(0, s, f, result);
        System.out.println(result);
    }
}