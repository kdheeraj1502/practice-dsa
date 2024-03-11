package array;

public class FindPeak {

    public static int find(int arr[], int n) {
        int low = 0;
        int high = n - 1;


        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            if (arr[0] > arr[1]) {
                return 0;
            } else {
                return 1;
            }
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == n - 1 || arr[mid] >= arr[mid + 1])) {
                return mid;
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 4, 3, 1, 6, 5};
        System.out.println(find(nums, 6));
        System.out.println(peakElement(nums, 6));
    }

    public static int peakElement(int[] arr, int n) {
        int low = 0;
        int high = n - 2;

        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            if (arr[0] > arr[1]) {
                return 0;
            } else {
                return 1;
            }
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == n - 1 || arr[mid] >= arr[mid + 1]) && (mid == 0 || arr[mid] >= arr[mid - 1])) {
                return mid;
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return -1;
    }
}
