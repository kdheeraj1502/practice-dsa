package String;

import java.util.*;

public class SecondNoNRepeating {
    public static int firstUniqChar(String s) {
        long a = 9l;
        long arr[] = null;;
        int b = arr.length;
        Set<Character> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        char input[] = s.toCharArray();
        for(int i = 0; i < input.length; i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                list.add(i);
            } else{
                list.remove(new Integer(i));
            }
            set.add(ch);
        }
        return list.size() > 0 ? list.get(0) : -1;
    }
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

}
