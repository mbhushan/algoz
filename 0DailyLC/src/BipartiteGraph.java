import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public static void main(String [] args) {
        BipartiteGraph bg = new BipartiteGraph();
        int [][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(bg.isBipartite(graph));

    }

    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length < 1) return false;
        int len = graph.length;
        int [] color = new int[len];
        // 0 = no color, 1 = red, -1 = green
        for (int i=0; i<len; i++) {
            if (color[i] != 0) continue;
            Queue<Integer> Q = new LinkedList<>();
            Q.offer(i);
            color[i] = 1; //red

            while (!Q.isEmpty()) {
                int cur = Q.poll();
                for (int next: graph[cur]) {
                    if (color[next] == 0) { // no color yet
                        color[next] = -color[cur];
                        Q.offer(next);
                    } else if (color[next] != -color[cur]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartiteDFS(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {              //This graph might be a disconnected graph. So check each unvisited node.
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int next : graph[node]) {
            if (!validColor(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }
}
