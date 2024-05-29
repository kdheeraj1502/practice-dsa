package Heap;

import java.util.TreeMap;

public class IsStraightHand {

    public static void main(String[] args) {
        int hand[] = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        System.out.println(isStraightHand(hand.length, 3 , hand));
    }

    static boolean isStraightHand(int N, int groupSize, int hand[]) {


        if(N%groupSize!=0){
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();


        for(int h : hand){
            map.put(h , map.getOrDefault(h , 0)+1);
        }


        while(map.size()>0){
            int min = map.firstKey();

            for(int i = min ; i< min+groupSize ; i++){
                if(map.containsKey(i)){
                    int count = map.get(i);
                    if(count == 1){
                        map.remove(i);
                    } else {
                        map.put(i , map.getOrDefault(i , 0)-1);
                    }

                } else return false;
            }
        }

        return true;
    }
}
