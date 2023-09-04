package dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class CoinChangeProblem {
    public static long count(int coins[], int N, int sum) {
        Set<List<Integer>> result = new HashSet<>();
        count(result, new ArrayList<>(), coins, N, sum, 0, 0);
        System.out.println(result);
        return result.size();
    }

    public static void count(Set<List<Integer>>  result, List<Integer> curr,
                      int coins[], int N, int sum, int currSum, int index) {
        if(sum == currSum){
            List<Integer> list = new ArrayList<>(curr);
            result.add(list);
            return;
        }
      //  List<Integer> temp = new ArrayList<>();
        int coin = 0;
        for(int i = index; i < N; i++){
            coin = coins[i] + currSum;
            curr.add(coins[i]);
            if(coin <= sum ){
                count(result, curr, coins, N, sum, coin, i + 1);
            }
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int sum = 4;
        int N = 7;
        int coins[] = {1, 1, 2, 2, 3, 3, 4};
        count(coins, N, sum);
    }
}
