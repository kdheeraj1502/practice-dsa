package dynamic;

import java.util.ArrayList;

public class UniquePath2 {
    static int mod = 1000000007;
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int dp[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat.get(i).get(j) == -1) dp[i][j] = 0;
                else if(i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if(i > 0) up = dp[i - 1][j];
                    if(j > 0) left = dp[i][j - 1];
                    dp[i][j] = (up + left) % mod;
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

        ArrayList<Integer> matrix1 = new ArrayList<>();
        matrix1.add(0);
        matrix1.add(0);
        matrix1.add(0);
        matrix1.add(0);
        matrix1.add(0);
        matrix1.add(0);
        matrix1.add(0);
        matrix1.add(0);
        matrix1.add(0);

        ArrayList<Integer> matrix2 = new ArrayList<>();
        matrix2.add(0);
        matrix2.add(-1);
        matrix2.add(0);
        matrix2.add(0);
        matrix2.add(-1);
        matrix2.add(0);
        matrix2.add(0);
        matrix2.add(-1);
        matrix2.add(0);

        ArrayList<Integer> matrix3 = new ArrayList<>();
        matrix3.add(0);
        matrix3.add(0);
        matrix3.add(0);
        matrix3.add(0);
        matrix3.add(0);
        matrix3.add(0);
        matrix3.add(0);
        matrix3.add(0);
        matrix3.add(0);

        ArrayList<Integer> matrix4 = new ArrayList<>();
        matrix4.add(0);
        matrix4.add(0);
        matrix4.add(0);
        matrix4.add(0);
        matrix4.add(0);
        matrix4.add(0);
        matrix4.add(0);
        matrix4.add(0);
        matrix4.add(0);

        ArrayList<Integer> matrix5 = new ArrayList<>();
        matrix5.add(0);
        matrix5.add(0);
        matrix5.add(0);
        matrix5.add(0);
        matrix5.add(0);
        matrix5.add(0);
        matrix5.add(0);
        matrix5.add(0);
        matrix5.add(0);

        mat.add(matrix1);
        mat.add(matrix2);
        mat.add(matrix3);
        mat.add(matrix4);
        mat.add(matrix5);

        System.out.println(mazeObstacles(5, 9, mat));

    }
}
