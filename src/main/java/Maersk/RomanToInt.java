package Maersk;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        String s= "MCMXCIV";

        int ans = 0;

        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentVal = romanValues.get(s.charAt(i));
            int nextVal = (i + 1 < s.length()) ? romanValues.get(s.charAt(i + 1)) : 0;

            if (currentVal < nextVal) {
                result += nextVal - currentVal;
                i++; // Skip the next character, as it has already been considered
            } else {
                result += currentVal;
            }
        }



        System.out.println(result);
    }
}
