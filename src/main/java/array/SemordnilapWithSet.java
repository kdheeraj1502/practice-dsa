package array;

import java.util.*;

public class SemordnilapWithSet {
    public static ArrayList<ArrayList<String>> semordnilap(String[] words) {
        Set<String> semordnilapStrings = new HashSet<>();
        for(String semord : words){
            semordnilapStrings.add(semord);
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Iterator<String> it = semordnilapStrings.iterator();
        while(it.hasNext()){
            String input = it.next();
            String reversed = reverse(input);
            it.remove();
            if(semordnilapStrings.contains(reversed)){
                ArrayList<String> resulList = new ArrayList<>();
                resulList.add(input);
                resulList.add(reversed);
                result.add(resulList);
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
        String [] words = { "aaa" };
        System.out.println(semordnilap(words));
    }
}
