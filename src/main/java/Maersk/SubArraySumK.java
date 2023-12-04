package Maersk;

import java.util.HashMap;

public class SubArraySumK {

    public static void main(String[] args) {
        int[] A = {10 , 2, -2, -20, 10};
        int N = 5 ;
        int k = -10;
       int ans =  findSubArraySum(A , N, k);
        System.out.println(ans);
    }

    private static int findSubArraySum(int[] Arr, int N, int k) {

        HashMap<Integer , Integer> map = new HashMap();

        int count = 0;

        int sum = 0;
        map.put(0, 1);

        for(int i = 0; i<N; i++){

            sum = sum + Arr[i];

            int rem = sum -k;

            count = count + map.getOrDefault(rem , 0);

            map.put(sum , map.getOrDefault(sum , 0)+1);

        }

        return count;
    }
}
