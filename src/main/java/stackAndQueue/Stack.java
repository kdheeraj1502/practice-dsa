package stackAndQueue;

public class Stack {

   int top = -1;

   int[] arr;
   int capacity;
   Stack(int capacity){
       this.capacity = capacity;
       this.arr = new int[capacity];
   }

   public void push(int data){
       if(top == capacity-1){
           throw new IllegalArgumentException("overflow stack");
       }
       top++;
       arr[top]= data;

   }

    public int pop(){
        if(top==-1){

            throw new IllegalArgumentException("stack is empty");
        }
        return arr[top--];

    }

    public int top(){
       return arr[top];
    }

    public  void  print(){
        for (int i = top; i > -1; i--) {
            System.out.println(arr[i] + ".....");
        }
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return -1; // You can choose to throw an exception here if you prefer
        }
        return arr[top];
    }
}
