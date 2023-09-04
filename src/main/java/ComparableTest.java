import String.immutable.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ComparableTest{


    public static void main(String[] args) {

        List<Employee> emp = new ArrayList<>();

        emp.add(new Employee("test"));
        emp.add(new Employee("puja"));
        emp.add(new Employee("auja"));

        List<Employee> sortedList = emp.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());

        Optional.of(sortedList).ifPresent(n-> n.forEach(System.out::println));
    }
}
