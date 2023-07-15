package java8;

import java.util.Arrays;

public class Triplet {

    public static void main(String[] args) {
        int[] arr = {1,2,4,3,6};
        System.out.println(triplet(arr, arr.length,10));
    }

    private static boolean triplet(int[] arr, int n, int X) {

        Arrays.sort(arr);
        int sum = 0;
        if(n < 3) {
            return false;
        }
        if(n==3){
            sum = arr[0] + arr[1] + arr[2];
            return sum == X;
        }
        int first;
        int last;


        for(int i = 0; i<n-2; i++){
            first = i+1;
            last = n-1;
            while(first<last){
                sum = arr[i] + arr[first] + arr[last];
                if(sum == X){
                    return true;
                } else if (sum>X){
                    last--;
                } else {
                    first++;
                }


            }
        }
        return false;
    }
}
