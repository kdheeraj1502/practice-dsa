package dynamic;

public class NinjaDP1 {
    public static int ninjaTraining(int n, int points[][]) {
       // return ninjaTraining(n - 1, points, 3);
        return ninjaTraining_dp(points);

    }

    public static int ninjaTraining_dp(int points[][]) {
        int dp [][] = new int[points.length][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int days = 1; days < points.length; days++){
            for(int last = 0; last < 4; last++){
                int max = 0;
                for(int task = 0; task < 3; task++){
                    if(task != last){
                        max = Math.max(max, dp[days - 1][task] + points[days][task]);
                    }
                }
                dp[days][last] = max;

            }
        }
        return dp[points.length - 1][3];
    }

    public static int ninjaTraining(int days, int points[][], int last) {
        if (days == 0) {
            int max = 0;
            for (int task = 0; task < 3; task++) {
                if(task != last){
                    max = Math.max(max, points[0][task]);
                }
            }
            return max;
        }
        int maxMerit = 0;
        for (int task = 0; task < 3; task++) {
            if(task != last){
                maxMerit = Math.max(maxMerit, points[days][task] + ninjaTraining(days - 1, points, task));
            }
        }
        return maxMerit;
    }

    public static void main(String[] args) {
        int n = 3;
        int input[][] = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };
        int input1[][] = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };
        System.out.println(ninjaTraining(n, input));
    }
}
