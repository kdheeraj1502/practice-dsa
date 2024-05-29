package stackAndQueue;

public class QueueUsingLinkedList {

    Node head ;
    Node back;
    int size;
    QueueUsingLinkedList(){
        this.size = 0;
        head = null;
        back = null;
    }

    public void add(int val){
        Node tempNode = new Node(val);

        Node curr = head;
        if(curr==null){
            head = tempNode;
            back = tempNode;

        } else {
            back.next = tempNode;
            back = tempNode;
        }

        size++;
    }

    public int remove(){
        if(head==null){
            System.out.println("queue is empty");
            System.exit(1);
        }
        Node temp = head;
        head = head.next;
        size--;
        return temp.data;
    }

    public int peek(){
        if(head==null){
            System.out.println("queue is empty");
            System.exit(1);
        }
        return head.data;
    }

    public static void main(String[] args)

    {
        QueueUsingLinkedList Q=new QueueUsingLinkedList();
        Q.add(10);
        Q.add(20);
        Q.add(30);
        Q.add(40);
        Q.add(50);
        System.out.println("The size of the Queue is "+Q.size);
        Q.remove();
        System.out.println("The size of the Queue is "+Q.size);
        System.out.println("The Peek element of the Queue is "+Q.peek());
    }
}
