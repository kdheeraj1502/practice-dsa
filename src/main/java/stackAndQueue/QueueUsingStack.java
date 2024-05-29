package stackAndQueue;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();


    public void push(int x){
        input.push(x);
    }

    public int pop(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    public int peek(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());
    }

    int size() {
        return (output.size() + input.size());
    }
}
