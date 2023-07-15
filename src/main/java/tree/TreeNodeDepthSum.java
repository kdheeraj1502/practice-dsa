package tree;

import java.util.*;

class TreeNodeDepthSum {

    public static int nodeDepths(BinaryTree root) {
        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(root, 0));
        int sumOfDepth = 0;
        while(stack.size() > 0){
            Pair temp = stack.pop();
            BinaryTree node = temp.node;
            int depth = temp.depth;
            if(node == null) continue;
            sumOfDepth += depth;
            stack.push(new Pair(node.left, depth+ 1));
            stack.push(new Pair(node.right, depth+ 1));
        }
        return sumOfDepth;
    }

    static class Pair {
        public BinaryTree node;
        public int depth;
        public Pair(BinaryTree node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        @Override
        public String toString() {
            return value + "";
        }

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new TreeNodeDepthSum.BinaryTree(1);
        root.left = new TreeNodeDepthSum.BinaryTree(2);
        root.left.left = new TreeNodeDepthSum.BinaryTree(4);
        root.left.left.left = new TreeNodeDepthSum.BinaryTree(8);
        root.left.left.right = new TreeNodeDepthSum.BinaryTree(9);
        root.left.right = new TreeNodeDepthSum.BinaryTree(5);
        root.right = new TreeNodeDepthSum.BinaryTree(3);
        root.right.left = new TreeNodeDepthSum.BinaryTree(6);
        root.right.right = new TreeNodeDepthSum.BinaryTree(7);

        System.out.println(nodeDepths(root));
    }
}



