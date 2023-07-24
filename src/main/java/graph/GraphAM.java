package graph;

public class GraphAM {
    int count;
    int [][] adj;

    GraphAM(int count){
        this.count = count;
        this.adj = new int[count][count];
    }

    public void addDirectedEdge(int src, int des, int cost){
        this.adj[src][des] = cost;
    }


    public void addUnDirectedEdge(int src, int des, int cost){
        addDirectedEdge(src, des, cost);
        addDirectedEdge(des, src, cost);
    }

    public void print(){
        for(int i = 0; i < adj.length; i++){
            System.out.print("The src of graph is " + i + " and connected with ");
            for(int j = 0; j < adj[i].length; j++){
                if(this.adj[i][j] == 1){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphAM graphAM = new GraphAM(4);
        graphAM.addUnDirectedEdge(0, 1, 1);
        graphAM.addUnDirectedEdge(0, 2, 1);
        graphAM.addUnDirectedEdge(1, 2, 1);
        graphAM.addUnDirectedEdge(2, 3, 1);
        graphAM.print();
    }
}
