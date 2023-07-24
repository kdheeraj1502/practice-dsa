package graph;

import java.util.LinkedList;
import java.util.List;

public class GraphAL {
    int count;
    List<List<Edge>> adj;

    static class Edge {
        private int des;
        private int cost;
        public Edge(int des, int cost) {
            this.des = des;
            this.cost = cost;
        }
    }

    GraphAL(int count){
        this.count = count;
        this.adj = new LinkedList<>();
        for(int i = 0; i < this.count; i++) {
            this.adj.add(new LinkedList<>());
        }
    }

    public void addDirectedEdge(int src, int des, int cost){
        Edge edge = new Edge(des, cost);
        adj.get(src).add(edge);
    }

    public void addUnDirectedEdge(int src, int des, int cost){
        addDirectedEdge(src, des, cost);
        addDirectedEdge(des, src, cost);
    }

    public void print(){
        for(int i = 0; i < adj.size(); i++){
            System.out.print("The src of graph is " + i + " and connected with ");
            for(Edge edge : this.adj.get(i)){
                System.out.print(edge.des + ", the cost is " + edge.cost);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphAL graphAL = new GraphAL(5);
        graphAL.addDirectedEdge(0, 1, 3);
        graphAL.addDirectedEdge(0, 4, 2);
        graphAL.addDirectedEdge(1, 2, 1);
        graphAL.addDirectedEdge(2, 3, 1);
        graphAL.addDirectedEdge(4, 1, -2);
        graphAL.addDirectedEdge(4, 3, 1);
        graphAL.print();
    }

}
