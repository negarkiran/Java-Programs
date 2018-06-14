package java8;

import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClassToMap {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Bob",25));
        people.add(new Person("Barry",35));
        people.add(new Person("Bill",26));
        people.add(new Person("Billy",45));

        Map<String,Integer> peopleMap = people.stream().collect(Collectors.toMap(Person::getName,Person::getAge));
        System.out.println(people);
        System.out.println(peopleMap);
    }
}
