package dynamic;

public class Robbery {
    public static int rob(int[] nums) {
        int dp[] = new int[nums.length + 1];
        dp[0] = nums[0];
        int neg = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++){
            int next = nums[i] + (i > 1 ? dp[i - 2] : neg);
            int nextToNext = dp[i - 1];
            dp[i] = Math.max(next, nextToNext);
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = { 1,2,3,1 };
        System.out.println(rob(nums));
    }
}
