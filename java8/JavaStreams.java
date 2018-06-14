package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams {
    public static void main(String args[]){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        System.out.println(list.stream().filter(i->i%2==0).collect(Collectors.toList()));
    }
}
