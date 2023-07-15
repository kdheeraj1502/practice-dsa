package java8.stream;

public class Demo {
    public static void main(String[] args) {
        A a = () -> System.out.println("In method of A");
        B b = () -> System.out.println("In method of B");
        a.method();
        b.method();
    }
}
