package Heap;

import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> {

    private ArrayList<T> list ;

    MaxHeap(){
        list = new ArrayList<>();
    }

    public int parent(int index){
        return (index-1)/2;
    }

    public int left(int index){
        return 2*index+1;
    }

    public int right(int index){
        return 2*index+2;
    }

    public void add(T data){
        list.add(data);
        upheap(list.size()-1);
    }

    private void upheap(int index) {
        if(index==0){
            return;
        }
        int p = parent(index);
        if(list.get(index).compareTo(list.get(p))>0){
            swap(index, p);
            upheap(p);
        }

    }

    private void swap(int index, int parent) {
        T temp = list.get(index);
        list.set(index , list.get(parent));
        list.set(parent , temp);
    }

    public T remove() throws Exception {
        if(list.isEmpty()){
            throw new Exception("list is already empty");
        }
        T temp = list.get(0);
        T last = list.remove(list.size()-1);

        if(!list.isEmpty()){
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }

    private void downheap(int index) {

        int max = index;
        int right = right(index);
        int left = left(index);

        if(left< list.size() && list.get(left).compareTo(list.get(index))>0){
            max = left;
        }

        if(right< list.size() && list.get(right).compareTo(list.get(index))>0){
            max = right;
        }

        if(max!=index){
            swap(max , index);
            downheap(max);
        }

    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }


}
