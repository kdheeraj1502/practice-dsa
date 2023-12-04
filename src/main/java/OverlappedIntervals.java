import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class OverlappedIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 8}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = overlappedInterval(intervals);

        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
    public static int[][] overlappedInterval(int[][] arr)
    {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));


        ArrayList<int[]> ans = new ArrayList();

        int[] arrres = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arrres[1] >= arr[i][0]) {
                if (arrres[1] <= arr[i][1])
                    arrres[1] = arr[i][1];
            } else {
                ans.add(arrres);
                arrres = arr[i];
            }
        }

        ans.add(arrres);

        return ans.toArray(new int[0][]);
    }

}
