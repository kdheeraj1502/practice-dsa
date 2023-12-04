
import java.util.*;

public class Test3 {

    public static void main(String[] args) {



        Employee e1 = new Employee("puja" , 1000);
        Employee e2 = new Employee("puja1" , 10000);
        Employee e3 = new Employee("puja3" , 4000);
        Employee e4 = new Employee("puja4" , 40000);
        Employee e5 = new Employee("puja5" , 20000);
        Employee e6 = new Employee("puja6" , 30000);
        List<Employee> employeeList = Arrays.asList(e1,e2,e3,e4,e5,e6);


        Optional<Employee> employee = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(2).findFirst();

        System.out.println(employee.get());

        boolean ans = (3*0.1 == 0.3);
        System.out.println(ans);


    }
}

class Employee {

    String name ;
    int salary;

    Employee(String name , int salary){
        this.name = name;
        this.salary = salary;
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
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
