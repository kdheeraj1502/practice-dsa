package tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "val = " + val;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(7);

        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);

        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(9);

        print(node);
        System.out.println("========================");
        TreeNode result = invertTree(node);
        print(result);

    }

    public static void print(TreeNode root){
        if(root != null){
            System.out.print(root.val + ", ");
            print(root.left);
            print(root.right);
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;
    }
}