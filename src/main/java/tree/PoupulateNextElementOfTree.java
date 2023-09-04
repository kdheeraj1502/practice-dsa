package tree;


import java.util.*;

public class PoupulateNextElementOfTree {
    public static void populateNext(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Map<Integer, Integer> result = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        for(int i = 1; i < list.size(); i++){
            result.put(list.get(i - 1), list.get(i));
        }
        result.put(list.get(list.size() - 1), -1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(8);
        node.right = new TreeNode(12);
        node.left.left = new TreeNode(3);

        populateNext(node);
    }
}
