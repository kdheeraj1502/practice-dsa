package Maersk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByFrequency {

    public static void main(String[] args) {
        String s = "tree";
        
        String ans = freuqncySort(s);
        System.out.println(ans);
    }

    private static String freuqncySort(String s) {

        Map<Character , Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c , map.getOrDefault(c , 0)+1);
        }

        PriorityQueue<Character> queue = new PriorityQueue((a, b) -> map.get(b) - map.get(a));
        queue.addAll(map.keySet());

        StringBuilder ans = new StringBuilder();

        while(!queue.isEmpty()){
            char ch = queue.poll();
            int count = map.get(ch);
            while(count>0){
                ans= ans.append(ch);
                count--;
            }
        }

        return ans.toString();
    }
}
