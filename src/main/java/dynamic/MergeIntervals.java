package dynamic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

    public static void mergeIntervals(Interval arr[]){
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Stack<Interval> stack=new Stack<>();
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++){
            Interval top = stack.peek();
            if(top.end < arr[i].start){
                stack.push(arr[i]);
            } else if(top.end < arr[i].end){
                top = stack.pop();
                top.end = arr[i].end;
                stack.push(top);
            }
        }
        System.out.print("The Merged Intervals are: ");
        while (!stack.isEmpty())
        {
            Interval t = stack.pop();
            System.out.print("["+t.start+","+t.end+"] ");
        }

    }

    public static void main(String[] args) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
    }
}

class Interval {
    int start;
    int end;
    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}