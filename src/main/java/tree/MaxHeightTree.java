package tree;

public class MaxHeightTree {

    public static int maxheight(TreeNode node){
        return node == null ? 0 : Math.max(maxheight(node.left), maxheight(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        node.left.left.left = new TreeNode(8);
        node.left.left.right = new TreeNode(9);

        System.out.println(maxheight(node.right));
    }
}
