package algorithms_2.practice_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private static final int inf = Integer.MAX_VALUE;
    private int n;
    private int[] parent;
    private int[] distance;
    private color[] colors;

    public BFS(int[][] G) {
        this.n = G.length;
        this.parent = new int[n];
        this.distance = new int[n];
        this.colors = new color[n];
    }

    public void bfs(int[][] G, int s) {
        for(int i = 1; i < n; i++) {
            parent[G[i][0]] = -1;
            distance[G[i][0]] = inf;
            colors[G[i][0]] = color.WHITE;
        }

        distance[s] = 0;
        colors[s] = color.GREY;

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()) {
            int u = q.poll();
            for(int v : G[u]) {
                if(colors[v] == color.WHITE) {
                    colors[v] = color.GREY;
                    distance[v] = distance[u] + 1;
                    parent[v] = u;
                    q.add(v);
                }
            }
            colors[u] = color.BLACK;
        }
    }

    /**
     * this function get a graph (represents as a matrix when the first column is the nodes and near each node his neighbors)
     * also the this function get a s and v node (get the path from s to v)
     * @param G
     * @param s
     * @param e
     * @return
     */
    public static int[] get_path_bfs(int[][] G, int s, int e) {

        // |V|
        int n = G.length;

        int[] parents = new int[n];
        int[] distance = new int[n];
        color[] colors = new color[n];

        for(int i = 1; i < n; i++) {
            int node = G[i][0];
            parents[node] = -1;
            distance[node] = 0;
            colors[node] = color.WHITE;
        }

        distance[s] = 0;
        colors[s] = color.GREY;

        Queue<Integer> q = new LinkedList();
        q.add(s);
        while(!q.isEmpty()) {
            int u = q.poll();
            for(int v : G[u]) {
                if(colors[v] == color.WHITE) {
                    colors[v] = color.GREY;
                    distance[v] = distance[u] + 1;
                    parents[v] = u;
                    q.add(v);
                }
            }
            colors[u] = color.BLACK;
        }

        ArrayList<Integer> reversed_path = new ArrayList<>();
        int[] empty_path = new int[0];
        int t = e;
        while(t != s) {
            reversed_path.add(t);
            t = parents[t];
            if(t == -1) {
                return empty_path;
            }
        }

        reversed_path.add(s);

        // fill path
        int[] path = new int[reversed_path.size()];
        for(int i = 0; i < path.length; i++) {
            path[i] = reversed_path.get(path.length - 1 - i);
        }

        return path;
    }

    public static boolean is_connected(int[][] G) {

        // |V|
        int n = G.length;

        int[] parents = new int[n];
        int[] distance = new int[n];
        color[] colors = new color[n];

        for(int i = 1; i < n; i++) {
            int node = G[i][0];
            parents[node] = -1;
            distance[node] = 0;
            colors[node] = color.WHITE;
        }

        distance[0] = 0;
        colors[0] = color.GREY;

        Queue<Integer> q = new LinkedList();
        q.add(0);
        while(!q.isEmpty()) {
            int u = q.poll();
            for(int v : G[u]) {
                if(colors[v] == color.WHITE) {
                    colors[v] = color.GREY;
                    distance[v] = distance[u] + 1;
                    parents[v] = u;
                    q.add(v);
                }
            }
            colors[u] = color.BLACK;
        }

        // checking if the graph is connected

        // check color option
        for(int i = 0; i < n; i++) { if(colors[i] != color.BLACK) { return false; } }

        // check infinity distance option
        for(int i = 0; i < n; i++) { if(distance[i] == inf) { return false; } }

        // check if there more than one null in parent list option
        int count_null = 0;
        for(int i = 0; i < n; i++) { if(parents[i] == -1) { count_null++; } }
        if(count_null > 1) { return false; }

        return true;
    }

//    public static int connected_components() {}

    /**
     * casting a boolean graph matrix to integer matrix
     * for example this boolean graph matrix:
     *      {
     *          {false,false,false,false,true,true,false},
     *          {false,false,true,false,false,false,true},
     *          {false,true,false,true,false,false,false},
     *          {false,false,true,false,false,false,true},
     *          {true,false,false,false,false,true,false},
     *          {true,false,false,false,true,false,false},
     *          {false,true,false,true,false,false,false}
     *      };
     *
     * in visual:
     *
     *          V4
     *          /\
     *         /  \
     *        /____\
     *       V0     V5
     *      V6------V3
     *       |     |
     * 	     |_____|
     *      V1     V2
     *
     * will be:
     *
     *      {
     *          {0,4,5},
     *          {1,2,6},
     *          {2,1,3},
     *          {3,2,6},
     *          {4,0,5},
     *          {5,0,4},
     *          {6,1,3}
     *      };
     *
     * @param graph
     * @return
     */

    public static int[][] cast_graph_matrix_to_nodes_matrix(boolean[][] graph) {
        int n = graph.length;
        int m = graph[0].length;

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // fill first column
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            matrix.add(temp);
        }


        // fill rest of matrix
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j]) {
                    matrix.get(i).add(j);
                }
            }
        }

        int[][] return_graph = new int[n][];

        for(int i = 0; i < n; i++) {

            int temp_size = matrix.get(i).size();
            int[] row = new int[temp_size];

            for(int j = 0; j < temp_size; j++) {
                row[j] = matrix.get(i).get(j);
            }
            return_graph[i] = row;
        }

        return return_graph;
    }

    private static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 3, 4},
                {1, 0, 2, 4, 5},
                {2, 1, 3, 5},
                {3, 0, 2, 4},
                {4, 0, 1, 3, 5},
                {5, 1, 2, 4}
        };

        int[] path = get_path_bfs(mat, 1,3);
        System.out.println("path is: " + Arrays.toString(path));

        boolean[][] bool_mat = {
                {false,false,false,false,true,true,false},
                {false,false,true,false,false,false,true},
                {false,true,false,true,false,false,false},
                {false,false,true,false,false,false,true},
                {true,false,false,false,false,true,false},
                {true,false,false,false,true,false,false},
                {false,true,false,true,false,false,false}
        };

        printMatrix(cast_graph_matrix_to_nodes_matrix(bool_mat));
    }

}