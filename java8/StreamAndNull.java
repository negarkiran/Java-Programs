package java8;

import java.util.stream.Stream;

public class StreamAndNull {
    public static void main(String[] args) {
        Stream<String> languages = Stream.of("java", "python", "node", null, "ruby", "java", "php");
       System.out.println(languages.filter(x->"java".equals(x)).count());

       // List<String> languageListWithNull = languages.collect(Collectors.toList());
        //languageListWithNull.forEach(System.out::println);

        //Stream can be used only once, so be sure you create a new stream before using it

      //  List<String> languageListWithoutNull = languages.filter(x->x!=null).collect(Collectors.toList());
       // List<String> languageListWithoutNull = languages.filter(Objects::nonNull).collect(Collectors.toList());
       // languageListWithoutNull.forEach(System.out::println);
    }
}
