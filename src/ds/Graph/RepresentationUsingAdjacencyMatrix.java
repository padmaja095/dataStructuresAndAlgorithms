package ds.Graph;

public class RepresentationUsingAdjacencyMatrix {
    // undirected Graph-> so setting A[i,j] && A[j,i]=1
    static class Graph {
        int[][] adjmatrix;
        int nVertices;
        Graph(int n) {
            this.adjmatrix = new int[n][n];
            this.nVertices = n;
        }
        public void addEdge(int i, int j) {
            adjmatrix[i][j] = 1;
            adjmatrix[j][i] = 1;
        }

        public void deleteEdge(int i, int j) {
            adjmatrix[i][j] = 0;
            adjmatrix[j][i] = 0;
        }

        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < nVertices; i++) {
                for (int j = 0; j < nVertices; j++) {
                    s.append(adjmatrix[i][j]+" ");
                }
                s.append("\n");
            }
            return s.toString();
        }
    }
    public static void main(String args[])
    {
        Graph graph= new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        System.out.print(graph.toString());
    }
}
