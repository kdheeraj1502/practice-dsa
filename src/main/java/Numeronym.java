import java.util.*;

public class Numeronym {

    public static String createNumeronym(String input){
        if(input.length() == 0 || input == null) return input;
        if(input.length() >= 3){
            StringBuilder result = new StringBuilder();
            int charCount = input.length();
            return result.append(input.charAt(0)).append(charCount - 2).append(input.charAt(charCount - 1)).toString();
        }
        return input;
    }

    public static void main(String[] args) {
       // String input = "kubernetes";
      //  System.out.println(createNumeronym(input));
        List<String> input = Arrays.asList("domed", "dared", "dated", "diced", "dined", "dosed", "duped");

        for(String input1 : input){
            List<String> input2 = new ArrayList<>();
            input2.add(input1);
            System.out.println(createNumeronymAnother(input2));
            System.out.println(input2 + " ::  ==================================================");
        }

    }

    public static Set<String> createNumeronymAnother(List<String> input){
        // domed

        Set<String> listOfWords = new HashSet<>();
        Set<String> output = new HashSet<>();
        for(String word :  input){
            int count = word.length() - 2;
            int i = 1;
            while(i <= count){
                StringBuilder result = new StringBuilder();
                result.append(word.charAt(0)).append(i).append(word.substring(i + 1));
                if(listOfWords.add(result.toString())){
                    output.add(result.toString());
                } else{
                    output.add(word);
                }
                i++;
            }
        }

        for(String word :  input){
            int i = word.length() - 2;
            int k = 1;
            while(i >= 1){
                StringBuilder result = new StringBuilder();
                result.append(word.substring(0, i)).append(k).append(word.charAt(word.length() - 1));
                if(listOfWords.add(result.toString())){
                    output.add(result.toString());
                } else{
                    output.add(word);
                }
                i--;
                k++;
            }
        }
        return output;
    }
}
