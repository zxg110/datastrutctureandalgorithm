package com.zxg.datastructure.graph;

import java.util.*;

public class DirectedGraph<T> implements GraphInterface<T> {
    private Map<T, VertexInterface<T>> vertices;

    public DirectedGraph() {
        vertices = new LinkedHashMap<>();
    }

    @Override
    public void addVertex(T vertexLabel) {
        if (!vertices.containsKey(vertexLabel)) {
            vertices.put(vertexLabel, new Vertex(vertexLabel));
        }
    }

    @Override
    public boolean addEdge(T begin, T end, double edgeWeight) {
        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        if (beginVertex != null && endVertex != null) {
            beginVertex.connect(endVertex, edgeWeight);
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdge(T begin, T end) {
        return addEdge(begin, end, 0);
    }

    @Override
    public boolean hasEdge(T begin, T end) {
        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        if (beginVertex != null && endVertex != null) {
            return beginVertex.hasEdge(end);
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    @Override
    public int getNumberOfVertices() {
        return vertices.size();
    }

    @Override
    public int getNumberOfEdges() {
        int count = 0;
        for (VertexInterface vertex : vertices.values()) {
            count += vertex.getEdgeSize();
        }
        return count;
    }

    @Override
    public void clear() {
        vertices.clear();
    }

    @Override
    public Queue<T> getDepthFirstTraversal(T origin) {

        resetVertexs();
        if(!vertices.containsKey(origin)){
            return null;
        }
        VertexInterface<T> originVertex = vertices.get(origin);
        Stack<VertexInterface<T>> processStack = new Stack<>();
        Queue<T> resultQueue = new LinkedList<>();
        originVertex.visit();
        resultQueue.offer(originVertex.getLabel());
        processStack.push(originVertex);
        while(!processStack.empty()){
            VertexInterface<T> topVertex = processStack.peek();
            VertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();
            if(nextNeighbor != null){
                nextNeighbor.visit();
                resultQueue.offer(nextNeighbor.getLabel());
                processStack.push(nextNeighbor);
            }else {
                processStack.pop();
            }
        }
        return resultQueue;
    }

    @Override
    public Queue<T> getBreadthFirstTraversal(T origin) {
        VertexInterface originVertex = vertices.get(origin);
        if (originVertex == null) {
            return null;
        }
        Queue<VertexInterface<T>> processQueue = new LinkedList<VertexInterface<T>>();
        Queue<T> resultQueue = new LinkedList<T>();

        processQueue.offer(originVertex);
        while (!processQueue.isEmpty()) {
            VertexInterface<T> currentVertex = processQueue.poll();
                currentVertex.visit();
                resultQueue.offer(currentVertex.getLabel());
            Iterator<VertexInterface<T>> vertexIterator = currentVertex.getNeighborIterator();
            while (vertexIterator.hasNext()) {
                VertexInterface<T> vertex = vertexIterator.next();
                if(!vertex.isVisit() && !processQueue.contains(vertex)){
                    processQueue.offer(vertex);
                }
            }
        }
        return resultQueue;
    }

    private void resetVertexs(){
        for(VertexInterface<T> vertex:vertices.values()){
            vertex.unVisit();
        }
    }



    @Override
    public Stack<T> getTopologicalSort() {
        return null;
    }
}
