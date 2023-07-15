import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) {
        Dog dog = new Dog(10, 20);
        Cat cat = new Cat(10, 20);
        //serialization
        try {
            FileOutputStream fos = new FileOutputStream("abc.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dog);
            oos.writeObject(cat);
            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Dog dog1 = null;
        Cat cat1 = null;
        //deserialize
        try {
            FileInputStream fis = new FileInputStream("abc.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object o = ois.readObject();
            if(o instanceof Dog){
                dog1 = (Dog) o;
                System.out.println(dog.a + "-----------" + dog1.a);
                System.out.println(dog.b + "-----------" + dog1.b);
            }
             if(o instanceof  Cat){
                cat1 = (Cat) o;
                 System.out.println(cat.a + "-----------" + cat1.a);
                 System.out.println(cat.b + "-----------" + cat1.b);
            }
            ois.close();
            fis.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}


class Dog implements Serializable{
    int a ;
    transient int b ;

    public Dog(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
}

class Cat implements Serializable{
    int a ;
    int b ;

    public Cat(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
}
