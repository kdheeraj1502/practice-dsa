abstract class A

{
 int i = 20;

}

interface B

{

    void test();

}

public class InterfaceTest extends A implements B {

    @Override
    public void test() {
        System.out.println("This is just an example");

    }

    public static void main(String args[]) {
        A a = new InterfaceTest();
        B b = new InterfaceTest();
        System.out.println(a.i);
        b.test();
    }

}