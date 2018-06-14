package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by khegde050916 on 4/17/2018.
 */
public class FilterAndCollect {
    public static void main(String[] args) {
        List<String> lines = Arrays.asList("hello","mister","bing");

        //Filter out Bing from List
        List<String> result = lines.stream()
                .filter(line->!"bing".equals(line))
                .collect(Collectors.toList());

        //Print each item using foreach
        result.forEach(System.out::println);
    }
}
