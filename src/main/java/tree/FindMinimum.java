package tree;


public class FindMinimum {
   static int minValue(TreeNode node) {
        if(node == null) return -1;
        return findMin(node);
    }
    static int findMin(TreeNode node) {
        if(node == null) return Integer.MAX_VALUE;
        int min = node.val;
        int leftMin = minValue(node.left);
        int rightMin = minValue(node.right);
        return Math.min(min, (Math.min(leftMin, rightMin)));
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(6);

        node.left.left = new TreeNode(3);
        node.left.left.left = new TreeNode(1);

        node.right.right = new TreeNode(7);

        System.out.println(minValue(node));
    }
}
