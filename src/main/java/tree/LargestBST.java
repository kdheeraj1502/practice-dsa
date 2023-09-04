package tree;

public class LargestBST {

    static NodeInfo largestBST(TreeNode root) {
        if (root == null) {
            return new NodeInfo(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        NodeInfo left = largestBST(root.left);
        NodeInfo right = largestBST(root.right);
        NodeInfo returnInfo = new NodeInfo();
        returnInfo.min = Math.min(left.min, root.val);
        returnInfo.max = Math.max(right.max, root.val);
        returnInfo.isBST = left.isBST && right.isBST && root.val > left.max && root.val < right.min;
        if (returnInfo.isBST)
            returnInfo.size = left.size + right.size + 1;
        else
            returnInfo.size = Math.max(left.size, right.size);
        return returnInfo;
    }

    static int largestBst(TreeNode root) {
        return largestBST(root).size;
    }

    public static void main(String[] args) {
        final TreeNode node1 = new TreeNode(60);
        node1.left = new TreeNode(65);
        node1.right = new TreeNode(70);
        node1.left.left = new TreeNode(50);
        System.out.print("Size of the largest BST is " + largestBst(node1));
    }

  //  static int MAX = Integer.MAX_VALUE;
   // static int MIN = Integer.MIN_VALUE;

    static class NodeInfo {
        int size;
        int max;
        int min;
        boolean isBST;

        NodeInfo() {
        }

        NodeInfo(int size, int max, int min, boolean isBST) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }
}