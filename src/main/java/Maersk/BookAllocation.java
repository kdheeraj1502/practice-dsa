package Maersk;

import java.util.Arrays;

public class BookAllocation {

    public static void main(String[] args) {
        int[] arr = {12,34,67,90};
        int N= 4;
        int M = 2;
        System.out.println(findPages(arr , N , M));
    }

    public static int findPages(int[]A,int N,int M)
    {
        int low = Arrays.stream(A).boxed().max(Integer::compare).get();
        int high = Arrays.stream(A).sum();

        if(N< M){
            return -1;
        }
        int ans = -1;
        for(int i = low ; i<=high ; i++){
            boolean canAllocate = allocate(A , N, M, i);

            if(canAllocate){
                ans = i;
                break;
            }
        }

        return ans;
    }

    public static boolean allocate(int[] A , int size, int stu , int pages){

        int tempPage = A[0];
        int stuCount = 1;
        for(int i =1; i< size ; i++){

            if(tempPage+A[i] > pages){
                stuCount++;
                tempPage = A[i];

            } else {
                tempPage+=A[i];
            }
        }


        return stuCount <= stu;
    }
}
