package Maersk;

public class PeakElement {

    public static void main(String[] args) {
       int[] arr = {3,4,3,2,1};
       int n = 5;

        System.out.println(peakElement(arr, n));
    }

    public static int peakElement(int[] arr, int n)
    {
        int low = 0;
        int high = n-1;

        if(n==1){
            return 0;
        }
        if(n==2){
            if(arr[0]> arr[1]){
                return 0;
            } else {
                return 1;
            }
        }
        while(low<=high){
            int mid = (low+ high)/2;
            if((mid==n-1 || arr[mid] > arr[mid+1]) && (mid==0 || arr[mid]> arr[mid-1])){
                return mid;
            } else if(mid > 0 && arr[mid] > arr[mid-1]){
                low = mid+1;
            } else {
                high = mid;
            }
        }

        return -1;
    }
}
