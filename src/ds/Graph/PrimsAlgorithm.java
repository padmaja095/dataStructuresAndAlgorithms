package ds.Graph;

public class PrimsAlgorithm {
    static class Edge{
        Node src;
        Node dest;
        int weight;
        Edge(Node src,Node dest,int weight)
        {
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }
    static class Node{
        int key;
        Node parentNode;
        int nodeVal;
        Node(int nodeval)
        {
            this.nodeVal=nodeval;
            this.key=Integer.MAX_VALUE;
            this.parentNode=null;
        }
    }
    PrimsAlgorithm(int vertex)
    {
        

    }
    
    public static void main(String args[])
    {
        int V=8;
       // PrimsAlgorithm graph= new PrimsAlgorithm(v);

    }
}
