package dynamic;

public class UniquePathIn2D {
    public static int uniquePaths(int m, int n) {
        return uniquePaths(0, 0, m, n);
    }

    public static int uniquePaths(int row, int col, int m, int n) {
        if(row < 0 || row >= m || col < 0 || col >= n) return 0;
        if(row == m - 1 && col == n - 1) return 1;
        int count = 0;
        count += uniquePaths(row + 1, col, m, n);
        count += uniquePaths(row, col + 1, m, n);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 2));
    }
}
