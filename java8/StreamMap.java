package java8;

import model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        List<String> alpha = Arrays.asList("a","b","c","d");

        //Uppercase all the strings in the list
        List<String> upperCase = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCase);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> squares = numbers.stream().map(n->n*2).collect(Collectors.toList());
        System.out.println(squares);

        List<Person> persons = Arrays.asList(
                new Person("bing",30),
                new Person("bong",32),
                new Person("been",31));

        List<String> names = persons.stream().map(Person::getName).collect(Collectors.toList());
        System.out.print(names);
    }
}
