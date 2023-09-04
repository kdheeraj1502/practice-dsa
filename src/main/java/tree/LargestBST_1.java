package tree;

public class LargestBST_1 {

    static int maxBST = 0;

    public static int largest(TreeNode node) {
         largestFind(node);
         return maxBST;
    }

    public static NodeInfo largestFind(TreeNode node) {
        if(node == null) {
            return new NodeInfo(Long.MIN_VALUE, Long.MAX_VALUE, 0);
        }
        NodeInfo leftNode = largestFind(node.left);
        NodeInfo rightNode = largestFind(node.right);
        if(leftNode.max < node.val && node.val < rightNode.min){
            maxBST = Math.max(maxBST, leftNode.size + rightNode.size + 1);
            long max = Math.max(node.val, leftNode.max);
            long min = Math.min(node.val, rightNode.min);
            return new NodeInfo(max, min, leftNode.size + rightNode.size + 1);
        }
        return new NodeInfo(Long.MIN_VALUE, Long.MAX_VALUE, 0);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(4);
        node.right = new TreeNode(4);

        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(8);
        System.out.println(largest(node));
    }
}

class NodeInfo {
    long max;
    long min;
    int size;

    public NodeInfo(long max, long min, int size){
        this.max = max;
        this.min = min;
        this.size = size;
    }
}