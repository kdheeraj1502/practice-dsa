package tree;

public class BSTContainsDeadEND {
    public static boolean isDeadEnd(TreeNode root)
    {
        return isDeadEnd(root, 1, Integer.MAX_VALUE);
    }
    public static boolean isDeadEnd(TreeNode root, int min, int max)
    {
        if(root == null) return false;
        if(min == max) return true;
        return isDeadEnd(root.left, min, root.val - 1) ||
                isDeadEnd(root.right, root.val + 1, max);
    }

    public static void main(String[] args) {

    }
}
