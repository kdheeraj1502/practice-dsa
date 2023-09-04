package binarySearch;

import java.util.ArrayList;

public class SubArraySum {

    public static void main(String[] args) {
        int n = 4;
        int s = 0;
        int arr[] = {1,2,3,4};

        ArrayList<Integer> ans = subarraySum(arr, n, s);
        System.out.println(ans);
    }

    private static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> ans = new ArrayList();


        Integer first = 0;
        Integer second = 0;

        int sum = arr[first];

        while(second< n && first< n){
            if(sum == s){
                ans.add(first+1);
                ans.add(second+1);
                return ans;
            }

            if(sum<s){
                second = second +1;
                if(second< n){
                    sum = sum + arr[second];
                }
            } else {
                sum =sum - arr[first];
                first = first+1;
            }
        }
        ans.add(-1);
        return ans;
    }
}
