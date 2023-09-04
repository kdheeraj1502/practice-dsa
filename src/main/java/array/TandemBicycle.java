package array;

import java.util.*;

public class TandemBicycle {
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Integer blueType[] = null;
        if(fastest){
            Arrays.sort(redShirtSpeeds);
            Arrays.sort(blueShirtSpeeds);
        } else{
            Arrays.sort(redShirtSpeeds);
            blueType = new Integer[blueShirtSpeeds.length];
            int index = 0;
            for(int in : blueShirtSpeeds){
                blueType[index++] = in;
            }
            Arrays.sort(blueType, Collections.reverseOrder());
        }
        return pairing(0, redShirtSpeeds.length - 1, redShirtSpeeds, blueType);
    }

    private int pairing(int i, int j, int[] redShirtSpeeds, Integer[] blueShirtSpeeds){
        int sum = 0;
        while(i < redShirtSpeeds.length && j >= 0){
            sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[j]);
            i++;
            j--;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
