package linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MirrorTree {
    static void mirror(Node node) {
        mirrorOfNode(node);
    }

   static Node mirrorOfNode(Node node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) {
            return node;
        }
        Node left = node.left != null ? mirrorOfNode(node.left) : null;
        Node right = node.right != null ? mirrorOfNode(node.right) : null;
        node.left = right;
        node.right = left;
        return node;
    }

    public static void display(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        List<Integer> result = new ArrayList<>();
        result.add(node.data);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left != null){
                int val = temp.left.data;
                queue.add(temp.left);
                result.add(val);
            }
            if(temp.right != null){
                int val = temp.right.data;
                queue.add(temp.right);
                result.add(val);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        mirror(node);
        display(node);

    }
}

class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
