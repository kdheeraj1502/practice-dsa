package stackAndQueue;

public class StackUsingLinkedList {

    Node top;
    int size;
    StackUsingLinkedList(){
        this.top = null;
    }

    private void push(int x){
        Node node = new Node(x);
        node.next = top;
        top = node;
    }

    private int pop(){

        if(isEmpty()){
            System.out.println("stack overfow");
            System.exit(1);
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    private boolean isEmpty() {
        return top == null;
    }

    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(42);
        stack.push(-17);
        stack.push(Integer.MIN_VALUE);
        stack.push(Integer.MAX_VALUE);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}


class Node {
    int data ;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
