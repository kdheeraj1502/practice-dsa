package stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        stack.print();
    }
}
