package DesginPattern.builder;

public class BuilderPattern {

    public static void main(String[] args) {
        Customer customer = new Customer.CustomerBuilder()
                .setName("Puja Pandey")
                .setPhoneNumber("8551223****")
                .setAddress("Bangalore")
                .setNationality("Proud Indian")
                .build();

        System.out.println(customer);
    }
}
