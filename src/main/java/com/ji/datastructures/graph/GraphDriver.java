package com.ji.datastructures.graph;

public class GraphDriver {
    public static void main(String[] args) {
        // Undirected Graph //
        GraphAL graph = new GraphAL(8);
        graph.addEdge(0,1);
        graph.addEdge(1,0);
        graph.addEdge(1,4);
        graph.addEdge(4,1);
        graph.addEdge(4,6);
        graph.addEdge(6,4);
        graph.addEdge(6,0);
        graph.addEdge(0,6);
        graph.addEdge(1,5);
        graph.addEdge(5,1);
        graph.addEdge(5,3);
        graph.addEdge(3,5);
        graph.addEdge(3,0);
        graph.addEdge(0,3);
        graph.addEdge(5,2);
        graph.addEdge(2,5);
        graph.addEdge(2,7);
        graph.addEdge(7,2);

        System.out.println("display graph : "+ graph.toString());
        System.out.println("bfs below : ");
        System.out.println(graph.bfsTraversal(0));
        System.out.println("dfs below : ");
        System.out.println(graph.dfsTraversal(0));

    }
}
