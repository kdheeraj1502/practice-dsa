package array;

import java.util.*;

public class ClassPhotos {
    public static boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        boolean isBlueIsTall = false;
        if(blueShirtHeights.get(0) > redShirtHeights.get(0)){
            isBlueIsTall = true;
        } else{
            isBlueIsTall = false;
            classPhotos(blueShirtHeights, redShirtHeights);
        }
        int i = 0;
        int j = 0;
        while(i < blueShirtHeights.size() && j < redShirtHeights.size()){
            if(blueShirtHeights.get(i) < redShirtHeights.get(j)){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights = new ArrayList<>();
        redShirtHeights.add(5);
        redShirtHeights.add(8);
        redShirtHeights.add(1);
        redShirtHeights.add(3);
        redShirtHeights.add(4);

        ArrayList<Integer> blueShirtHeights = new ArrayList<>();

        blueShirtHeights.add(6);
        blueShirtHeights.add(9);
        blueShirtHeights.add(2);
        blueShirtHeights.add(4);
        blueShirtHeights.add(5);

        System.out.println(classPhotos(redShirtHeights, blueShirtHeights));
    }
}
