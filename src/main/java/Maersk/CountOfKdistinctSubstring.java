package Maersk;

import java.util.Arrays;

public class CountOfKdistinctSubstring {

    public static void main(String[] args) {

        String s = "aba";
        int k = 2;
        long ans = 0;
        int j = 0;
        int dist_count = 0;
        int[] hash = new int[26];
        for(int i = 0; i < s.length(); i++){
            hash[s.charAt(i) - 'a']++;
            if(hash[s.charAt(i) - 'a'] == 1){
                dist_count++;
            }
            while(dist_count > k){
                hash[s.charAt(j) - 'a']--;
                if(hash[s.charAt(j) - 'a'] == 0){
                    dist_count--;
                }
                j++;
            }
            ans += i - j + 1;
        }
       // return ans;

        System.out.println(ans);
    }
}
