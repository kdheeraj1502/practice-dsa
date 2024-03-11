package linkedlist;

public class ReorderList {
    private boolean isStop;
    private ListNode1 temp;
    public void reorderList(ListNode1 head) {
        temp = head;
        isStop = false;
        rec(head);
    }

    public void rec(ListNode1 head) {
        if(head == null) return;
        reorderList(head.next);
        if(!isStop) {
            ListNode1 next = temp.next;
            temp.next = head;
            head.next = next;
            temp = next;
        }
        if(temp != null && temp.next == head) {
            temp.next = null;
            isStop = true;
        }
    }

    public static void main(String[] args) {
        ListNode1 node = new ListNode1(1);
        node.next = new ListNode1(2);
        node.next.next = new ListNode1(3);
        node.next.next.next = new ListNode1(4);
        node.next.next.next.next = new ListNode1(5);
        ReorderList rl = new ReorderList();
        rl.reorderList(node);
        System.out.println(node.toString());
    }
}

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}



