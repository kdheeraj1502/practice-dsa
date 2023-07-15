import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] arr = {10,150,6,67,61,16,86,6,67,78,150,3,28,143};

        ArrayList<ArrayList<Integer>> ans = stockBuySell(arr, arr.length );
        System.out.println(ans);
    }

    private static ArrayList<ArrayList<Integer>> stockBuySell(int[] A, int n) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int buy = 0;

        int sell = 0;
        int currMin = 0;
        int currProfit = 0;
        int maxProfit = 0;

        for(int i = 1; i<n ; i++){
            if(A[i]< A[currMin]){
                currMin = i;
            }
            currProfit = A[i] - A[currMin];
            if (currProfit > maxProfit) {
                buy = currMin;
                sell = i;
                maxProfit = currProfit;
                ArrayList<Integer> a = new ArrayList<>();
                a.add(buy);
                a.add(sell);
                ans.clear();
                ans.add(a);
            } else if (currProfit == maxProfit) {
                buy = currMin;
                sell = i;
                ArrayList<Integer> a = new ArrayList<>();
                a.add(buy);
                a.add(sell);
                ans.add(a);
            }
        }

        return ans;
    }
}
