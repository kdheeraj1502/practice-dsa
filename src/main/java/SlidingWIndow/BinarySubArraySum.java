package SlidingWIndow;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArraySum {

    public static void main(String[] args) {
        int[] input = {1,0,1,0,1};
        int goal = 2;
        int count = numSubarraysWithSum(input , goal);
        System.out.println(count);
    }

    private static int numSubarraysWithSum(int[] nums, int goal) {

        int count = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int n : nums){
            sum = sum+n;
            int target = sum-goal;
            if(map.containsKey(target)){
                count = count + map.get(target);
            }
            map.put(sum , map.getOrDefault(sum, 0)+1);
        }

        return count;

    }
}
