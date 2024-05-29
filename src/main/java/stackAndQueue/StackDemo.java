package stackAndQueue;

public class StackDemo {

    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println(stack.pop());
        stack.print();

        StackMemoryManagement stack2 = new StackMemoryManagement();
        stack2.push(20);
        stack2.push(30);
        stack2.push(40);
        stack2.push(50);
        System.out.println(stack2.pop());
        stack2.print();
    }
}
