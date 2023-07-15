package tree;

public class SubTreeOfAnotherTree {
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (root.val == subRoot.val)
            if(isIdentical(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        else if (root == null || subRoot == null || root.val != subRoot.val) return false;
        if (!isIdentical(root.left, subRoot.left)) return false;
        if (!isIdentical(root.right, subRoot.right)) return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(1);


        TreeNode subRoot = new TreeNode(1);

        System.out.println(isSubtree(node, subRoot));
    }
}
