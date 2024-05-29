package stackAndQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueu {

    Queue<Integer> que = new LinkedList<>();

    public void add(int x){
        que.add(x);

        for(int i = 0 ; i< que.size()-1; i++){
            que.add(que.remove());
        }
    }

    public int pop(){
        return que.remove();
    }

    public int top(){
        return que.peek();
    }

    public static void main(String[] args) {
        StackUsingQueu s = new StackUsingQueu();
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);

        System.out.println("Top of the stack: " + s.top());
        System.out.println("Size of the stack before removing element: " + s.size());
        System.out.println("The deleted element is: " + s.pop());
        System.out.println("Top of the stack after removing element: " + s.top());
        System.out.println("Size of the stack after removing element: " + s.size());

    }

    private int size() {
       return que.size();
    }

}
