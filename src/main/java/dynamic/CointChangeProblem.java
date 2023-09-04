package dynamic;

public class CointChangeProblem {
    public static long count(int coins[], int N, int sum) {
        int dp[][] = new int[coins.length + 1][sum + 1];
        for(int i = 0; i < dp[0].length; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i < dp.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < N + 1; i++){
            for(int j = 1; i < sum + 1; j++){
                if(coins[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][sum];
    }

    public static void main(String[] args) {
        int sum = 4;
        int N = 3;
       int coins[] = {1,2,3};
        System.out.println(count(coins, N, sum));
    }
}
