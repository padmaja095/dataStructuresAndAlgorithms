package ds.Graph;

import java.util.ArrayList;

public class RepresentationUsingAdjacencyList {
    // directed graph
    static void addEdge(ArrayList<ArrayList<Integer>> adjList, int i, int j) {
        adjList.get(i).add(j);
    }
    static void printGraph(ArrayList<ArrayList<Integer>> adjList) {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println("\nVertex " + i + ":");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(" -> " + adjList.get(i).get(j));
            }
        }
    }
    public static void main(String args[]) {
        int numVertices = 5;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(numVertices);
        for (int i = 0; i < numVertices; i++)
            adjList.add(new ArrayList<Integer>());
        // Add edges
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 0, 3);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 3, 4);
        addEdge(adjList, 4, 1);
        printGraph(adjList);
    }
}
