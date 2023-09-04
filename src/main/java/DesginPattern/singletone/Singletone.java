package DesginPattern.singletone;

public class Singletone {

    private static volatile Singletone INSTANCE = null;

    private Singletone(){};

    public static Singletone getInstance(){

        if(INSTANCE == null){
            synchronized (Singletone.class){
                if(INSTANCE == null){
                    INSTANCE =  new Singletone();
                }
            }

        }
        return INSTANCE;
    }

    public void test(){
        System.out.println(INSTANCE.hashCode());
    }

}
