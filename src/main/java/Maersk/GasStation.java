package Maersk;

import java.util.PriorityQueue;

public class GasStation {

    public static void main(String[] args) {
        int[] arr = {3,6,12,19,33,44,67,72,89,95};
        int k = 2;
        double ans = minimiseMaxDistance(arr, k);
        //double v = Math.round(ans * 100.0) / 100.0;
        System.out.println("The answer is: " + ans);
    }

    public static double minimiseMaxDistance(int[] stations, int K) {
        int n = stations.length;
        int howMany[] = new int[n-1];
        int maxIdx = -1;
        double  maxSection = -1;

        PriorityQueue<Pair> que = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

        for(int i =0; i < n-1; i++){
            que.add(new Pair(stations[i+1]- stations[i] , i));
        }
        for(int gasStation = 1;gasStation <=K ; gasStation++){

            Pair tp = que.poll();

            int secIdx = tp.second;
            howMany[secIdx]++;

            double sectionLength = (double)(stations[secIdx+1]- stations[secIdx])/((double)howMany[secIdx]+1);
            que.add(new Pair(sectionLength , secIdx));
        }

        return que.peek().first;
    }


}

class Pair {
    double first;
    int second;

    Pair(double first, int second) {
        this.first = first;
        this.second = second;
    }
}

