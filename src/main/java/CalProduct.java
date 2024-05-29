import java.util.HashMap;
import java.util.Map;

public class CalProduct {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};



        findProuct(nums);
    }

    private static void findProuct(int[] nums) {
        int product = 1 ;

        for(int i = 0; i< nums.length; i++){
            int tempPrd = 1 ;

            for(int j =0; j< nums.length; j++){

                if(i!=j){
                    tempPrd = nums[j]*tempPrd;
                }
            }
            System.out.println("product at" + i + "---"+ tempPrd);
        }
    }
}
