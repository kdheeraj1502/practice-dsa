package matrix;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int kthSmallest(int[][]mat,int n,int k)
    {
            PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(pq.size()>k)
                {
                    pq.poll();
                }
                pq.add(mat[i][j]);
            }
        }
        if(pq.size()>k)
        {
            pq.poll();
        }
        return pq.peek();
    }

    int mat[][] = {
            { 7, 17, 27, 36, 38 },
            { 14, 23, 35, 38, 43 },
            { 19, 26, 42, 49, 50 },
            { 23, 33, 48, 52, 53 },
            { 30, 40, 52, 56, 64 }};

    public static void main(String[] args) {
        int N = 5;
// 7, 14, 17, 19, 23, 27, 30, 36,
       int mat[][] = {
                { 7, 17, 27, 36, 38 },
                { 14, 23, 35, 38, 43 },
                { 19, 26, 42, 49, 50 },
                { 23, 33, 48, 52, 53 },
                { 30, 40, 52, 56, 64 }};
        int k =  13;
      /* int mat[][] =     {{16, 28, 60, 64},
            {22, 41, 63, 91},
            {27, 50, 87, 93},
            {36, 78, 87, 94 }};*/
        System.out.println(kthSmallest(mat, N, k));
    }
}
