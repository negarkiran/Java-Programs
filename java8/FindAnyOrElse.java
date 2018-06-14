package java8;

import model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by khegde050916 on 4/17/2018.
 */
public class FindAnyOrElse {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("bing",30),
                new Person("bong",32),
                new Person("been",31));

        Person p1 = persons.stream()
                .filter(person -> person.getName().equals("biqng"))
                .findAny()
                .orElse(null);
        System.out.println(p1);

        Person p2 = persons.stream()
                .filter(person -> person.getName().equals("bing") && person.getAge()>25)
                .findAny()
                .orElse(null);
        System.out.println(p2);



       String name = persons.stream()
               .filter(person->person.getName().equals("bing"))
               .map(Person::getName)
               .findAny()
               .orElse("");
        System.out.println("My Name:"+name);

        List<String> names = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        names.forEach(System.out::println);
    }
}
