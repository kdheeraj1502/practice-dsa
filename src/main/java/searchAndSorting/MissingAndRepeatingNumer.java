package searchAndSorting;

public class MissingAndRepeatingNumer {
        public static void main(String[] args) {
            int[] arr = {3, 1, 2, 5, 2}; // Example input array
            int[] result = findMissingAndRepeating(arr);
            System.out.println("Missing number: " + result[0]);
            System.out.println("Repeating number: " + result[1]);
        }

        public static int[] findMissingAndRepeating(int[] arr) {
            int[] result = new int[2];

            for (int i = 0; i < arr.length; i++) {
                int index = Math.abs(arr[i]) - 1; // Get the index to mark as negative
                if (arr[index] > 0) {
                    arr[index] = -arr[index]; // Mark the number as negative
                } else {
                    result[1] = Math.abs(arr[i]); // Repeating number found
                }
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    result[0] = i + 1; // Missing number found
                    break;
                }
            }

            return result;
        }
    }

