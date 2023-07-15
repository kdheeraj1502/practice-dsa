public class KnapsackSpaceOptimisation {
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int prev[] = new int[W + 1];
        for(int i = 1; i <= n; i++){
            int curr[] = new int[W + 1];
            for(int j = 1; j <= W; j++){
                int take = Integer.MIN_VALUE;
                int notTake = prev[j];
                if(j >= wt[i - 1]){
                    take = val[i - 1] + prev[j - wt[i - 1]];
                }
                curr[j] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[W];
    }
}
