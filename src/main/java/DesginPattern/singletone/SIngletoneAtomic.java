package DesginPattern.singletone;

import java.util.concurrent.atomic.AtomicReference;

public class SIngletoneAtomic{

    private static AtomicReference<SIngletoneAtomic> INSTANCE = new AtomicReference<>();

    private SIngletoneAtomic(){}

    public static SIngletoneAtomic getInstance(){
        INSTANCE.compareAndSet(null, new SIngletoneAtomic());
        return INSTANCE.get();
    }

}
