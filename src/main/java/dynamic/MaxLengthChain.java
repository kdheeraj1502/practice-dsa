package dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChain {

    static class Pair
    {
        int x;
        int y;

        public Pair(int a, int b)
        {
            x = a;
            y = b;
        }
    }
   static int maxChainLength(Pair arr[], int n)
    {
        Arrays.sort(arr, Comparator.comparingInt(p -> p.y));
        int i = 1;
        int j = 0;
        int count = 1;
        while(i < arr.length){
            if(arr[j].y < arr[i].x){
                count++;
                j = i;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        Pair arr[] = { new Pair(5, 24), new Pair(39, 60),
                new Pair(15, 28), new Pair(27, 40), new Pair(50, 90)};
        System.out.println(maxChainLength(arr, 5));
    }
}


