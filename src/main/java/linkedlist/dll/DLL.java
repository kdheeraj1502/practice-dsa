package linkedlist.dll;

public class DLL {

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(5);
        doublyLinkedList.insertFirst(6);
        doublyLinkedList.insertFirst(7);
        doublyLinkedList.insertFirst(8);
        doublyLinkedList.insertFirst(9);

        doublyLinkedList.insertLast(10);
        doublyLinkedList.insertLast(20);
        doublyLinkedList.display();
        doublyLinkedList.displayRev();

    }
}
