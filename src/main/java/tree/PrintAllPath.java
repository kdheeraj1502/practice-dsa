package tree;

import java.util.Stack;

public class PrintAllPath {
    static boolean isleafnode(TreeNode root) {
        return root.left == null && root.right == null;
    }

    static class Pair {
        TreeNode node;
        String path;

        public Pair(TreeNode node, String path) {
            this.node = node;
            this.path = new String(path);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "node=" + node +
                    ", path='" + path + '\'' +
                    '}';
        }
    }

    static void printRootToLeaf(TreeNode root) {
        if (root == null)
            return;
        String path = "";
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, path));
        while (!stack.isEmpty()) {
            Pair it = stack.pop();
            root = it.node;
            path = it.path;
            String curr = (root.val) + " ";
            path += curr;
            if (isleafnode(root))
                System.out.println(path);
            if (root.right != null)
                stack.push(new Pair(root.right, path));
            if (root.left != null)
                stack.push(new Pair(root.left, path));
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        printRootToLeaf(node);
    }
}
