package Heap;

import java.util.PriorityQueue;

public class MinCost {

    public static void main(String[] args) {

        long[] arr = {4, 2, 7, 6, 9};

        System.out.println(minCost(arr , arr.length));

    }

    static long minCost(long arr[], int n)
    {


        PriorityQueue<Long> queue = new PriorityQueue<>();


        for(long a : arr){
            queue.offer(a);
        }


        long sum = 0;
        long ans = 0;
        long mina = 0;
        long minb = 0;
        while(!queue.isEmpty()){

             mina = queue.poll();
            if(!queue.isEmpty()){
                minb = queue.poll();
            }


            sum = mina + minb;
            ans = ans+ sum;

            if(!queue.isEmpty()){
                queue.offer(sum);
            }

        }

        return ans;
    }
}
