package tree;

public class FlattenTree {

    static Node prev = null;
    static void flatten(Node  root) {
        if (root == null) return;

        flatten(root . right);
        flatten(root . left);

        root . right = prev;
        root . left = null;
        prev = root;
    }
    public static void main(String args[]) {

        Node  root = new Node(1);
        root . left = new Node(2);
        root . right  = new Node(3);
        flatten(root);
        while(root.right!=null)
        {
            System.out.print(root.val+"->");
            root=root.right;
        }
        System.out.print(root.val);
    }

}


