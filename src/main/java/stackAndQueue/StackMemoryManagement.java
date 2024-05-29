package stackAndQueue;

import java.util.Arrays;

public class StackMemoryManagement {

    int top = -1;
    int capacity;
    int minCapacity;
    int[] data;

    StackMemoryManagement(){
        this(100);
    }

    public StackMemoryManagement(int size) {
        capacity = minCapacity = size;
        data = new int[size];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int size(){
        return top+1;
    }

    public void push(int value){
        if(size() == capacity){
            int[] newData = new int[capacity*2];
            System.arraycopy(data , 0, newData, 0, capacity);
            data = newData;
            capacity = capacity*2;
        }
        data[++top] = value;
    }

    public int pop(){
       if(isEmpty()){
           throw new IllegalArgumentException("STcak is empty only");
       }
        int value = data[top--];
       if(size() <= capacity/2 && capacity>minCapacity){
           capacity = capacity/2;
           int[] newData = new int[capacity];
           data = Arrays.copyOf(data , capacity);

       }

       return value;
    }

    public  void  print(){
        for (int i = top; i > -1; i--) {
            System.out.println(data[i] + ".....");
        }
    }
}
