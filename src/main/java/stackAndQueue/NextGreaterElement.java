package stackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
    long[] arr = {1,2,1,4};
    long[] ans = nextLargerElement(arr, 4);

        System.out.println(Arrays.toString(ans));

    }


    public static long[] nextLargerElement(long[] arr, int n)
    {
        long[] ans = new long[n];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int index = stack.pop();
                ans[index] = arr[i];
            }
            stack.push(i);
        }

        return ans;
    }
}
