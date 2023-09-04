package array;

public class LongestPeak {
    public static int longestPeak(int[] array) {
        int maxLen = 0;
        for(int i = 1; i < array.length - 1; i++){
            if(array[i - 1] < array[i] && array[i] > array[i + 1]){
                int j = i;
                int k = i;
                while(j > 0){
                    if(array[j - 1] < array[j]){
                        j--;
                    }
                    else{
                        break;
                    }
                }
                while(k < array.length){
                    if(array[k + 1] < array[k]){
                        k++;
                    } else{
                        break;
                    }
                }
                maxLen = Math.max(maxLen, k - j + 1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int input [] = { 1, 3, 2};
        System.out.println(longestPeak(input));
    }
}
