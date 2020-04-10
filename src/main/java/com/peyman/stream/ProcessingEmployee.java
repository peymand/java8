package com.peyman.stream;

import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProcessingEmployee {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matthew", "Indigo", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700.77, "Marketing"),
                new Employee("Luke", "Indigo", 6200, "IT"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Wendy", "Brown", 4236.4, "Marketing"),
        };
        List<Employee> list = Arrays.asList(employees);


        System.out.println("Complete Employee list:");
        list.stream().forEach(System.out::println);

        //Predicate that returns true for salaries in the range 4000-6000
        Predicate<Employee> forToSixThousand = e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

        //Display Employees with salaries in the range of 4000-6000
        //sorted into ascending order by salary
        System.out.printf("%nEmployee earning $4000-$6000 per month sorted by salary:%n");
        list.stream().filter(forToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        //display first Employee with salary in the range 4000-6000
        System.out.printf("First employee with salary in the range of 4000-6000:%n%s%n",
                list.stream().filter(forToSixThousand).findFirst().get());

        //Functions for getting first and first and last names from an Employee
        Function<Employee, String> getFirstName = Employee::getFirstName;
        Function<Employee, String> getLastName = e -> e.getLastName();


        //Comparator for comparing Employees last name then first name
        Comparator<Employee> lastThenFirst = Comparator.comparing(getLastName).thenComparing(getFirstName);

        //sort employees by last name, then first name
        list.stream().sorted(lastThenFirst).forEach(System.out::println);

        //sort employees by last name, then first name
        list.stream().sorted(lastThenFirst.reversed()).forEach(System.out::println);

        //display unique employee last names sorted
        list.stream().map(Employee::getLastName).distinct().sorted().forEach(System.out::println);

        //display only first and last name
        list.stream().sorted(lastThenFirst).map(Employee::getName).forEach(System.out::println);

        //group employees by department in Map<String, List<Employee>>
        Map<String, List<Employee>> groupedByDepartment = list.stream().
                collect(Collectors.groupingBy(Employee::getDepartment));
        groupedByDepartment.forEach((dep, empsInDep) -> {
            System.out.println(dep);
            empsInDep.forEach(System.out::println);
        });

        //count number each employees in each department in Map<String, Long>
        Map<String, Long> collect = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));

        //sum of employee salaries with DoubleStream sum method
        double sum = list.stream().mapToDouble(Employee::getSalary).sum();

        //sum of employee salaries with Stream reduce method
        list.stream().mapToDouble(Employee::getSalary).reduce(0,(x, y) -> x + y);

        //average of employee salaries with DoubleStream average method
        list.stream().mapToDouble(Employee::getSalary).average().getAsDouble();

    }
}
