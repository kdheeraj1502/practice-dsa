package DesginPattern.creational.abstractFactory.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<String, Dress> dressMap;

    Registry(){
        dressMap = new HashMap<>();
        initialize();
    }

    private void initialize() {
        Dress tshirt=new Tshirt();
        dressMap.put("Tshirt", tshirt);

        Dress denim = new Denim();
        dressMap.put("denim", denim);

    }

    public Dress clone(String dressType) throws CloneNotSupportedException{

        return (Dress) dressMap.get(dressType).clone();
    }
}
