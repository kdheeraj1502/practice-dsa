package binarySearch;

public class OccurenceCount {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};

        System.out.println(count(arr, arr.length, 2));
    }

    public static int count(int[] arr, int n, int x) {
        // code here
        int firstIndex = findFirstIndex(arr, 0, n-1, x);
        int lastIndex = findLastIndex(arr, 0, n-1, x);

        return (lastIndex - firstIndex +1);
    }


    public static int findFirstIndex(int[] arr , int start , int end, int key){


        if(end< start){
            return -1;
        }
        int mid = (start+ end)/2;

        if(key == arr[mid] && (mid == start || arr[mid-1] !=key)){
            return mid;
        }
        if(key<=arr[mid]){
            return findFirstIndex(arr, start, mid-1, key);
        } else {
            return findFirstIndex(arr, mid+1, end, key);
        }

    }

    public static int findLastIndex(int[] arr , int start , int end, int key){
        if(end< start){
            return -1;
        }
        int mid = (start+ end)/2;

        if(key == arr[mid] && (mid == end || arr[mid+1] !=key)){
            return mid;
        }
        if(key<arr[mid]){
            return findLastIndex(arr, start, mid-1, key);
        } else {
            return findLastIndex(arr, mid+1, end, key);
        }

    }
}
