package stackAndQueue;

import javax.sound.midi.Soundbank;
import java.util.Stack;

public class MinStack {

    Stack<Long> stk = new Stack<>();
    long mini ;
    MinStack(){
        this.mini = Integer.MAX_VALUE;
    }

    public void push(long val){
        if(stk.isEmpty()){
            mini = val;
            stk.push(val);
        } else {
            if(val < mini){

                stk.push(2*val - mini);
                mini = val;
            } else {
                stk.push(val);
            }
        }
    }

    public void pop(){
        if(stk.isEmpty()){
            System.out.println("stk is empty");
            System.exit(-1);
        }
        long el = stk.pop();
        if(el< mini){
            mini = 2*mini-el;

        }
    }

    public long top(){
        if(stk.isEmpty()){
            System.out.println("stk is empty");
            System.exit(-1);
        }
        long el = stk.peek();
        return Math.max(el, mini);
    }

    public long getMin(){
        return mini;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
