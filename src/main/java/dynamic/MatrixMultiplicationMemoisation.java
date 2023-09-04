package dynamic;

public class MatrixMultiplicationMemoisation {

    static int matrixMultiplication(int N, int arr[]) {
        int dp[][] = new int[N][N];
        return matrixMultiplication(1, N - 1, arr, dp);
    }

    static int matrixMultiplication(int i, int j, int arr[], int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int steps = (arr[i - 1] * arr[k] * arr[j]) +
                    matrixMultiplication(i, k, arr, dp) +
                    matrixMultiplication(k + 1, j, arr, dp);

            mini = Math.min(steps, mini);
        }
        return dp[i][j] = mini;
    }

    public static void main(String[] args) {
        int N = 5;
        int arr[] = { 40, 20, 30, 10, 30 };

        System.out.println(matrixMultiplication(N, arr));
    }
}
