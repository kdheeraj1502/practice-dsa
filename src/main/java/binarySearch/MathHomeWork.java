package binarySearch;

import java.util.Arrays;
import java.util.List;

public class MathHomeWork {
    public static int mathHomeWork(int threshold, List<Integer> points){
        int start = 0;
        int end = points.size() - 1;
        int first = points.get(0);
        int diff = Integer.MAX_VALUE;
        int thresholdIndex = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if((points.get(mid) - first) >= threshold){
                if((points.get(mid) - first) < diff){
                    diff = points.get(mid) - first;
                    thresholdIndex = mid;
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int jump = 0;
        int count = 1;
        while(jump < thresholdIndex){
            jump += 2;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(mathHomeWork(4, Arrays.asList(1, 2, 3, 5, 8)));
    }
}
