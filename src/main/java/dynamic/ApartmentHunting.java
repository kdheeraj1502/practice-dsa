package dynamic;

import java.util.ArrayList;
import java.util.*;
import java.util.Map;

public class ApartmentHunting {

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int [] minDistances = new int[blocks.size()];
        for(int i= 0; i < reqs.length; i++){
            int [] values = getMinDistances(blocks, reqs[i]);

            compareResult(minDistances, values);
        }
        int idMinValue = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < minDistances.length; i++){
            int current = minDistances[i];
            if(current < minValue){
                minValue = current;
                idMinValue = i;
            }
        }
        return idMinValue;
    }

    public static int[] getMinDistances(List<Map<String, Boolean>> blocks, String reqs){
        int [] minDistances = new int[blocks.size()];
        int closest = Integer.MAX_VALUE;
        for(int i = 0; i < blocks.size(); i++){
            if(blocks.get(i).get(reqs)){
                closest = i;
            }
            minDistances[i] = Math.abs(i - closest);
        }
        for(int i = blocks.size() - 1; i >= 0; i--){
            if(blocks.get(i).get(reqs)){
                closest = i;
            }
            minDistances[i] = Math.min(minDistances[i],
                    Math.abs(i - closest));
        }
        return minDistances;
    }

    public static void compareResult(int [] minDistances, int [] newValue){
        for(int i = 0; i < minDistances.length; i++){
            minDistances[i]= Math.max(minDistances[i], newValue[i]);
        }
    }

    public static void main(String[] args) {
        List<Map<String, Boolean>> blocks = new ArrayList<Map<String, Boolean>>();

        blocks.add(0, new HashMap<String, Boolean>());
        blocks.get(0).put("gym", false);
        blocks.get(0).put("school", true);
        blocks.get(0).put("store", false);

        blocks.add(1, new HashMap<String, Boolean>());
        blocks.get(1).put("gym", true);
        blocks.get(1).put("school", false);
        blocks.get(1).put("store", false);

        blocks.add(2, new HashMap<String, Boolean>());
        blocks.get(2).put("gym", true);
        blocks.get(2).put("school", true);
        blocks.get(2).put("store", false);

        blocks.add(3, new HashMap<String, Boolean>());
        blocks.get(3).put("gym", false);
        blocks.get(3).put("school", true);
        blocks.get(3).put("store", false);

        blocks.add(4, new HashMap<String, Boolean>());
        blocks.get(4).put("gym", false);
        blocks.get(4).put("school", true);
        blocks.get(4).put("store", true);

        String[] reqs = new String[] {"gym", "school", "store"};

        System.out.println(apartmentHunting(blocks, reqs));
    }
}
