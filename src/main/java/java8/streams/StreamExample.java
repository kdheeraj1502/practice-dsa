package java8.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("59-385-1088","Zacharias","Schwerin","zchwerin@gmail.com","Male","True",101146,0, 32),
                new Employee("73-274-6476","Kyle","Frudd","kfrudd1@ovh.net","Male","FALSE",29310,2, 30),
                new Employee("85-939-9584","Axe","Gumb","agumb2@twitter.com","Female","FALSE",62291,4, 25),
                new Employee("08-180-8292","Robinet","Batterham","rbatterham3@last.fm","Male","FALSE",142439,4, 28),
                new Employee("21-825-2623","Ulick","Burrel","uburrel4@google.ru","Male","FALSE",128764,5, 40),
                new Employee("66-708-5539","Tailor","Ridding","Ridding","Female","FALSE",152924,4, 22),
                new Employee("81-697-2363","Joete","Braybrooke","jbraybrooke6@prnewswire.com","Male","TRUE",128907,0, 45),
                new Employee("63-019-1110","Elroy","Baverstock","ebaverstock7@ehow.com","Male","TRUE",2510,0, 21)
        );

       Optional<Employee> ans = employees.parallelStream().filter(e -> e.getFirstName().equalsIgnoreCase("Kyle")).findAny();

//        //Filter Method - filter employee who as gender as MALE
//         employees.stream()
//                .filter(employee -> employee.getGender().equalsIgnoreCase("Male"))
//                .forEach(System.out::println);

//        // sort the employee list bu rating Asc
//        employees.stream()
//                .sorted(Comparator.comparing(Employee::getRating))
//                .forEach(System.out::println);

//        //sort the employee list by both rating and salary
//        employees.stream()
//                .sorted(Comparator.comparing(Employee::getRating))
//                .sorted(Comparator.comparing(Employee::getSalary))
//                .forEach(System.out::println);
//        //Find the first employee
//        employees.stream()
//                .findFirst().ifPresent(System.out::println);
        //group all employees by gender
//        Map<String, List<Employee>> eployeesByGender = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getGender));
//
//        eployeesByGender.forEach((g, e)->{
//            System.out.println(g);
//            e.forEach(System.out::println);
//        });

        //Given a list of integers, write a Java 8 Stream program to find the sum of all even numbers in the list.
        List<Integer> numbers =Arrays.asList(1,2,7, 8,9,6,3);
        int sum = numbers.stream().filter(n-> n%2==0).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        //Given a list of numbers, write a Java 8 Stream program to find the second largest number in the list.

        int secondLargestNumber = numbers.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().orElse(-1);
        System.out.println("second largest number is :" + secondLargestNumber);

        //Given a list of integers, write a Java 8 Stream program to find the average of all the numbers in the list.

        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("avergae is " + average);

        //Given a list of integers, write a Java 8 Stream program to find the product of all numbers in the list.
        long product = numbers.stream().reduce(1, (n ,m)-> n*m);
        System.out.println("the product of all number is :" + product);
        //Given a list of strings, write a Java 8 Stream program to count the number of strings that contain the letter 'a' in the list.
        List<String> str = Arrays.asList("John", "Vincent", "Erwan");
        long count = str.stream().filter(s -> s.contains("a")).count();
        System.out.println(count);

        //Given a list of strings, write a Java 8 Stream program to find the shortest string in the list.
        String shortestString = str.stream().min(Comparator.comparing(String::length)).get();
        System.out.println("shortest String is:" + shortestString);

        //Given a list of strings, write a Java 8 Stream program to find the longest string in the list.
        String longestStr = str.stream().max(Comparator.comparing(String::length)).get();
        System.out.println("longest String is:" + longestStr);

        //Given a list of strings, write a Java 8 Stream program to find the number of strings that have more than 5 characters.
        long strGreaterThanFive = str.stream().filter( n -> n.length()>5).count();
        System.out.println("string count greater than five :" + strGreaterThanFive);

        //Given a list of Person objects (each Person object has a name and age), write a Java 8 Stream program to find the oldest person in the list.
        List<Person> persons = Arrays.asList(new Person("Emilie", 30), new Person("Benoit", 32), new Person("Alexandre", 23));
        Person person = persons.stream().max(Comparator.comparingInt(Person::getAge)).get();

        System.out.println(person);

        //Given a list of Employee objects (each Employee object has a name, age, and salary), write a Java 8 Stream program to find the total salary of all employees over the age of 30
        long totalSalary = employees.stream().filter(e -> e.getAge()>30).mapToInt(Employee::getSalary).sum();
        System.out.println("total salary of emplyee whose age > 30 : " + totalSalary);
    }


}
