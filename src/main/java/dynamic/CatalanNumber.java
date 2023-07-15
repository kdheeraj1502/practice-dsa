package dynamic;

import java.util.Arrays;

public class CatalanNumber {
    public static int prefixStrings(int N)
    {
        long dp[]=new long[N+1];
        dp[0]=1;
        dp[1]=1;
        for(int i = 2; i <= N; i++){
            int low = 0, high = i - 1;
            while(low <= i - 1){
                dp[i] = (dp[i] + (dp[low] * dp[high])) % 1000000007;
                low++;
                high--;
            }
        }
       // System.out.println(Arrays.toString(dp));
        return (int)dp[N]%1000000007;
    }

    public static void main(String[] args) {
        prefixStrings(5);
    }
}
