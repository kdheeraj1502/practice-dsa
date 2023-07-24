package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {
    public static List<String> allPossibleStrings(String s)
    {
        int len = s.length();
        int lastBinary = (1 << len);
        List<String> result = new ArrayList<>();
        for(int i = 1; i < lastBinary; i++){
            int x = i;
            int stringIndex = 0;
            StringBuilder sb = new StringBuilder();
            while(x > 0){
                if((x & 1) == 1){
                    sb.append(s.charAt(stringIndex));
                }
                x >>= 1;
                stringIndex++;
            }
            result.add(sb.toString());
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(allPossibleStrings("abc"));
    }
}
