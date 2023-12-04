package linkedlist.dll;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void insertFirst(int data){

        Node temp = new Node(data);
        temp.next = head;
        temp.prev = null;

        if(head!=null){
            head.prev = temp;
        }
        head = temp;
        if(tail == null){
            tail = head;
        }

    }

    public void insertLast(int data){

        if(tail==null){
            insertFirst(data);
            return;
        }
        Node node = new Node(data);
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public void display(){
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        System.out.println(" ");
    }

    public void displayRev() {
        Node node = tail;
        System.out.println();
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.prev;

        }
        System.out.println(" ");
    }
}

class Node {
    int data ;
    Node next ;
    Node prev;

    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
