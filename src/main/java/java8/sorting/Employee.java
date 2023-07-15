package java8.sorting;

import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    public int id;
    public String name;
    public int salary;

    Employee( int id, String name, int salary){
        this.id= id;
        this.name = name;
        this.salary = salary;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        Employee e0 = new Employee(100, "Dheeraj", 2000);
        Employee e1 = new Employee(101, "Dheeraj", 1000);
        Employee e2 = new Employee(102, "Dinesh", 1050);
        Employee e3 = new Employee(103, "Ajay", 1300);

        List<Employee> employeeList = Arrays.asList(e1, e0, e2, e3);
        Comparator<Employee> bySalary = (o1, o2) -> o1.salary - o2.salary;
        Comparator<Employee> byName = (o1, o2) -> o1.name.compareTo(o2.name);
        List<Employee> result =  employeeList.stream().sorted(bySalary).sorted(byName).collect(Collectors.toList());
        List<Employee> output =  employeeList.stream().sorted(Comparator.comparingInt(Employee::getSalary)).collect(Collectors.toList());
        System.out.println("output " + output);



        Map<Employee, Integer> map = new HashMap<>();
        map.put(e0,1);
        map.put(e2,2);
        map.put(e3,3);
        map.put(e1,4);
        Comparator<Map.Entry<Employee, Integer>> bySalaryMap = (o1, o2) -> o1.getKey().salary - o2.getKey().salary;
        Map<Employee, Integer> mapResult = map.entrySet().stream().sorted(bySalaryMap).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
               (o1, o2) -> o1, LinkedHashMap::new));
        System.out.println("mapResult " + mapResult);
    }

}
