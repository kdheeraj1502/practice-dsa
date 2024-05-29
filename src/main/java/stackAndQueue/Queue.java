package stackAndQueue;

import java.util.Arrays;

public class Queue {

    int front;
    int rear;
    int[] arr;
    int capacity;
    int size;
    Queue(){
        this(10);
    }
    Queue(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void add(int data){

        if(size >= capacity){
            System.out.println("queue is full");
            System.exit(1);
        }
        arr[rear] = data;
        rear = (rear+1)%capacity;
        System.out.println("The element pushed is " + data);
        size++;

    }

    public int remove(){
        if(front <0){
            System.out.println("queue is empty");
            System.exit(1);
        }
        int popped = arr[front];
        front = (front+1) % capacity;
        size--;
        return popped;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Queue queu = new Queue(3);
        queu.add(1);
        queu.add(2);
        queu.add(3);
        System.out.println(queu.remove()); ;
        queu.add(5);
        queu.add(6);
        queu.print();
    }

}
