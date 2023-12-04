package linkedlist.LL;

public class CustomLinkedList {

    private Node head;
    public CustomLinkedList(){
        this.head = null;
    }


    public void insert(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        } else {
            Node current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = node;
        }

    }
    public void insertAfter(int previous , int newData){
        Node node = new Node(newData);
            Node current = head;
            while(current.next!=null){
                if(current.data == previous) {
                    Node temp = current.next;
                    current.next = node;
                    node.next = temp;
                    break;
                }
                current = current.next;
            }

        }

    public void delete(int data){
        Node curr = head;
        while(curr.next!=null){
            if (curr.next.data == data){
                curr.next = curr.next.next;
                break;
            }

            curr = curr.next;
        }

    }


    public void display(){
        Node node = head;
        while(node!=null){
            System.out.println(node.data);
            node = node.next;
        }
    }
}


class Node {
     int data;
     Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
