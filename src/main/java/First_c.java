public class First_c {

    public void method() {
        System.out.println("In method method");
    }

    {
        System.out.println("In iatcne block");
    }

    public void First_c(){
        System.out.println("In method First_c");
    }

    static {
        System.out.println("Hi there");
    }

    public static void main(String[] args) {
        First_c c = new First_c();
        c.First_c();
        c.method();
    }
}
