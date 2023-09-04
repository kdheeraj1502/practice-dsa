package dynamic;

public class CalculateMinCost {

    public static int findMinCost(int cost[][]){
        int dp [] = new int[cost.length];
        dp[0] = 0;
        dp[1] = cost[0][1];
        for(int i = 2; i < cost.length; i++){
            dp[i] = cost[0][i];
            for(int j = 1; j < i; j++){
                dp[i] = Math.min(dp[i], dp[j] + cost[i][j]);
            }
        }
        return dp[cost.length - 1];
    }

    public static void main(String[] args) {
        int cost[][] = {
                { 0, 10, 75, 95 },
                { -1, 0, 35, 50 },
                { -1, -1, 0, 80 },
                { -1, -1, -1, 0 }
        };
        System.out.println(findMinCost(cost));
    }
}
