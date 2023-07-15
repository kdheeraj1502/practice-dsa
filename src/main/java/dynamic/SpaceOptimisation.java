package dynamic;

public class SpaceOptimisation {
    public static int uniquePaths(int m, int n) {
        int prev[] = new int[n];
        for(int i = 0; i < m; i++){
            int temp[] = new int[n];
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    temp[j] = 1;
                } else{
                    int up = 0, left = 0;
                    if(i > 0) up = prev[j];
                    if(j > 0) left = temp[j - 1];
                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        return prev[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(4, 4));
    }
}
