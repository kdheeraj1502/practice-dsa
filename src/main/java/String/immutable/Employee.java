package String.immutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Employee {
    public Employee(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }

    //    private final int id;
//
//    private final List<String> phonenumbers;
//
//    private final Map<String, String> metadata;
//
//    private final Address address;
//
//    public Employee(String name, int id, List<String> phonenumbers, Map<String, String> metadata, Address address) {
//        this.name = name;
//        this.id = id;
//        this.phonenumbers = phonenumbers;
//        this.metadata = metadata;
//        this.address = address;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public List<String> getPhonenumbers() {
//        return new ArrayList<>(phonenumbers);
//    }
//
//    public Map<String, String> getMetadata() {
//        return new HashMap<>(metadata);
//    }
//
//    public Address getAddress() throws CloneNotSupportedException {
//        return (Address) address.clone();
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "name='" + name + '\'' +
//                ", id=" + id +
//                ", phonenumbers=" + phonenumbers +
//                ", metadata=" + metadata +
//                ", address=" + address +
//                '}';
//    }
}
