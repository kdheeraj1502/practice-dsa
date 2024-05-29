package DesginPattern.creational.abstractFactory.objectpool;

public class EmailClient {

    private final Integer id;

    public EmailClient(int id){
        System.out.println("Creating New Email Client with ID: "+id);
        this.id=id;
    }

    public Integer getId() {
        return id;
    }
}