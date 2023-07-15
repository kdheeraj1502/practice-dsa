package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxMinGrouping {

    public static void main(String[] args) {
        int max = Stream.of(1, 6, 8, 3, 1, 0, 9, 4).max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(max);

        List<Student> studentList = Arrays.asList(new Student(1, "Suresh", "M", 43),
                new Student(2, "Shivani", "F", 33),
                new Student(3, "Geeta", "F", 25),
                new Student(4, "Namrata", "F", 19),
                new Student(5, "Rahul", "M", 22));

        Map<String,Long> result = studentList.stream()
                .filter(a -> a.name.startsWith("S"))
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        System.out.println(result);
    }
}

class Student {
    int id;
    String name;
    String gender;
    int age;

    public Student(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
