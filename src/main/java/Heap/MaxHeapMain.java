package Heap;

import java.util.ArrayList;

public class MaxHeapMain {

    public static void main(String[] args) throws Exception {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.add(34);
        heap.add(45);
        heap.add(22);
        heap.add(89);
        heap.add(76);
        ArrayList<Integer> ans = heap.heapSort();
        System.out.println(ans);
    }
}
