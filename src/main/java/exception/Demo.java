package exception;

import org.omg.Messaging.SyncScopeHelper;

public class Demo {
}

class A {


  void  m1() throws RuntimeException {
      System.out.println("Hello 1");
    }
    public static int get(){
        try{
             System.out.println(12/0);

            return 1;
        }catch (Exception ex){
            return 2;
        }
        finally {
            return 3;
        }
    }

    public static void main(String[] args) throws Exception {
        A a = new B();
        a.m1();
        System.out.println(get());

    }
}

class B extends A {

/*        @Override
       void m1() throws Exception {
            System.out.println("Hello 2");
        }*/
}