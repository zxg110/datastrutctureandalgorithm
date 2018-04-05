package com.zxg.datastructure.graph;

import java.util.Iterator;

/**
 * 邻接表顶点
 * @param <T>
 */
public interface VertexInterface<T> {
    /**
     * 获取顶点标示
     * @return
     */
    public T getLabel();

    public void visit();

    public void unVisit();

    public boolean isVisit();

    public boolean connect(VertexInterface<T> endVertex,double edgeWegiht);

    public boolean connect(VertexInterface<T> endVertex);

    public Iterator<VertexInterface<T>> getNeighborIterator();

    public boolean hasEdge(T label);

    public int getEdgeSize();

    public VertexInterface<T> getUnvisitedNeighbor();





}
