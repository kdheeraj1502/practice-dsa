package stackAndQueue;

public class TrappingWater {

    public static void main(String[] args) {
        int[] arr = {7,4,0,9};

        int n = 4;

        System.out.println(trappingWater(arr , n));
    }

    private static long trappingWater(int[] arr, int n) {
        int[] lh = new int[n];
        int[] rh = new int[n];


        int leftMax = arr[0];
        int rightmax =arr[n-1] ;


        for(int i = 0 ; i<n ; i++){
            if(arr[i] >leftMax){
                leftMax = arr[i];
            }
            lh[i] = leftMax;
        }

        for(int i = n-1 ; i>=0 ; i--){
            if(arr[i] >rightmax){
                rightmax = arr[i];
            }
            rh[i] = rightmax;
        }

        long water = 0;

        for(int i = 0; i<n; i++ ){
            water = water + Math.min(lh[i], rh[i]) - arr[i];
        }

        return water;
    }
}
