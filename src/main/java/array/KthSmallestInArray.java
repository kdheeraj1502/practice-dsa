package array;

public class KthSmallestInArray {
    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        int max = Integer.MIN_VALUE;
        for(int in : arr) {
            max = Math.max(max, in);
        }
        int aux[] = new int[max + 1];
        for(int i = 0; i < arr.length; i++){
            aux[arr[i]]++;
        }

        int count = 0;
        for(int i = 0; i < aux.length; i++){
            if(aux[i] != 0){
                count++;
            }
            if(count == 3){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 10, 4, 20, 15 };
        System.out.println(kthSmallest(arr, 0, 0, 4));
    }
}
