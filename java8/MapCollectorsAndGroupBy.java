package java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapCollectorsAndGroupBy {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple","banana","orange","apple","banana","apple","pappaya");

        //Grouping
        Map<String,Long> groups = fruits.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(groups);

        //Sorting
        Map<String,Long> finalMap = new LinkedHashMap<>();
        groups.entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed()).forEachOrdered(e->finalMap.put(e.getKey(),e.getValue()));

        System.out.println(finalMap);
    }
}
