package linkedlist;

import linkedlist.LL.CustomLinkedList;

import java.util.LinkedList;

public class PalindromeLL {
    public static void main(String[] args) {
      Node node = new Node(1);
      node.next = new Node(2);
      node.next.next = new Node(2);
      node.next.next.next = new Node(1);
        System.out.println(isPalindrome(node));

    }

    static boolean isPalindrome(Node head)
    {
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node reverse = reverse(slow);
        Node curr = head;

        Node rev = reverse;
        while(rev!=null){
            if(curr.data != rev.data){
                return false;
            }
            rev = rev.next;
            curr = curr.next;
        }

        reverse(reverse);
        return true;
    }

    static Node reverse(Node slow){

        Node curr = slow;

        Node prev = null;

        while(curr!=null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }

        return prev;
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
