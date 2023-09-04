package array;

import java.util.*;

public class ClassPhoto {
    public static boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        if(redShirtHeights == null || blueShirtHeights == null) return false;
        if(redShirtHeights.size() != blueShirtHeights.size()) return false;
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        if(redShirtHeights.get(0) < blueShirtHeights.get(0)){
            return match(blueShirtHeights, redShirtHeights);
        } else{
            return match(redShirtHeights, blueShirtHeights);
        }
    }

    public static boolean match(
            ArrayList<Integer> blueShirtHeights, ArrayList<Integer> redShirtHeights) {
        int index = 0;
        while(index < blueShirtHeights.size()){
            if(blueShirtHeights.get(index) == redShirtHeights.get(index) || blueShirtHeights.get(index) < redShirtHeights.get(index)){
                return false;
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights = new ArrayList<>();
        redShirtHeights.add(6);
        ArrayList<Integer> blueShirtHeights = new ArrayList<>();
        blueShirtHeights.add(6);

        System.out.println(classPhotos(redShirtHeights, blueShirtHeights));
    }
}
