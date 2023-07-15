package dynamic;

public class KnapSack {
    static int knapSack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= W && (j - wt[i - 1]) >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] +
                            dp[i - 1][j - wt[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];

    }

    public static void main(String[] args) {
        int N = 3;
        int W = 4;
        int values[] = {1, 2, 3};
        int weight[] = {4, 5, 1};
        System.out.println(knapSack(W, weight, values, N));
    }
}
