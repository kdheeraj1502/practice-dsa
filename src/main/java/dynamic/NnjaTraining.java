package dynamic;

public class NnjaTraining {
    public static int ninjaTraining(int n, int points[][]) {

        int dp[][] = new int[n][4];
        return ninjaTraining(points, 3, n - 1, dp);
    }

    public static int ninjaTraining(int points[][], int last, int index, int dp[][]) {
        if(dp[index][last] != 0) return dp[index][last];
        if(index == 0){
            int max = 0;
            for(int task = 0; task < 3; task++){
                if(task != last && points[0][task] > max){
                    max = points[0][task];
                }
            }
            return dp[index][last] = max;
        }

        int max = 0;
        for(int task = 0; task < 3; task++){
            if(task != last){
                max = Math.max(max, (points[index][task] +
                        ninjaTraining(points, task, index - 1, dp)));
            }
        }
        return dp[index][last] = max;
    }

}
