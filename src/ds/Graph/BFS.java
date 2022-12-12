package ds.Graph;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
public class BFS {
    // undirected graph
    static class Graph {
        int v;
        LinkedList<Integer>[] g;
        String[] color;
        int[] dist;
        int[] predeccesor;
        Graph(int v) {
            this.v = v;
            this.g = new LinkedList[v];
            this.color = new String[v];
            this.predeccesor= new int[v];
            this.dist=new int[v];
            for (int i = 0; i < v; i++) {
                g[i] = new LinkedList<Integer>();
                color[i] = "white";
                predeccesor[i]=-1;
                dist[i]=0;
            }
        }
        void addEdge(int i, int j) {
            g[i].add(j);
            g[j].add(i);
        }
        void deleteEdge(int i, int j) {
            g[i].remove(j);
            g[j].remove(i);
        }
        void printGraph(Graph graph) {
            for (int i = 0; i < graph.g.length; i++) {
                System.out.println("\nVertex " + i + ":");
                for (int j = 0; j < g[i].size(); j++) {
                    System.out.print(" -> " + g[i].get(j));
                }
            }
        }
        void BFS(int source) {
            Queue<Integer> queue = new ArrayDeque();
            queue.add(source);
            color[source] = "grey";
            dist[source] = 0;
            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (int i : g[u]) {
                    if (color[i] == "white") {
                        color[i] = "grey";
                        predeccesor[i] = u;
                        dist[i] = dist[u] + 1;
                        queue.add(i);
                    }
                }
                color[u] = "black";
            }
        }
    }
    public static void main(String args[]) {
        int vertices=7;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
       // graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(2, 4);
        graph.printGraph(graph);
        graph.BFS(0);
        System.out.println();
        for(int i=0;i<vertices;i++)
        {
            System.out.println("Vertex "+i+" has "+ graph.dist[i] +" distance from source 0");
            System.out.println( "the predecssor of "+i+" is"+graph.predeccesor[i]);
        }
    }
}
