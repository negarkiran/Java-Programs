package java8;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamReuse {
    public static void main(String[] args) {
        String[] array = {"a","b","c","d","e"};

        Supplier<Stream<String>> streamSupplier = ()->Stream.of(array);

        //get new Stream
        streamSupplier.get().forEach(System.out::print);

        System.out.println(streamSupplier.get().filter(x->"b".equals(x)).count());
    }
}
