package com.zxg.datastructure.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Vertex<T> implements VertexInterface<T> {
    private T label;
    private boolean visited;
    private List<Edge> edgeList;
    private int cost;

    public Vertex(T label) {
        this.label = label;
        visited = false;
        edgeList = new ArrayList<Edge>();
        cost = 0;
    }


    @Override
    public T getLabel() {
        return label;
    }

    @Override
    public void visit() {
        visited = true;
    }

    @Override
    public void unVisit() {
        visited = false;
    }

    @Override
    public boolean isVisit() {
        return visited;
    }

    @Override
    public boolean connect(VertexInterface<T> endVertex, double edgeWegiht) {
        //连接的实质是将endVertex组装为Edge放入Vertex的Edge列表中
        if (this.equals(endVertex)) {
            return false;
        }
        if (!hasEdge(endVertex.getLabel())) {
            edgeList.add(new Edge(endVertex, edgeWegiht));
            return true;
        }
        return false;
    }

    @Override
    public boolean connect(VertexInterface<T> endVertex) {
        return connect(endVertex, 0);
    }


    @Override
    public Iterator<VertexInterface<T>> getNeighborIterator() {
        return new NeighborIterator();
    }

    @Override
    public boolean hasEdge(T label) {
        Iterator<VertexInterface<T>> edgeVertexIterator = getNeighborIterator();
        while (edgeVertexIterator.hasNext()) {
            if (edgeVertexIterator.next().getLabel().equals(label)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getEdgeSize() {
        return edgeList.size();
    }

    @Override
    public VertexInterface<T> getUnvisitedNeighbor() {
        Iterator<VertexInterface<T>> edgeVertexIterator = getNeighborIterator();
        while (edgeVertexIterator.hasNext()) {
            VertexInterface<T> vertex = edgeVertexIterator.next();
            if (!vertex.isVisit()) {
                return vertex;
            }
        }
        return null;
    }

    class NeighborIterator implements Iterator<VertexInterface<T>> {

        Iterator<Edge> edgeIterator;

        private NeighborIterator() {
            edgeIterator = edgeList.iterator();
        }

        @Override
        public boolean hasNext() {
            if (edgeIterator != null) {
                return edgeIterator.hasNext();
            }
            return false;
        }

        @Override
        public VertexInterface<T> next() {
            if (edgeIterator.hasNext()) {
                return edgeIterator.next().endVertex;
            } else {
                throw new NoSuchElementException();
            }
        }
    }


    protected class Edge {
        private VertexInterface<T> endVertex;
        private double weight;

        public Edge(VertexInterface<T> endVertex, double weight) {
            this.endVertex = endVertex;
            this.weight = weight;
        }


        public VertexInterface<T> getEndVertex() {
            return endVertex;
        }

        public void setEndVertex(VertexInterface<T> endVertex) {
            this.endVertex = endVertex;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
