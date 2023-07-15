package stack;

public class Stack {

    private int capacity;
    private int minCapacity;
    private int[] data;
    private int top = -1;

    Stack(){

       this.data = new int[1000];
    }

    Stack(int size){
       this.data = new int[size];
       capacity =minCapacity =  size;
    }

    public int size(){
        return top+1;
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(capacity == size()){
           int[] newData = new int[capacity*2];
           System.arraycopy(data , 0,newData,0,capacity);
           data = newData;
           capacity = capacity*2;
        }
        top++;
        data[top] = value;
    }
    public void print(){
        for (int datum : data) {
            System.out.println(datum);
        }
    }

    public int pop(){
        if(isEmpty()){
            throw new IllegalArgumentException("StackEmptyException");
        }
        int topVal = data[top];
        top--;
        if(size() == capacity/2 && capacity>=minCapacity){
            System.out.println("size halved");
            capacity = capacity/2;
            int[] newData = new int[capacity];
            System.arraycopy(data, 0, newData, 0,capacity);
            data = newData;
        }

        return topVal;
    }
    public int top(){
        if(isEmpty()){
            throw new IllegalArgumentException("StackEmptyException");
        }
        return data[top];
    }
}
