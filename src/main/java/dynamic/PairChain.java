package dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class PairChain {
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int i = 1;
        int j = 0;
        int count = 1;
        while(i < pairs.length){
            if(pairs[j][1] < pairs[i][0]){
                count++;
                j = i;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int pairs[][] = {{1, 2},{3, 4},{5, 6}};
        System.out.println(findLongestChain(pairs));
    }
}
