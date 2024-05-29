package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaxCombinations {

    public static void main(String[] args) {
       int N = 2;
       int K = 2;
       int[] A = {3, 2};
        int[] B = {1, 4};
        List<Integer> ans = maxCombinations( N,  K,  A,  B);
       ans.forEach(System.out::println);

    }

    static List<Integer> maxCombinations(int N, int K, int[] A, int[] B) {
        // code here

        List<Integer> maxComb = new ArrayList<>();

        Arrays.sort(A);
        Arrays.sort(B);

        PriorityQueue<Integer> queue = new PriorityQueue<>();


        for(int i = N-1 ; i>N-K-1 ; i--){
            for(int j = N-1 ; j>N-K-1 ; j--){
                int sum = A[i] + B[j];
                if(queue.size()<K){
                    queue.offer(sum);
                } else {
                    if(queue.peek()<sum){
                        queue.poll();
                        queue.offer(sum);
                    } else {
                        break;
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            maxComb.add(0 , queue.poll());
        }

        return maxComb;

    }
}
