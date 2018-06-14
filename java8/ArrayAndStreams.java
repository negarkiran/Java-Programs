package java8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayAndStreams {
    public static void main(String[] args) {
        String[] array = {"a","b","d","e","c"};

        //Arrays.stream
        Stream<String> stringStream = Arrays.stream(array);
        stringStream.forEach(System.out::println);

        Stream<String> stringStream1 = Stream.of(array);
        stringStream1.forEach(x-> System.out.println(x));


        //primitive arrays
        int[] intArray = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(intArray);
        intStream.forEach(x-> System.out.println(x));

        Stream<int[]> temp = Stream.of(intArray);

        //Can't print Stream<int[]> directly, convert / flat  it to IntStream
        IntStream intArrayStream = temp.flatMapToInt(x->Arrays.stream(x));
        intArrayStream.forEach(System.out::println);
     }
}
