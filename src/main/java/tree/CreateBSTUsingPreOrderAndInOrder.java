package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CreateBSTUsingPreOrderAndInOrder {
    static int index = 0;

    public static TreeNode bstFromPreorder(int[] preorder) {
        int[] preorder_new =  Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(preorder);
        int[] inorder = preorder;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return createTree(preorder_new, inorder, 0, preorder.length - 1, map);
    }

    public static TreeNode createTree(int[] preorder, int [] inOrder, int start, int end, Map<Integer, Integer> map) {
        if(start > end) return null;
        TreeNode node = new TreeNode(preorder[index++]);
        if(start == end) return node;
        int mid = map.get(node.val);
        node.left = createTree(preorder, inOrder, start, mid - 1, map);
        node.right = createTree(preorder, inOrder,mid + 1, end, map);
        return node;
    }


    public static void main(String[] args) {
        int preorder [] = { 8,5,1,7,10,12 };

        TreeNode result = bstFromPreorder(preorder);
        Display.print(result);
    }
}
