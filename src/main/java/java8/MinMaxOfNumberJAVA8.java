package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class MinMaxOfNumberJAVA8 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 4, 10, 12, 87, 33, 75);
        int num = numbers.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Max number " + num);
        int min = numbers.stream().min(Comparator.comparingInt(Integer::valueOf)).get();
        System.out.println("min number " + min);
        List<Employee> EmployeeAge = Arrays.asList(new Employee(28),
                new Employee(20),
                new Employee(24), new Employee(46), new Employee(18));

        Employee minEmpAge = EmployeeAge.stream().min(Comparator.comparing(Employee::getAge)).get();
        System.out.println("MinEmpAge " + minEmpAge.getAge());
    }
}

class Employee {
    public int age;
    Employee(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
