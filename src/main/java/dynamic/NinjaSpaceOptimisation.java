package dynamic;

public class NinjaSpaceOptimisation {
    public static int ninjaTraining_dp(int points[][]) {
        int prev [] = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
// 5 5 2 5
        for(int days = 1; days < points.length; days++){
            int temp [] = new int[4];
            for(int last = 0; last < 4; last++){
                int max = 0;
                for(int task = 0; task < 3; task++){
                    if(task != last){
                        max = Math.max(max, prev[task] + points[days][task]);
                    }
                }
                temp[last] = max;
            }
            prev = temp;
        }
        return prev[3];
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
        System.out.println(ninjaTraining_dp(input));
    }
}
