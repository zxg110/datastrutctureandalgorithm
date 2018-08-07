package com.zxg.algorithm;
import java.util.*;

public class AlgorithmPractice_14 {

    /**
     * 节点数据结构
     */
    class Vertex {
        String label;
        //该节点拥有的边
        List<Edge> edges;
        //该节点是否被访问
        boolean isVisit = false;
        //该节点所有边对应的End节点
        List<Vertex> endVertex;
        int edgesIndex = 0;

        public void addEdge(Edge edge) {
            if (edge == null) {
                return;
            }
            if (edges == null) {
                edges = new ArrayList<>();
            }
            edges.add(edge);
        }

        public void visit() {
            this.isVisit = true;
        }

        public void unVisit() {
            this.isVisit = false;
        }

        public List<Vertex> getAllEndVertex() {
            if (edges == null)
                return null;
            if (endVertex == null) {
                endVertex = new ArrayList<>();
                for (Edge e : edges) {
                    endVertex.add(e.endV);
                }
            }
            return endVertex;
        }

        public Edge getNextUnVisitEdge() {
            if (edges == null || edgesIndex >= edges.size())
                return null;
            Edge currentE = edges.get(edgesIndex);
            edgesIndex++;


            if (!currentE.endV.isVisit) {
                return currentE;
            }
            return null;
        }

        public void resetEgdeIndex() {
            edgesIndex = 0;
        }

        public Vertex(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "label:" + label + "\n";
        }
    }

    /**
     * 边数据结构
     */
    class Edge {
        Vertex endV;
        int weight;

        public Edge(int weight, Vertex endV) {
            this.endV = endV;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "weight:" + weight + ",endV:" + endV.toString();
        }
    }

    public int maxRoute(String[] date) {
        int maxRoute = 0;
        Map<String, Vertex> vertexMap = convertToVertex(date);
        //以每一个节点为起始路径进行遍历
        for (String label : vertexMap.keySet()) {
            int tempMaxRoute = 0;
            //该栈用于记录当前遍历路径节点
            Stack<Vertex> stack = new Stack<>();
            //该栈用于记录遍历边的weight路径
            Stack<Integer> weightStack = new Stack<>();
            Vertex currentV = vertexMap.get(label);
            currentV.visit();
            stack.push(currentV);
            while (!stack.isEmpty()) {
                //取出栈顶节点
                Vertex v = stack.peek();
                //获取栈顶节点所有边的End节点
                List<Vertex> endVertex = v.getAllEndVertex();
                if (endVertex != null) {
                    //判断栈中(当前遍历路径)是否有含有当前节点的End节点，若存在，则
                    //存在环，返回-1
                    for (Vertex endV : endVertex) {
                        if (stack.contains(endV)) {
                            return -1;
                        }
                    }
                }
                //取出下一个未访问的边
                Edge edge = v.getNextUnVisitEdge();
                if (edge != null) {
                    //weight增加
                    tempMaxRoute += edge.weight;
                    //weight增加后将该weight放入weight栈中
                    weightStack.push(edge.weight);
                    //标记节点为已访问
                    edge.endV.visit();
                    //访问路径已到达该节点，放入栈中
                    stack.push(edge.endV);
                } else {
                    //如果该节点不存在未访问的边，说明到达最深处
                    //如果栈不为空，说明以某节点为起始的遍历还未结束，向后退后一步
                    //1 weight栈退后(出栈)，并将当前路径累加值回退相应值
                    if (!weightStack.isEmpty()) {
                        tempMaxRoute -= weightStack.pop();
                    }
                    //2 节点栈退后(出栈)，并将该节点设置为未访问。因为有可能另外一条路径会到达该节点
                    //如果不重置为未访问，那么另外一条路径就访问不到该节点
                    Vertex popV = stack.pop();
                    popV.unVisit();
                    //重置该节点取边下标
                    popV.resetEgdeIndex();
                }
                //更新maxRoute
                maxRoute = maxRoute > tempMaxRoute ? maxRoute : tempMaxRoute;
            }


        }
        return maxRoute;
    }

    /**
     * 将字符串转换为图结构
     * @param date
     * @return
     */
    public Map<String, Vertex> convertToVertex(String[] date) {
        Map<String, Vertex> vertexMap = new HashMap<>();
        for (int i = 0; i < date.length; i++) {
            for (int j = 0; j < date[i].length() - 2; j += 2) {
                String vertexLabel = String.valueOf(date[i].charAt(j));
                Vertex v;
                if (!vertexMap.containsKey(vertexLabel)) {
                    v = new Vertex(vertexLabel);
                    vertexMap.put(vertexLabel, v);
                } else {
                    v = vertexMap.get(vertexLabel);
                }
                char weight = date[i].charAt(j + 1);
                Vertex endV;
                String endVLabel = String.valueOf(date[i].charAt(j + 2));
                if (!vertexMap.containsKey(endVLabel)) {
                    endV = new Vertex(endVLabel);
                    vertexMap.put(endVLabel, endV);
                } else {
                    endV = vertexMap.get(endVLabel);
                }
                Edge e = new Edge(weight - '0', endV);
                v.addEdge(e);
            }
        }
        return vertexMap;
    }

    public static void main(String[] args) {
        String[] date = new String[]{"A2B3D", "A4C3E", "A5D", "C3B"};
        AlgorithmPractice_14 algorithm = new AlgorithmPractice_14();
        System.out.println(algorithm.maxRoute(date));
    }
}
