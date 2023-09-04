import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int num = 1041;
        String binary = Integer.toBinaryString(num);
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '0'){
                count++;
            } else{
                if(count > 0){
                    list.add(count);
                }
                count = 0;
            }
        }
        int max = 0;
        for(int n : list){
            max = Math.max(max, n);
        }
        System.out.println(max);
    }
}
