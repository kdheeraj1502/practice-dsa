package array;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int start = 0, end = height.length - 1, leftmax = 0, rightMax = 0, water = 0;
        while (start < end) {
            leftmax = Math.max(leftmax, height[start]);
            rightMax = Math.max(rightMax, height[end]);
            if(leftmax < rightMax){
                water += leftmax - height[start++];
            } else{
                water += rightMax - height[end--];
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(nums));
    }
}
