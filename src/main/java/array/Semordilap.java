package array;

import java.util.*;

public class Semordilap {
    public static ArrayList<ArrayList<String>> semordnilap(String[] words) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String reversed = reverse(words[i]);
            for(int j = i + 1; j < words.length; j++){
                if(words[j].equals(reversed)){
                    ArrayList<String> resulList = new ArrayList<>();
                    resulList.add(words[i]);
                    resulList.add(reversed);
                    result.add(resulList);
                }
            }
        }
        return result;
    }

    private static String reverse(String str){
        int start = 0;
        int end = str.length() - 1;
        char strChars[] = str.toCharArray();
        while(start < end){
            char temp = strChars[start];
            strChars[start] = strChars[end];
            strChars[end] = temp;
            start++;
            end--;
        }
        return new String(strChars);
    }

    public static void main(String[] args) {
        String [] words = { "aaa", "bbb" };
        System.out.println(semordnilap(words));
    }
}
