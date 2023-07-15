package java8;

import java.util.*;
import java.util.stream.Collectors;

public class SortingMap {
    public static void main(String[] args) {
        Map<Name, Integer> map = new HashMap<>();
        Name name0 = Name.builder().firstName("Zendor").lastName("Sonawane").build();
        Name name1 = Name.builder().firstName("Niraj").lastName("Sonawane").build();
        Name name2 = Name.builder().firstName("Pratik").lastName("Sonawane").build();
        Name name3 = Name.builder().firstName("Jeetesh").lastName("Sonawane").build();
        Name name4 = Name.builder().firstName("Rahul").lastName("Sonawane").build();
        Name name5 = Name.builder().firstName("Amit").lastName("Sonawane").build();
        map.put(name0,55);
        map.put(name1,1);
        map.put(name2,2);
        map.put(name3,3);
        map.put(name4,4);
        map.put(name5,5);

        Map<Name, Integer> result = map.entrySet().stream().
                sorted(Map.Entry.comparingByKey(Comparator.comparing(Name::getFirstName).reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldval, newVal) -> oldval, LinkedHashMap::new));
      //  Collections.sort();
       List<Name>  resultList = map.entrySet().stream().map(m -> m.getKey()).
               sorted(Comparator.comparing(Name::getFirstName).reversed())
               .collect(Collectors.toList());
        System.out.println(resultList);
      //          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldval, newVal) -> oldval, LinkedHashMap::new));
 //       System.out.println("Before sorting " + map);
        System.out.println("After Sorting " + result);
     //   System.out.println("Revrse Sorting " + reverse);
    }
}
class Name {
    private  String firstName;
    private String lastName;

    public  String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    private Name(Builder userBuilder){
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private String firstName;
        private String lastName;


        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Name build(){
            Name name = new Name(this);
            return name;
        }
    }
}
