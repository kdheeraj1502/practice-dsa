package Maersk;

import java.util.Arrays;

public class LongestCOnsecutiveSequence {

    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 1, 4};
        
        int N = 5;

        System.out.println(findLongestConseqSubseq(arr , N));
    }

    private static int findLongestConseqSubseq(int[] arr, int N) {

        int max = Arrays.stream(arr).max().orElse(0);

        int count = 0;
        int maxAns = 1;
        int[] tempArr = new int[max+1];

        for(int i =0; i< N; i++){
            tempArr[arr[i]] = tempArr[arr[i]] + 1;
        }

        for (int j : tempArr) {
            if (j >= 1) {
                count++;
                maxAns = Math.max(maxAns, count);
            } else {
                count = 0;
            }
        }

        return maxAns;
    }
}
