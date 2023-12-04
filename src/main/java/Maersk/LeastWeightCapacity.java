package Maersk;

import java.util.Arrays;

public class LeastWeightCapacity {

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int n = 3;
        int D = 2;
        int ans = leastWeightCapacity(arr, n, D);
        System.out.println(ans);
    }

    private static int leastWeightCapacity(int[] arr, int N, int D) {
        int high = Arrays.stream(arr).boxed().max(Integer::compare).get();

        int ans = -1;
        int sum = 0;
        for(int i : arr){
            sum+= i;
        }
        for(int i =high ; i<=sum; i++){
            boolean maxCapex = findCapex(arr , D, i);

            if(maxCapex){
                ans = i;
                break;
            }
        }

        return ans;
    }

    static boolean findCapex(int[] arr , int D, int high){
        int days = 1;

        int load = 0;
        for(int cap : arr){
            if( load+cap > high){
                days+=1;
                load = cap;
            } else {
                load+=cap;
            }
        }

        return days<=D;
    }
}
