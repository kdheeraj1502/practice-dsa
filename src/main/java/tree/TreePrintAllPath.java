package tree;

import java.util.*;

public class TreePrintAllPath {

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public static ArrayList<ArrayList<Integer>> paths(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(root, new ArrayList<>()));
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            ArrayList<Integer> path = pair.path;
            path.add(node.val);
            if (isLeaf(node)) {
                result.add(path);
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, new ArrayList<>(path)));
            }
            if (node.left != null) {
                stack.push(new Pair(node.left, new ArrayList<>(path)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        System.out.println(paths(node));
    }
}

class Pair {
    public TreeNode node;
    public ArrayList<Integer> path;

    public Pair(TreeNode node, ArrayList<Integer> path) {
        this.node = node;
        this.path = path;
    }
}