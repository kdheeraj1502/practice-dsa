package dynamic;

public class MatrixMultiplicationDP {

    static int matrixMultiplication1(int N, int arr[]) {
        int dp[][] = new int[N][N];
        for (int i = N - 1; i >= 1; i--) {
            for (int j = i + 1; j < N; j++) {
                int mini = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    mini = Math.min(mini, steps);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][N - 1];
    }

    public static void main(String[] args) {
        int N = 4;
        int[] arr = {10, 30, 5, 60};
        System.out.println(matrixMultiplication(N, arr));
    }

    static int matrixMultiplication(int N, int arr[])
    {
        int dp[][] = new int[N][N];
        for(int i = N - 1; i >= 1; i--){
            for(int j = i + 1; j < N; j++){
                int min = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    min = Math.min(steps, min);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][N - 1];
    }
}
