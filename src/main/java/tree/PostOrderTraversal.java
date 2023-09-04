package tree;

import java.util.*;

public class PostOrderTraversal {

   static ArrayList<Integer> postOrder(TreeNode node) {
        ArrayList <Integer> list = new ArrayList<>();
        Stack <TreeNode> st1 = new Stack<>();
        Stack <TreeNode> st2 = new Stack<>();
        if(node==null){
            return list;
        }

        st1.push(node);
        while(!st1.isEmpty()){
            TreeNode temp = st1.pop();
          st2.push(temp);

            if(temp.left!=null){
                st1.push(temp.left);
            }
            if(temp.right!=null){
                st1.push(temp.right);
            }

        }
        while(!st2.isEmpty()){
            list.add(st2.pop().val);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        System.out.println(postOrder(node));
    }
}
