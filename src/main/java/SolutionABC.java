import java.util.*;

public class SolutionABC {

    public static boolean isAnagram(String input1, String input2){
        if(input1 == null || input2 == null) return false;
        if(input1.equalsIgnoreCase("")|| input2.equalsIgnoreCase("")) return false;
        if(input1.length() != input2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : input1.toUpperCase().toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch : input2.toUpperCase().toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.getOrDefault(ch, 0) - 1);
            }
        }
        Iterator<Map.Entry<Character, Integer>> result  = map.entrySet().iterator();
        while(result.hasNext()){
            Map.Entry<Character, Integer> entry = result.next();
            if(entry.getValue() != 0){
                return false;
            }
        }
    return true;
    }

    public static List<List<String>> collectAnagrams(String wordsList[]){
        List<List<String>> result = new ArrayList<>();
        if(wordsList.length == 0 || wordsList == null) return result;
        for(int i = 0; i < wordsList.length; i++){
            List<String> innerList = new ArrayList<>();
            if(wordsList[i] != "-1"){
                String input1 = new String(wordsList[i]);
                innerList.add(input1);
                wordsList[i] = "-1";
                for(int j = i + 1; j < wordsList.length; j++){
                    if(wordsList[j] != "-1"){
                        String input2 = new String(wordsList[j]);
                        if(isAnagram(input1, input2)){
                            innerList.add(input2);
                            wordsList[j] = "-1";
                        }
                    }
                }
                result.add(innerList);
            }
        }

        return result;
    }
    public static void main(String[] args) {
       // String input1 = ""; // geek
       // String input2 = ""; //keg
     //   boolean result = isAnagram(input1, input2);
      //  System.out.println(result);
        String [] wordsList = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(collectAnagrams(wordsList));
    }
}
