package String;

public class MakePalindrome {

    public static void main(String[] args) {
        String str = "abcd";

        int ans = makePalindorme(str);
        System.out.println(ans);
    }

    private static int makePalindorme(String str) {
        int n = str.length();

        int[][] dp = new int[n][n];

        for(int i = 0; i< n; i++){
            dp[i][i]=0;
        }

        for(int c = 2 ; c<=n; c++){
            for(int i = 0; i<n-c+1; i++){
                int j = i+c-1;

                if(str.charAt(i) == str.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i+1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }

}
