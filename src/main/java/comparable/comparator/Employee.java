package comparable.comparator;

public class Employee implements Comparable<Employee>{

    public int id;
    public String name;
    public int age;
    public String project;

    @Override
    public int compareTo(Employee o) {
        return 0;
    }
}
