package dynamic;

import java.util.*;


public class TruckShippingMaxUnit {

    public static void main(String[] args) {
        List<Integer> boxes = Arrays.asList(3, 1, 6);
        List<Integer> units = Arrays.asList(2, 7, 4);

        long truckCapacity = 6;

        long maxUnits = calculateMaxUnits(boxes, units, truckCapacity);
        System.out.println("Maximum units that can be shipped: " + maxUnits);
    }

    private static long calculateMaxUnits(List<Integer> boxes, List<Integer> units, long truckCapacity) {
        List<Pair> pairs = new ArrayList<>();
        for(int i = 0; i < units.size(); i++){
            pairs.add(new Pair(boxes.get(i), units.get(i)));
        }
        Collections.sort(pairs);
        long maxUnit = 0;
        for(int i = 0; i < units.size(); i++){
            if(truckCapacity > 0){
                if(pairs.get(i).box <= truckCapacity){
                    maxUnit += pairs.get(i).box * pairs.get(i).unit;
                    truckCapacity -= pairs.get(i).box;
                } else{
                    maxUnit += truckCapacity * pairs.get(i).unit;
                    truckCapacity = 0;
                }
            }

        }
        return maxUnit;
    }

}
class Pair implements Comparable<Pair> {
    long box;
    long unit;
    public Pair(long box, long unit){
        this.box = box;;
        this.unit = unit;
    }

    @Override
    public int compareTo(Pair o) {
        return Long.compare(o.unit, this.unit);
    }
}