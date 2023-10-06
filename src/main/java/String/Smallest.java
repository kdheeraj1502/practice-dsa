package String;

import java.util.HashMap;
import java.util.Map;

public class Smallest {
    public static String smallestWindow(String s, String p) {
        int n = s.length();
        int m = p.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) {
            map.put(p.charAt(ch), map.getOrDefault(p.charAt(ch), 0) + 1);
        }
 //       String S = "timetopractice";
   //     String P = "toc";

        int i = 0, j = 0;
        String ans = "-1";
        int count = map.size();
        int len = Integer.MAX_VALUE;

        while (j < n) {
            if (map.get(s.charAt(j)) != null) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);

                if (map.get(s.charAt(j)) == 0) {
                    count--;
                }
            }
            if (count == 0) {
                while (count == 0) {
                    if (len > (j - i + 1)) {
                        len = (j - i + 1);
                        ans = s.substring(i, j + 1);
                    }
                    if (map.get(s.charAt(i)) != null) {
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);

                        if (map.get(s.charAt(i)) > 0) {
                            count++;
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String S = "timetopractice";
        String P = "toc";
        System.out.println(smallestWindow1(S, P));
    }

    public static String smallestWindow1(String s, String p)
    {
        int n = s.length();
        int m = p.length();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : p.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int i = 0, j = 0;
        int count = map.size();
        int len = Integer.MAX_VALUE;
        String result = "";
        while(j < n){
            if(map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if(map.get(s.charAt(j)) == 0) {
                    count--;
                }
            }
            if(count == 0){
                while(count == 0) {
                    if(len > (j - 1 + 1)){
                        len = (j - 1 + 1);
                        result = s.substring(i, j + 1);
                    }
                    if(map.containsKey(s.charAt(i))){
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                        if(map.get(s.charAt(i)) > 0){
                            count++;
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        return result;
    }
}
