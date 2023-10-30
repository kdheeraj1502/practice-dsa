package String;

import java.util.ArrayList;
import java.util.Objects;

public class StringTest {

    public static void main(String[] args) {
        String s1 = new String("puja");
        String s2 = "puja";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        Employee e1 = new Employee(100);
        Employee e2 = new Employee(100);
        System.out.println("----------------------------");
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
        System.out.println(e1 == e2);
        System.out.println(e1.equals(e2));

    }


}

class Employee{
    private int id;


    Employee(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
