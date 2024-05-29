package Greedy;

public class JumpGameII {

    public static void main(String[] args) {
        int[] arr = {1,2,0,0,0};

        System.out.println(minJumps(arr));
    }

    static int minJumps(int[] arr){
        int totalJumps = 0;
        int coverage = 0;
        int destination = arr.length - 1;
        int lastJumpIndex = 0;

        if(arr.length==1){
            return 0;
        }
        if(arr[0] == 0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            coverage = Math.max(coverage, i + arr[i]);

            if (i == lastJumpIndex && arr[i]!=0) {
                lastJumpIndex = coverage;
                totalJumps++;
                if (coverage >= destination) {
                    return totalJumps;
                }
            }


        }
        if (lastJumpIndex >= destination) {
            return totalJumps;
        }
        return -1;
    }
}
