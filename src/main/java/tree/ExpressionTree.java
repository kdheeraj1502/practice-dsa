package tree;

import java.util.*;

public class ExpressionTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    public static int evaluateExpressionTree(BinaryTree tree) {
        if(tree.value >= 0) return tree.value;
        int left = evaluateExpressionTree(tree.left);
        int right = evaluateExpressionTree(tree.right);
        if(tree.value == -1){
            return left + right;
        }
        if(tree.value == -2){
            return left - right;
        }
        if(tree.value == -3){
            return left/right;
        }
        return left*right;
    }

    public static void main(String[] args) {
        ExpressionTree.BinaryTree tree = new ExpressionTree.BinaryTree(-1);
        tree.left = new ExpressionTree.BinaryTree(2);
        tree.right = new ExpressionTree.BinaryTree(-2);
        tree.right.left = new ExpressionTree.BinaryTree(5);
        tree.right.right = new ExpressionTree.BinaryTree(1);

        System.out.println(evaluateExpressionTree(tree));
    }
}

