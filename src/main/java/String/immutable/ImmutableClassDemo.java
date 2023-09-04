//package immutable;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ImmutableClassDemo {
//
//    public static void main(String[] args) throws CloneNotSupportedException {
//        List<String> phoneNumbers = new ArrayList<>();
//        phoneNumbers.add("123456");
//        phoneNumbers.add("456789");
//        Map<String, String> metadata = new HashMap<>();
//        metadata.put("hobby", "Watching Movies");
//        Address address = new Address("street 1", "city X");
//        Employee e = new Employee("puja", 17910, phoneNumbers, metadata, address);
//
//        System.out.println(e);
//
//        e.getPhonenumbers().add("000000");
//        e.getMetadata().put("hobby", "dance");
//        e.getAddress().setCity("durgapur");
//        System.out.println(e);
//    }
//}
