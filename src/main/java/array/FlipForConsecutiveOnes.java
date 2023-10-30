package array;

import sun.applet.Main;

public class FlipForConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        int n = 11 ;
        int k =2;
        int ans = longestOnes(n, arr , k);
        System.out.println(ans);
    }

    private static int longestOnes(int n, int[] nums, int k) {

        int left = 0;    // Left pointer of the window.
        int maxOnes = 0; // Maximum consecutive ones.
        int zeroCount = 0; // Count of zeros in the current window.

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxOnes = Math.max(maxOnes, right - left + 1);
        }
        return maxOnes;
    }
}
