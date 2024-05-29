package Heap;

import java.util.PriorityQueue;
import java.util.Stack;

public class MedianFromDataStream {
    private PriorityQueue<Integer> maxHeap; // To store the smaller half
    private PriorityQueue<Integer> minHeap; // To store the larger half

    public MedianFromDataStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max heap
        minHeap = new PriorityQueue<>(); // Min heap
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFromDataStream medianFinder = new MedianFromDataStream();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // Output: 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // Output: 2.0
    }


}
