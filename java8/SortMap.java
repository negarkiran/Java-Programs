package java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMap {
    public static void main(String[] args) {

        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        System.out.println("Original Map");
        System.out.println(unsortMap);

        //sort by Keys
        //toMap returns HashMap, need to convert it to LinkedHashMap to keep the order
        // (oldValue,newValue)->oldValue is used to avoid duplicates
        Map<String,Integer> result = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
                        (oldValue,newValue)->oldValue,LinkedHashMap::new));


        //Not Recommended, but works
        Map<String,Integer> result1 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x->result1.put(x.getKey(),x.getValue()));


        System.out.println("Sorted Map by Key");
        System.out.println(result);
        System.out.println(result1);


        //Sort by Values in reverse order
        Map<String,Integer> result2 = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
                        (oldValue,newValue)->oldValue,LinkedHashMap::new));
        System.out.println("Sorted Map by Value");
        System.out.println(result2);

        //Alternate Way
        // Can use Comparator.comparingLong().reversed() also in place of Map.Entry
        Map<String,Integer> result3 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .forEachOrdered(x->result3.put(x.getKey(),x.getValue()));
        System.out.println("Sorted Map by Value");
        System.out.println(result3);
    }
}
