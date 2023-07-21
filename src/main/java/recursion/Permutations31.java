package recursion;

import java.util.*;

public class Permutations31 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, result, new ArrayList<>(), 0);
        int x = 5;
        if((x & 1) == 1){

        }

        return result;
    }


    public void permute(int[] nums, List<List<Integer>> result, List<Integer> curr, int index) {
        if(index >= nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            swap(nums, i, index);
            permute(nums, result, curr, index + 1);
            swap(nums, i, index);
            curr.remove(curr.size() - 1);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
