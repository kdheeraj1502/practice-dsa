package Maersk;

import java.util.Arrays;

public class KthMissingElement {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7};
                int k = 2;
        int n = 5;
        System.out.println(KthMissingElement(arr , n , k));
    }

    public static int KthMissingElement(int a[], int n, int k)
    {

        int min = Arrays.stream(a).boxed().min(Integer::compare).get();
        int max = Arrays.stream(a).boxed().max(Integer::compare).get();

        int[] count = new int[max+1];

        for(int i = 0; i<n ; i++){
            count[a[i]] = 1;
        }
        int ans = -1;
        int c = 0;
        for(int i = min ; i<max ; i++){

            if(count[i]!=1){
                c=c+1;
            }
            if(c==k){
                ans = i;
                break;
            }
        }

        return ans;
    }


}
