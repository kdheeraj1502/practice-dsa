package recursion;

import java.util.*;

public class Permutation2Leetcode2 {


    static List<List<Integer>> result;
    static boolean[] used;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums); // first sort the input
        backtrack(new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<Integer> current, int[] nums){
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
            for (int i = 0; i < nums.length; i++) {
                if (used[i] ) {
                    System.out.println("");
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    System.out.println("");
                    continue;
                }
                used[i] = true;
                current.add(nums[i]);
                backtrack(current, nums);
                current.remove(current.size() - 1);  // 1,
                used[i] = false;

        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 2 };
        System.out.println(permuteUnique(nums));
    }
}
