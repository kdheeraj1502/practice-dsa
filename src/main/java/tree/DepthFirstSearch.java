package tree;

import java.util.*;

public class DepthFirstSearch {
    static class Node {
        static String name;
        static List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public static List<String> depthFirstSearch(List<String> array) {
            array.add(name);
            children.forEach(child -> child.depthFirstSearch(array));
            return  array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch.Node graph = new DepthFirstSearch.Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");
        List<String> inputArray = new ArrayList<>();
        System.out.println(Node.depthFirstSearch(inputArray));
    }
}
