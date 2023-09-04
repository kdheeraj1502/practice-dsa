package linkedlist;

public class ReverseDoublyLinkedList {

    public static DoubelNode reversegroupByK(DoubelNode head, int k){
        if(head == null) return null;
        DoubelNode prev = null;
        DoubelNode next = null;
        int count = 0;
        DoubelNode current = head;
        while (current != null && count < k){
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
            count++;
        }
        head.next = reversegroupByK(next, k);
        if (head.next != null) {
            head.next.prev = head;
        }
        prev.prev = null;
        return prev;
    }

    private static DoubelNode reversNode(DoubelNode current, int k){
        DoubelNode prev = null;
        DoubelNode next = null;
        int count = 0;
        while (current != null && count < k){
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
            count++;
        }
        return prev;
    }


    public static void main(String[] args) {
        DoubelNode node = new DoubelNode(1);
        node.next = new DoubelNode(2);
        node.next.prev = node;

        node.next.next = new DoubelNode(3);
        node.next.next.prev = node.next;

        node.next.next.next = new DoubelNode(4);
        node.next.next.next.prev = node.next.next;

        node.next.next.next.next = new DoubelNode(5);
        node.next.next.next.next.prev = node.next.next.next;

        node.next.next.next.next.next = new DoubelNode(6);
        node.next.next.next.next.next.prev = node.next.next.next.next;

        node.next.next.next.next.next.next = new DoubelNode(7);
        node.next.next.next.next.next.next.prev = node.next.next.next.next;

        node.next.next.next.next.next.next.next = new DoubelNode(8);
        node.next.next.next.next.next.next.next.prev = node.next.next.next.next.next;

        DoubelNode result = reversegroupByK(node, 3);
        display(result);

    }

    public static void display(DoubelNode result){
        while(result != null){
            System.out.println("The data is :" + result.data);
            result = result.next;
        }
    }
}

class DoubelNode {
    public int data;
    public DoubelNode next;
    public DoubelNode prev;

    public DoubelNode(){}

   public DoubelNode(int data){
        this.data = data;
        next = prev= null;
   }
}