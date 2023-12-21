package g2.q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Graph {
    int V;
    List<Edge> edges;

    public Graph(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, double weight) {
        edges.add(new Edge(src, dest, weight));
    }

    public List<Edge> kruskalMST() {
        // Sort edges by weight in ascending order
        Collections.sort(edges);

        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        List<Edge> mst = new ArrayList<>();

        int edgeCount = 0;
        int index = 0;
        while (edgeCount < V - 1 && index < edges.size()) {
            Edge edge = edges.get(index++);
            int srcParent = find(parent, edge.src);
            int destParent = find(parent, edge.dest);

            if (srcParent != destParent) {
                mst.add(edge);
                union(parent, srcParent, destParent);
                edgeCount++;
            }
        }

        return mst;
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    private void union(int[] parent, int x, int y) {
        int xParent = find(parent, x);
        int yParent = find(parent, y);
        parent[xParent] = yParent;
    }
}