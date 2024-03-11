package linkedlist;

public class RemoveNode {
    public static ListNode removeNodes(ListNode head) {
        ListNode curr = head;
        ListNode max = null;
        ListNode prev = curr;
        return removeNodes(curr.next, prev, max);
    }

    public static ListNode removeNodes(ListNode curr, ListNode prev, ListNode max) {
        if (curr == null) {
            return null;
        }
        max = removeNodes(curr.next, prev.next, max);
        if (max == null) {
            max = curr;
        }
        if (prev.val < max.val) {
            return max;
        } else {
            prev.next = max;
            return prev;
        }
    }

    public static void display(ListNode head) {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.val + ", ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        node.next = new ListNode(2);
        node.next.next = new ListNode(13);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(8);
        ListNode removed = removeNodes(node);
        display(removed);
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
