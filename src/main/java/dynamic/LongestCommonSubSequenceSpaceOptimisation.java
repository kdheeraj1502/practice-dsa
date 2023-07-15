package dynamic;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubSequenceSpaceOptimisation {
    public static int LCS(String x, String y, int m, int n){
        int size = Math.max(m, n);
        int prev[] = new int[size + 1];
        List<Character> result = new ArrayList<>();

        prev[0] = 0;
        for(int i = 1; i < m + 1; i++){
            int curr[] = new int[size + 1];
            for(int j = 1; j < n + 1; j++){
                if(x.charAt(i - 1) == y.charAt(j - 1)){
                    result.add(x.charAt(i - 1));
                    curr[j] = 1 + prev[j - 1];
                } else{
                    curr[j] = Math.max(curr[j - 1], prev[j]);
                }
            }
            prev = curr;
        }
        System.out.println(result);
        return prev[n];
    }

    public static void main(String[] args) {
        String x = "ABCBDAB";
        String y = "BDCABA";

        System.out.println(LCS(x, y, x.length(), y.length()));
    }
}
