package Maersk;

import java.util.*;

public class TripletSum {
    public static void main(String[] args) {

        int[] arr = {5, 32, 1, 7, 10, 50, 19, 21, 2};

        List<Integer> ans = new ArrayList<>();

        findAns(arr, ans);
    }

    private static void findAns(int[] arr, List<Integer> ans) {

        int n = arr.length;

        if (n < 3) {
            System.out.println("Array must have at least 3 elements to form valid pairs.");
            return;
        }

        Arrays.sort(arr); // Sort the array in ascending order
        boolean foundPairs = false;

        for (int a = n - 1; a >= 2; a--) {
            int b = 0;
            int c = a - 1;

            while (b < c) {
                int sum = arr[b] + arr[c];
                if (sum == arr[a]) {
                    System.out.println(arr[a] + " " + arr[b] + " " + arr[c]);
                    foundPairs = true;
                    break; // Stop looking for more pairs for this 'a'
                } else if (sum < arr[a]) {
                    b++;
                } else {
                    c--;
                }
            }

            if (foundPairs) {
                break; // Stop the loop if pairs are found
            }
        }

        if (!foundPairs) {
            System.out.println("No valid pairs found in the array.");
        }
    }
}
