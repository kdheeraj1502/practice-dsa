package array;

import java.util.ArrayList;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        String ans = "";
        ArrayList<Integer> num = new ArrayList<>();
        int fact = 1;
        for(int i = 1;i<n;i++){
            fact=fact*i;
            num.add(i);
        }
        num.add(n);
        k=k-1;
        while(true){
            ans = ans + num.get(k/fact);
            num.remove(k/fact);
            if(num.size()==0)break;
            k = k % fact;
            fact = fact / num.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println(getPermutation(n, k));
    }
}
