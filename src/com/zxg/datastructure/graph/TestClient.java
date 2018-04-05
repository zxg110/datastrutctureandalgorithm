package com.zxg.datastructure.graph;

import java.util.Queue;

public class TestClient {
    public static GraphInterface graph;

    public static void main(String[] args) {
        buildGraph();
    }

    public static void buildGraph() {
        graph = new DirectedGraph<String>();
        System.out.println("add vertex.........");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        System.out.println("add edge");
        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "D", 2);
        graph.addEdge("B", "C", 3);
        graph.addEdge("B", "E", 3);
        graph.addEdge("D", "C", 2);
        graph.addEdge("E", "D", 4);
        graph.addEdge("E", "C", 2);
        System.out.println("graph vertex size:" + graph.getNumberOfVertices());
        System.out.println("graph edge size:" + graph.getNumberOfEdges());
        System.out.println("graph Breadth ----------");
        Queue<String> resultQueue = graph.getBreadthFirstTraversal("A");
        while (resultQueue.peek() != null) {
            System.out.printf(resultQueue.poll() + " ");
        }
        System.out.println("graph DepthFirstTraversal ----------");
        resultQueue.clear();
        resultQueue = graph.getDepthFirstTraversal("A");
        while (resultQueue.peek() != null) {
            System.out.printf(resultQueue.poll() + " ");
        }
    }


}
