public class KnapsackDP {
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int dp[][] = new int[n + 1][W + 1];
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                int take = Integer.MIN_VALUE;
                int notTake = dp[i - 1][j];
                if(j >= wt[i - 1]){
                    take = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                }
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n][W];
    }
}
