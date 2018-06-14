package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Java8Sorting {
    public static void main(String args[]){
        String[] names = {"one","second","three","four","five","six"};

        List<Employee> employees = new ArrayList<>();

        sortStrings(names);
        System.out.println();
        sortStringsBasedOnLength(names);

        sortEmployeesBasedOnHireDate(employees);

        multiple_sort(employees);
    }

    private static void multiple_sort(List<Employee> employees) {
        Comparator<Employee> byFirstName = (o1,o2)->o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
        Comparator<Employee> byLastName = (o1,o2)->o1.getLastName().compareToIgnoreCase(o2.getLastName());

        employees.parallelStream().sorted(byFirstName.thenComparing(byLastName))
        .forEach(employee -> System.out.println("Employee:"+employee));
    }

    private static void sortEmployeesBasedOnHireDate(List<Employee> employees) {
        employees.parallelStream().sorted((o1,o2)->o1.getHireDate().compareTo(o2.getHireDate()))
                .forEach(employee -> System.out.println("Employee:"+employee));


        employees.parallelStream().sorted(Comparator.comparing(Employee::getHireDate))
                .forEach(employee ->System.out.println("Employee:"+employee) );
    }

    private static void sortStringsBasedOnLength(String[] names) {
        Stream.of(names).sorted((o1,o2)->Integer.compare(o1.length(),o2.length())).forEach(System.out::println);
    }

    private static void sortStrings(String[] names) {
        Stream.of(names).sorted(String::compareToIgnoreCase).forEach(System.out::println);
    }
}
