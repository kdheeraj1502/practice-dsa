package linkedlist;

import java.util.*;

public class FlattenLinkedList {


   static class MyComparator implements Comparator<Node>{
        public int compare(Node a, Node b) {
            if (a.data < b.data)
                return -1;
            else if (a.data > b.data)
                return 1;
            else
                return 0;
        }
    }

    static NodeFlatten flatten(NodeFlatten root) {
        PriorityQueue<NodeFlatten> pq = new PriorityQueue<>((o1, o2) -> o1.data - o2.data);
        NodeFlatten current = root;
        while (current != null) {
            pq.add(current);
            current = current.next;
        }

        NodeFlatten head = null, tail = null;

        while (!pq.isEmpty()) {
            NodeFlatten temp = pq.poll();
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.bottom = temp;
                tail = temp;
            }

            if (temp.bottom != null) {
                pq.add(temp.bottom);
            }
        }

        return head;
    }

   static NodeFlatten flatten1(NodeFlatten root)
    {
        List<Integer> list = new ArrayList<>();
        NodeFlatten curr = root;
        while(curr != null) {
            NodeFlatten temp = curr;
            while(temp != null) {
                list.add(temp.data);
                temp = temp.bottom;
            }
            curr = curr.next;
        }
        Collections.sort(list);
        NodeFlatten result = new NodeFlatten(-1);
        curr = result;
        for(int in : list) {
            curr.bottom = new NodeFlatten(in);
            curr = curr.bottom;
        }
        return result.bottom;
    }

    public static void main(String[] args) {
        NodeFlatten node = new NodeFlatten(5);

        node.bottom = new NodeFlatten(7);
        node.bottom.bottom = new NodeFlatten(8);
        node.bottom.bottom.bottom = new NodeFlatten(30);

        node.next = new NodeFlatten(10);
        node.next.bottom = new NodeFlatten(20);

        node.next.next = new NodeFlatten(19);
        node.next.next.bottom = new NodeFlatten(22);
        node.next.next.bottom.bottom = new NodeFlatten(50);

        node.next.next.next = new NodeFlatten(28);
        node.next.next.next.bottom = new NodeFlatten(35);
        node.next.next.next.bottom.bottom = new NodeFlatten(40);
        node.next.next.next.bottom.bottom.bottom = new NodeFlatten(45);

        NodeFlatten result = flatten(node);
        System.out.println(result);
    }
}


