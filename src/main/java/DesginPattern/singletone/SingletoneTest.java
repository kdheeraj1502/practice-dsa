package DesginPattern.singletone;

public class SingletoneTest {

    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                Singletone singleton = Singletone.getInstance();
                System.out.println("Instance Hash Code: " + System.identityHashCode(singleton));
            }).start();
        }

        for(int i=0; i<5; i++){
            new Thread(
                    () -> {
                        SIngletoneAtomic singleton = SIngletoneAtomic.getInstance();
                        System.out.println("Instance Hash Code atomic: " + System.identityHashCode(singleton));
                    } ).start();
        }
    }
}
