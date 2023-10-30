package array;

import java.util.HashSet;

public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] arr  = {2,3,1,1,7,8,2}; // 2 3 1 7 8

        removeDuplicate(arr);
    }

    private static void removeDuplicate(int[] array) {

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] == array[j]) {
                    // Shift elements to the left to overwrite the duplicate
                    for (int k = j; k < n - 1; k++) {
                        array[k] = array[k + 1];
                    }
                    n--; // Reduce the size of the array
                   // j--; // Adjust j to recheck the current position
                }
            }
        }


        // Create a new array to hold the unique elements
        int[] resultArray = new int[n];
        System.arraycopy(array, 0, resultArray, 0, n);

        // Print the array with duplicates removed
        System.out.println("Array with duplicates removed:");
        for (int i = 0; i < n; i++) {
            System.out.print(resultArray[i] + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
