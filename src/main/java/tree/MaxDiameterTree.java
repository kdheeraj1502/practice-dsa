package tree;

public class MaxDiameterTree {

    public static int maxDiameter(TreeNode node){
        if(node == null) return 0;
        int left = height(node.left);
        int maxDia = maxDiameter(node.left);
        return Math.max(left + 1, maxDia);
    }

    private static int height(TreeNode root){
        return root != null ? 1 + height(root.left) : 0;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(11);
        node.left.right.right.right = new TreeNode(12);
        node.left.right.right.right.right = new TreeNode(13);

        node.right.right = new TreeNode(7);

        node.left.left.left = new TreeNode(8);
        node.left.left.right = new TreeNode(9);

        node.left.left.left.left = new TreeNode(10);

        System.out.println(diameter(node));
    }

    static int ans = 0;
    static int diameter(TreeNode root) {
        rec(root);
        return ans;
    }

    static int rec(TreeNode root) {

        if(root == null) return 0;
        int left = rec(root.left);
        int right = rec(root.right);
        ans = Math.max(ans, 1 + left + right);
        return 1 + Math.max(left, right);
    }
}
