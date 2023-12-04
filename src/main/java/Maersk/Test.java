package Maersk;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(

                new Item("apple", 10, new BigDecimal("9.99")),

                new Item("banana", 20, new BigDecimal("19.99")),

                new Item("orang", 10, new BigDecimal("29.99")),

                new Item("watermelon", 10, new BigDecimal("29.99")),

                new Item("papaya", 20, new BigDecimal("9.99")),

                new Item("apple", 10, new BigDecimal("9.99")),

                new Item("banana", 10, new BigDecimal("19.99")),

                new Item("apple", 20, new BigDecimal("9.99"))

        );

        Map<String, Integer> ans = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
        ans.forEach((k, v) -> System.out.println(k + " " + v));

    }
}
class Item {

    private String name;

    private int qty;

    private BigDecimal price;

    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
