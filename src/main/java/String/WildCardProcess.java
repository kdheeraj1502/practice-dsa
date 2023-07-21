package String;

import java.util.Arrays;

public class WildCardProcess {
    public static String solution(String S) {
        char[] chars = S.toCharArray();
        int end = chars.length - 1;
        int countA = 0;
        int countB = 0;
        for(int i = end; i >= 0; i --){
            if(chars[end] == '?'){
                if(countA < countB){
                    chars[end] = 'a';
                    countB = 0;
                } else{
                    chars[end] = 'b';
                    countA = 0;
                }
            }
            if(chars[end] == 'a') countA++;
            if(chars[end] == 'b') countB++;
            end--;
        }
        countA = 0;
        countB = 0;
        System.out.println(Arrays.toString(chars));
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == 'a') {
                countA++;
                if(countA == 3) {
                    chars[i] = 'b';
                    countA = 0;
                }
                countB = 0;
            }
            if(chars[i] == 'b') {
                countB++;
                if(countB == 3) {
                    chars[i] = 'a';
                    countB = 0;
                }
                countA = 0;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "aa??aa";
        System.out.println(solution(s));
    }
}
