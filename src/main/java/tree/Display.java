package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Display {

    public static void print(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        if(node != null)
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp != null){
                System.out.print(temp.val + ", ");
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
    }
}
