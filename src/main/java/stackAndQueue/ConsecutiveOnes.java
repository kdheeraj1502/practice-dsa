package stackAndQueue;

public class ConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        int ans = consecutiveOnes(nums, k);
    }

    private static int consecutiveOnes(int[] nums, int k) {

        int left = 0;
        int max = 0;
        int zeroCount = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
