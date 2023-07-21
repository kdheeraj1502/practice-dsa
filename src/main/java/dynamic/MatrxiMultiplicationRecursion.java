package dynamic;

public class MatrxiMultiplicationRecursion {
    static int matrixMultiplication(int N, int arr[])
    {
        return rec(arr, 1, N - 1);
    }

    static int rec(int arr[], int i, int j)
    {
        if(i == j) return 0;
        int ans = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int steps = (arr[i - 1] * arr[k] * arr[j]) + rec(arr, i, k) + rec (arr, k + 1, j);
            ans = Math.min(ans, steps);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {10, 30, 5, 60};
        System.out.println(matrixMultiplication(4, arr));
    }
}
