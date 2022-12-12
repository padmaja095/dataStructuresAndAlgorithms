package ds.Graph;

import java.util.LinkedList;
public class DFS {
     // directed graph
     static class Graph {
        int v;
        LinkedList<Integer>[] g;
        String[] color;
        int[] dist;
        int[] predeccesor;
        int[] discoveredTime;
        int[]finishedTime;
        int time;
        Graph(int v) {
            this.v = v;
            this.g = new LinkedList[v];
            this.color = new String[v];
            this.predeccesor= new int[v];
            this.dist=new int[v];
            this.discoveredTime= new int[v];
            this.finishedTime= new int[v];
            for (int i = 0; i < v; i++) {
                g[i] = new LinkedList<Integer>();
                color[i] = "white";
                predeccesor[i]=-1;
                dist[i]=1;
                discoveredTime[i]=Integer.MAX_VALUE;//storing max value
            }
        }
        void addEdge(int i, int j) {
            g[i].add(j);
        }
        void deleteEdge(int i, int j) {
            g[i].remove(j);
        }
        void printGraph(Graph graph) {
            for (int i = 0; i < graph.g.length; i++) {
                System.out.println("\nVertex " + i + ":");
                for (int j = 0; j < g[i].size(); j++) {
                    System.out.print(" -> " + g[i].get(j));
                }
            }
        }
         void dfs() {
    
            color[0]="grey";
            time = 0;
            dist[0]=0;
            for (var i = 0; i < v; i++)
                if (color[i].equals("white"))
                    dfsVisit(i);
        }
         void dfsVisit(int u) {
            System.out.print(u+" ");
            time = time + 1;
            discoveredTime[u]= time;
            color[u]= "grey";
            for (int v : g[u]) {
                if (color[v].equals("white")) {
                    predeccesor[v]= u;
                    dist[v] = dist[u] + 1;
                    dfsVisit(v);
                }
            }
            color[u]= "black";
            time = time + 1;
            finishedTime[u]= time;
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
        graph.addEdge(0, 2);
        graph.printGraph(graph);
        graph.dfs();
        System.out.println();
        for(int i=0;i<vertices;i++)
        {
            System.out.println("Vertex "+i+" has "+ graph.dist[i] +" distance from source 0");
            System.out.println( "the predecssor of "+i+" is"+graph.predeccesor[i]);
            System.out.println("dis "+i+" "+graph.discoveredTime[i]);
            System.out.println("fin "+i+" "+graph.finishedTime[i]);
        } 
    }
}
