package DesginPattern.builder;

//https://medium.com/javarevisited/builder-design-pattern-in-java-for-beginners-9b93d2a15440
public class Customer {

    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String nationality;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    private Customer(CustomerBuilder builder){
        this.address= builder.address;
        this.name= builder.name;
        this.age = builder.age;
        this.phoneNumber = builder.phoneNumber;
        this.nationality = builder.nationality;

    }

    public static class CustomerBuilder {

        private String name;
        private int age;
        private String address;
        private String phoneNumber;
        private String nationality;

        public CustomerBuilder(){}
        public CustomerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder setAge(int age) {
            this.age = age;

            return this;
        }

        public CustomerBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CustomerBuilder setNationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }
}
