import java.io.*;

public class CustomizedSerialization {

    public static void main(String[] args) {
        Account account = new Account("puja", "dheeraj");

        try{
            FileOutputStream fos = new FileOutputStream("account.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(account);
            oos.close();
            fos.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        Account acc = null;
        try{
            FileInputStream fis = new FileInputStream("account.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            acc = (Account) ois.readObject();
            ois.close();
            fis.close();
        } catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(acc.getName() + "--------" + acc.getPassword());
    }
}

class Account implements Serializable{

    private String name;
    transient private String password;

    Account(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    private void writeObject(ObjectOutputStream oos) throws Exception{
        oos.defaultWriteObject();
        String pwd = "123"+ password;
        oos.writeObject(pwd);
    }

    private void readObject(ObjectInputStream ois) throws Exception{
        ois.defaultReadObject();
        String pwd = (String) ois.readObject();
        password = pwd.substring(3);
    }
}
