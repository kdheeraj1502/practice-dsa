package matrix;

import java.util.Arrays;

public class SortMatrix {

   static int[][] sortedMatrix(int N, int Mat[][]) {
        int result[][] = new int[N][N];
        for(int i = 0; i < Mat.length; i++){
            Arrays.sort(Mat[i]);
            result[i] = Mat[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int N=4;
        int [][] Mat= {{ 10,20,30,40 },
                {15,25,35,45 },
                {27,29,37,48 },
                {32,33,39,50 }};
        int[][] result =  sortedMatrix(N, Mat);
        for(int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }
}
