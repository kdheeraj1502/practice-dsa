package tree;

public class ValidateBST {
    private static long minVal = Long.MIN_VALUE;
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;

        if (minVal >= root.val) return false;

        minVal = root.val;

        if (!isValidBST(root.right)) return false;

        return true;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
      //  node.right.left = new TreeNode(3);
      //  node.right.right = new TreeNode(6);
  //      System.out.println(isValidBST(node));
        System.out.println("-----------------------------------");
     //   TreeNode node1 = new TreeNode(2147483647);
        System.out.println(isValidBST(node, Long.MIN_VALUE, Long.MAX_VALUE));
    }

    public static boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
