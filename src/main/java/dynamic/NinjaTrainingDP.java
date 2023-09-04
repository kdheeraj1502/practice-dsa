package dynamic;

public class NinjaTrainingDP {
    public static int ninjaTraining(int n, int points[][]) {
        int dp[][] = new int[n][4];
        int max = 0;
        for(int i = 0; i < 3; i++){
            max = Math.max(points[0][i], max);
        }
        dp[0][0] = max;

        for(int i = 1; i < n; i++){
            max = 0;
            for(int j = 0; j < 3; j++){
                dp[i][j] = Math.max(points[i][j] + dp[i - 1][j], max);
            }
        }
        int result = 0;
        for(int i = 0; i < 3; i++){
            result = Math.max(result, dp[n - 1][i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int point[][] = {
                { 10, 40, 70 },
                { 20, 50, 80 },
                { 30, 60, 90 }
        };
        System.out.println(ninjaTraining(3, point));
    }
}
