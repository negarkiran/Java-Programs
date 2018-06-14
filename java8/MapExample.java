package java8;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by khegde050916 on 1/28/2018.
 */
public class MapExample {
    public static void main(String[] args) {
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("one",null);
        stringMap.put("two","Two");
        stringMap.put("one","One");

        stringMap.compute("one",(k,v)-> v==null ?"new":"old");

        stringMap.forEach((k,v)-> System.out.println(k+"->"+v));
    }
}
