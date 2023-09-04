package array;

import java.util.Arrays;

public class LongestSubArrayWithSum {
    public static int[] longestSubarrayWithSum(int[] array, int targetSum) {
        int max = 0;
        int result[] = {};
        for(int i = 0; i < array.length; i++){
            int sum = 0;
            int len = 0;
            int k = i;
            for(int j = k; j < array.length; j++){
                if(sum < targetSum || targetSum == 0){
                    sum += array[j];
                }
                if(sum > targetSum){
                    break;
                }
                if(sum == targetSum){
                    len = j - k + 1;
                    if(max < len){
                        result = new int[]{k, j};
                    }
                    max = Math.max(max, len);
                    if(j < array.length - 1 && array[j + 1] != 0){
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
       // int input[] = { 1, 2, 3, 4, 3, 3, 1, 2, 1 };
       int input[] = { 5 };
        System.out.println(Arrays.toString(longestSubarrayWithSum1(input, 0)));
    }

    public static int[] longestSubarrayWithSum1(int[] array, int targetSum) {
        int first = 0;
        int sum = 0;
        int max = 0;
        int result[] = {};
        for(int i = 0; i < array.length; i++){
            int len = 0;
            sum += array[i];
            if(sum < targetSum){
                continue;
            }
            if(sum > targetSum){
                sum -= array[first];
                first++;
            }
            if(sum == targetSum){
                len = Math.max(len, i - first + 1);
                if(max < len){
                    max = len;
                    result = new int[]{first, i};
                }
            }
        }
        return result;
    }
}
