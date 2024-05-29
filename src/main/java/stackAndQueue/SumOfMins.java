package stackAndQueue;

import java.util.Stack;

public class SumOfMins {
    public static int sumOfMins(int[] arr) {
        final int MOD = 1000000007;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Calculate left array
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear the stack for the next iteration
        stack.clear();

        // Calculate right array
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the sum of mins
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * (i - left[i]) * (right[i] - i)) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        int[] arr = {71,55,82,55};
        int result = sumOfMins(arr);
        System.out.println(result);
    }
}
