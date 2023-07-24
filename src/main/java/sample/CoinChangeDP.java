package sample;

public class CoinChangeDP {
    public long count(int coins[], int N, int sum) {
        long dp[][] = new long[N + 1][sum + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                long notPick = dp[i - 1][j];
                long pick = 0;
                if(j >= (coins[i - 1])){
                    pick = dp[i][j - coins[i - 1]];
                }
                dp[i][j] = pick + notPick;
            }
        }
        return dp[N][sum];
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 3 };
       // System.out.println(space(coins, coins.length, 4));
    }

}
