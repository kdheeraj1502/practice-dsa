package array;

import java.util.*;

public class Data  implements Comparable<Data>{

    int number;

    public Data(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(Data o) {
        return -1;
    }
}

class Test {
    public static void main(String[] args) {
        Data d1= new Data(1);
        Data d2 = new Data(2);
        Data d3 = new Data(3);

        List<Data> list = Arrays.asList(d1, d2, d3);
        Comparator<Data> comparator = (o1, o2) -> o2.number - o1.number;
        Collections.sort(list, comparator.reversed());
        int i1 = list.get(0).number;
        int i2 = list.get(1).number;
        int i3 = list.get(2).number;
        System.out.println(i1 + "" + i2 + "" + i3);

    }
}
