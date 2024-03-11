package array;

public class SearchInAnArray {
    public static int search (int arr[], int n, int x, int k) {
        int i = 0;
        while (i < n) {
         //   if (arr[i] == x)
           //     return i;
            i = i + Math.max(1, Math.abs(arr[i] - x) / k);
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[ ] = {3, 5, 6, 8, 6}, K = 1, X = 6;
        System.out.println(search(arr, 5, X, K));
    }
}
