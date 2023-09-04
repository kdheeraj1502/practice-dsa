package tree;

public class BinaryTreeToDLL {

    TreeNode head, tail = null;


    TreeNode bToDLL(TreeNode root)
    {
        bToDLL(root);
        return head;
    }

    void rec(TreeNode root)
    {
        if(root == null) return;
        rec(root.left);
        if(head == null){
            head = tail = root;
        } else{
            tail.right = root;
            root.left = tail;
            tail = root;
        }
        rec(root.right);
    }

    public void display(TreeNode current) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of generated doubly linked list: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        BinaryTreeToDLL bt = new BinaryTreeToDLL();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode result = bt.bToDLL(root);
        bt.display(result);
    }
}
