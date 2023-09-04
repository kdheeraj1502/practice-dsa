package java8.stream;

import java.util.Arrays;

public class FindFirstElemts {

    public static void main(String[] args) {
        String Stream[] = {"Geek_First", "Geek_2", "Geek_3", "Geek_4", "Geek_Last"};
        System.out.println(Arrays.stream(Stream).findFirst().get());
    }
}
