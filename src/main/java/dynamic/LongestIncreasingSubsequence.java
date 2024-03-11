package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int longestIncreasingSubsequence(int[] arr, int n) {
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);

        int len = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size() - 1)) {
                temp.add(arr[i]);
                len++;
            } else {
                // Replacement step
                int ind = lowerBound(temp, arr[i]);
                temp.set(ind, arr[i]);
            }
        }

        return len;
    }

    private static int lowerBound(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result != -1 ? result : list.size();
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 7, 11, 8, 10, 13, 6};
        int n = arr.length;

   //     int result = longestIncreasingSubsequence(arr, n);
        int result = longestSubsequence(n, arr);
        System.out.println("Length of longest increasin g subsequence: " + result);
    }

    static int longestSubsequence(int size, int a[])
    {
        int[] dp=new int[a.length];
        int len=0;
        for(int x:a){
            int i = Arrays.binarySearch(dp,0,len,x);
            if(i<0)
                i=-(i+1);
            dp[i]=x;
            if(i==len) len++;
        }
        return len;
    }
}

