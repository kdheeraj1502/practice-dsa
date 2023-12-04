package Maersk;

public class CountSubArrayGreaterThanK {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int N = 4 ;
        int K = 1;
        System.out.println(countSubarray(a, N, K));
    }

    private static long countSubarray(int[] arr, int n, int k) {

        int left = 0;
        int right = 0;
        long count = 0;
        int maxInSubarray = 0;

        while (right < n) {
            maxInSubarray = Math.max(maxInSubarray, arr[right]);

            if (maxInSubarray <= k) {
                // If the maximum element in the current subarray is not greater than K, we can safely move the right pointer.
                right++;
            } else {
                // If the maximum element is greater than K, we count subarrays and increment the left pointer.
                count += (n - right);
                left++;
                right = left;
                maxInSubarray = 0;
            }
        }

        return count;
    }
}
