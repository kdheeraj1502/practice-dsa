package tree;

import java.util.*;

public class CheckIsHeap {
    static boolean isHeap(TreeNode tree) {
        int val = Integer.MAX_VALUE;
        return isComplete(tree) && isHeapUtil(tree, val);
    }

    static boolean isHeapUtil(TreeNode tree, int parentval) {
        if(tree == null) return true;
        if(parentval < tree.val) return false;
        return isHeapUtil(tree.left, tree.val) && isHeapUtil(tree.right, tree.val);
    }

    static boolean isComplete(TreeNode tree){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        boolean noChild = false;
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp != null){
                if(temp.left != null){
                    if(noChild){
                        return false;
                    }
                    queue.add(temp.left);
                } else{
                    noChild = true;
                }
                if(temp.right != null){
                    if(noChild){
                        return false;
                    }
                    queue.add(temp.right);
                } else{
                    noChild = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        System.out.println(isHeap(node));
    }
}
