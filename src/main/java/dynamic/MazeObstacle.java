package dynamic;

import java.util.*;

public class MazeObstacle {

    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        return mazeObstacles(n - 1, m - 1, m, n, mat);
    }

    static int mazeObstacles(int row, int col, int m, int n,
                             ArrayList<ArrayList<Integer>> mat) {
        if(row < 0 || col < 0 || mat.get(row).get(col) == -1) return 0;
        if(row == 0 && col == 0) return 1;
        int up = mazeObstacles(row - 1, col, m, n, mat);
        int left = mazeObstacles(row, col - 1, m, n, mat);
        return up + left;
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
