package tree;

public class MaxPathSum {
    public static int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        maxPathSum(root, max);
        return max[0];
    }

    public static int maxPathSum(TreeNode root, int [] max) {
        if(root == null) return 0;
        int left = Math.max(0, maxPathSum(root.left, max));
        int right = Math.max(0, maxPathSum(root.right, max));
        max[0] = Math.max(max[0], left + right + root.val);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left  = new TreeNode(-1);
        System.out.println(maxPathSum(node));
    }
}
