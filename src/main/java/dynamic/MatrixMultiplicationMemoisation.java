package dynamic;

public class MatrixMultiplicationMemoisation {

    static int matrixMultiplication(int N, int arr[]) {
        int dp[][] = new int[N + 1][N + 1];
         matrixMultiplication(1, N - 1, arr, dp);
        return dp[1][N - 1];
    }

    static int matrixMultiplication(int i, int j, int arr[], int[][] dp) {
        if (i == j) return dp[i][j] = 0;
        if (dp[i][j] != 0) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = (arr[i - 1] * arr[k] * arr[j]) +
                    matrixMultiplication(i, k, arr, dp) +
                    matrixMultiplication(k + 1, j, arr, dp);

            mini = Math.min(steps, mini);
            dp[i][j] = mini;
        }
        return dp[i][j] = mini;
    }

    public static void main(String[] args) {
        int N = 4;
        int arr[] = { 10, 30, 5, 60 };

        System.out.println(matrixMultiplication(N, arr));
    }
}
