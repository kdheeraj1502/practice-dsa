package dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {

    public static void main(String[] args) {
        // { -7,-1} ,{ 0, 10} ,{2,3 } ,{ 3, 6 }, { 3, 10 } , { 4, 5 },{ 7, 9 } ,{ 7, 9}
        // { -7,-1} => { 0, 10}
        // { 0, 10} ==>
        // {2,3 } ==> { 4, 5 }, { 7, 9 }
        // { 3, 6 } ==> { 4, 5 } , { 7, 9 }
        // { 3, 10 }
        // { 4, 5 } ==> { 7, 9 }
        // { 7, 9 }
        int[][] pairs = { { 7,9} ,{ 4,5} ,{ 7,9 } ,{ -7,-1 }, { 0,10 } , { 3, 10 },{ 3, 6 } ,{ 2,3 } };
        System.out.println(findLongestChain(pairs));
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int i = 0;
        int j = 1;
        int count = 1;
        while(j < pairs.length){
            if(pairs[i][1] < pairs[j][0]){
                i = j;
                j++;
                count++;
            } else{
                j++;
            }
        }
        return count;
    }
}

