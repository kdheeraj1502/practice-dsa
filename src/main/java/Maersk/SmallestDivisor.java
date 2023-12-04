package Maersk;

public class SmallestDivisor {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int n = 4;
        int k = 6;

        System.out.println(smallestDivisor(nums, k));;
    }

    public static int smallestDivisor(int[] nums, int K) {
        int ans = 0;

        for(int i = 1; i<= K; i++){

            ans = findSmallest(nums,i);
            if(ans<=K){
                ans = i;
                break;
            }
        }

        return ans;
    }

    public static int  findSmallest(int[] nums , int div){

        int ans = 0;
        for(int num : nums){
             ans += Math.ceil((double)(num) / (double)(div));
        }

        return ans;
    }


}
