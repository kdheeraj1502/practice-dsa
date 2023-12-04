package linkedlist;

public class RightRotateLL {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next= new Node(5);

        int k = 2 ;

        Node curr = rotateRight(node , k);
        while(curr!=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    private static Node rotateRight(Node head, int k) {

        Node curr = head;
        int len =1 ;

        while(curr.next!=null){
            len++;
            curr = curr.next;
        }

        curr.next = head;
        k = len -(k%len);
        while(k>0){
            curr = curr.next;
            k--;
        }

        head = curr.next;
        curr.next = null;

        return head;



    }

    static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

}
