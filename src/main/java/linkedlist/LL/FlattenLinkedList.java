package linkedlist.LL;

import java.util.*;

public class FlattenLinkedList {

    static class Node {
        int data;
       Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    static Node flatten(Node root) {
        Node curr = root;
        List<Integer> list = new ArrayList<>();
        while(curr.next != null){
            Node temp = curr;
            while(temp.bottom != null){
                list.add(temp.data);
                temp = temp.bottom;
            }
            list.add(temp.data);
            curr = curr.next;
        }
        if(curr != null){
            Node temp = curr;
            while(temp.bottom != null){
                list.add(temp.data);
                temp = temp.bottom;
            }
            list.add(temp.data);
            curr = curr.next;
        }
        Collections.sort(list);
        Node result = new Node(-1);
        curr = result;
        for(Integer in : list){
            curr.next = new Node(in);
            curr = curr.next;
        }
        return result.next;
    }

    static void print(Node node){
        while(node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        FlattenLinkedList.Node node = new Node(5);
        node.bottom = new Node(7);
        node.bottom.bottom = new Node(8);
        node.bottom.bottom.bottom = new Node(30);

        node.next = new Node(10);
        node.next.bottom = new Node(20);

        node.next.next = new Node(19);
        node.next.next.bottom = new Node(22);
        node.next.next.bottom.bottom = new Node(50);

        node.next.next.next = new Node(28);
        node.next.next.next.bottom = new Node(35);
        node.next.next.next.bottom.bottom = new Node(40);
        node.next.next.next.bottom.bottom.bottom = new Node(45);

       Node result = flatten(node);
       print(result);
    }

}

