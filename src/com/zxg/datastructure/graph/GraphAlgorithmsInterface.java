package com.zxg.datastructure.graph;

import java.util.Queue;
import java.util.Stack;

public interface GraphAlgorithmsInterface<T> {
    /*
     * Task 执行图的深度优先遍历
     * @param origin 标识遍历的起点对象
     * @return 遍历的顶点标识队列,起点的标记位于队列前端
     */
    public Queue<T> getDepthFirstTraversal(T origin);

    /**
     * Task 执行图的广度优先遍历
     * @param origin
     * @return
     */
    public Queue<T> getBreadthFirstTraversal(T origin);

    /*
     * Task 执行有向无环图的顶点的后拓扑排序
     * @return 由栈顶开始按拓扑有序排列的顶点标识栈
     */
    public Stack<T> getTopologicalSort();
}
