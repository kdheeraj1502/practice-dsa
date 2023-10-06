package String;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursivelyPrintAllSentence {
    public static ArrayList<ArrayList<String>> sentences(String[][] list) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        giveanswer(list, 0, "", ans);
        return ans;
    }

    private static void giveanswer(String[][] list, int i, String s, ArrayList<ArrayList<String>> ans){
        if(i == list.length){
            String[] temp = s.split(",");
            ans.add(new ArrayList<>(Arrays.asList(temp)));
            return;
        }
        String[] arr = list[i];
        for(String j : arr){
            giveanswer(list, i+1, s + j + ",", ans);
        }
    }

    public static void main(String[] args) {
        String input[][] = {{"you", "we"},
                {"have", "are"}};
        System.out.println(sentences(input));
    }
}
