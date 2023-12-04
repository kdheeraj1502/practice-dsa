package Maersk;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {

    public static void main(String[] args) {
        List<? super Number> list = new ArrayList<>();
        list.add(2);
        list.add(2.0);
        list.add(2L);
        //list.add(new Object())
    }
}

class ab extends Number{

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
