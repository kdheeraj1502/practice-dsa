package linkedlist.LL;

public class LL {

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        linkedList.insert(5);
        linkedList.insert(6);
        linkedList.insert(10);
        linkedList.insertAfter(5 , 4);
        linkedList.display();

        linkedList.delete(10);

        System.out.println("after deleting ");
         linkedList.display();
    }
}
