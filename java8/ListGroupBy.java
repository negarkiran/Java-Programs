package java8;

import model.Item;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListGroupBy {

    public static void main(String[] args) {

        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        //Item Count
        Map<String,Long> itemCount = items.stream().collect(
                Collectors.groupingBy(Item::getName,Collectors.counting()));

        System.out.println(itemCount);

        //Sum of Quantity of each type
        Map<String,Integer> qualtityCount = items.stream().collect(
                Collectors.groupingBy(Item::getName,Collectors.summingInt(Item::getQty)));

        System.out.println(qualtityCount);

        //Group by Price
        Map<BigDecimal,List<Item>> groupByPrice = items.stream().collect(Collectors.groupingBy(Item::getPrice));
        System.out.println(groupByPrice);

        //Group by Price, uses 'mapping' to convert List<Item> to Set<String
        Map<BigDecimal,Set<String>> groupAndMapToSet  = items.stream().collect(
                Collectors.groupingBy(Item::getPrice,Collectors.mapping(Item::getName,Collectors.toSet())));
        System.out.println(groupAndMapToSet);
    }
}
