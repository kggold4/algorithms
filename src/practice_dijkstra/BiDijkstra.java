/**
 * Multi-Source Dijkstra algorithm pseudo-code: (written by Kfir Goldfarb)
 * Complexity = O(|E| + |V|*log|V|)
 *
 *  V - list of nodes
 *  Vr - list of nodes in reverse order
 *  neighbor(v) - return list neighbors of v
 *  neighborR(v) - return list neighbors of v (reversed)
 *  weight(v, u) - return the weight between v and u
 *  s - start node
 *  t - end node
 *
 *  biDijkstra():
 *      prev_s[] - save prev nodes
 *      visited_s[] - mark nodes as visited
 *      dist_s[] - save destination of each node from start node
 *      prev_t[] - save prev nodes from reversed order
 *      visited_t[] - mark nodes as visited from reversed order
 *      dist_t[] - save destination of each node from start node from reversed order
 *      n = |V|
 *      for (from i = 0 to n):
 *          prev_s[i] = nil
 *          dist_s[i] = infinity
 *          visited_s[i] = false
 *          prev_t[i] = nil
 *          dist_t[i] = infinity
 *          visited_t[i] = false
 *      *end-for
 *
 *      Q - priority queue
 *      Qr - priority queue (from reversed order)
 *      Q.enqueue(s)
 *      Qr.enqueue(t)
 *      dist_s[s] = 0
 *      dist_t[t] = 0
 *
 *      inProcess = true
 *
 *      while(inProcess):
 *
 *          while(!Q.empty()):
 *              u = Q.dequeue()
 *              for(v in neighbors(u)):
 *                  if(visited_s[v] == false):
 *                      if(dist_s[v] > dist_s[u] + weight(u, v)):
 *                          dist_s[v] = dist_s[u] + weight(u, v)
 *                          pred_s[v] = u
 *                          Q.enqueue(v)
 *                      *end-if
 *                  *end-if
 *              *end-for
 *
 *              visited_s[u] = true
 *              if(visited_s[u] && visited_t[u])
 *                  inProcess = false
*               *end-if
 *          *end-while
 *
 *          while(!Qr.empty()):
 *              u = Qr.dequeue()
 *              for(v in neighbors(u)):
 *                  if(visited_t[v] == false):
 *                      if(dist_t[v] > dist_t[u] + weight(u, v)):
 *                          dist_t[v] = dist_t[u] + weight(u, v)
 *                          pred_t[v] = u
 *                          Qr.enqueue(v)
 *                      *end-if
 *                  *end-if
 *              *end-for
 *
 *              visited_t[u] = true
 *              if(visited_s[u] && visited_t[u])
 *                  inProcess = false
 *              *end-if
 *          *end-while
 *      *end-while
 *
 *      // get min and minIndex
 *      min = infinity
 *      minIndex = -1
 *
 *      for (from i = 0 to n):
 *          if((visited_s[i] || visited_t[i]) && dist_s[i] != infinity && dist_t[i] != infinity):
 *              if(min > dist_s[i] + dist_t[i]):
 *                  min = dist_s[i] + dist_t[i]
 *                  minIndex = i
 *              *end-if
 *          *end-if
 *      *end-for
 *
 *
 *      // build path:
 *
 *      k = e
 *      path = string(k)
 *      while(k != s):
 *          k = pred[k]
 *          path = string(k) + "->" + path
 *      *end-while
 *
 *      return path
 *
 */

package practice_dijkstra;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BiDijkstra {

    private static final int inf = 1000000;

    public static void biDijkstra(ArrayList<ArrayList<Integer>> G, ArrayList<ArrayList<Integer>> Gr,
                                  int s, int t, int[][] weight) {
        int n = G.size();

        int[] prev_s = new int[n];
        int[] dist_s = new int[n];
        boolean[] visited_s = new boolean[n];

        int[] prev_t = new int[n];
        int[] dist_t = new int[n];
        boolean[] visited_t = new boolean[n];

        for(int i = 0; i < n; i++) {
            prev_s[i] = -1;
            dist_s[i] = inf;
            visited_s[i] = false;
            prev_t[i] = -1;
            dist_t[i] = inf;
            visited_t[i] = false;
        }

        boolean inProcess = true;

        PriorityQueue<Integer> Q = new PriorityQueue<Integer>();
        PriorityQueue<Integer> Qr = new PriorityQueue<Integer>();
        dist_s[s] = 0;
        dist_t[t] = 0;
        Q.add(s);
        Qr.add(t);

        while(inProcess) {
            while(!Q.isEmpty()) {

                int u = Q.poll();
                for(int v : G.get(u)) {
                    if(visited_s[v] == false) {
                        if(dist_s[v] > dist_s[u] + weight[u][v]) {
                            dist_s[v] = dist_s[u] + weight[u][v];
                            prev_s[v] = u;
                            Q.add(v);
                        }
                    }
                }
                visited_s[u] = true;
                if(visited_s[u] == true && visited_t[u] == true) {
                    inProcess = false;
                }

            }
            while(!Qr.isEmpty()) {

                int u = Qr.poll();
                for(int v : Gr.get(u)) {
                    if(visited_t[v] == false) {
                        if(dist_t[v] > dist_t[u] + weight[u][v]) {
                            dist_t[v] = dist_t[u] + weight[u][v];
                            prev_t[v] = u;
                            Qr.add(v);
                        }
                    }
                }
                visited_t[u] = true;
                if(visited_t[u] == true && visited_s[u] == true) {
                    inProcess = false;
                }

            }
        }

        int min = inf;
        int minIndex = -1;

        for(int i = 0; i < n; i++) {
            if((visited_s[i] || visited_t[i]) && (dist_s[i] != inf && dist_t[i] != inf)) {
                if(min > dist_s[i] + dist_t[i]) {
                    min = dist_s[i] + dist_t[i];
                    minIndex = i;
                }
            }
        }

        // dist == min
        System.out.println("dist = " + min);

        String path = "";
        String pathR = "";

        int k = minIndex;
        while(prev_s[k] != -1) {
            path = "->" + k + path;
            k = prev_s[k];
        }
        path = k + path;
        System.out.println("path = " + path);

        k = minIndex;
        while(prev_t[k] != -1) {
            pathR = "->" + k + pathR;
            k = prev_t[k];
        }
        pathR = k + pathR;
        System.out.println("pathR = " + pathR);


        String pR[] = pathR.split("->");
        String finalPath = path;
        for(int i = pR.length - 2; i >= 0; i--) {
            finalPath += "->" + pR[i];
        }

        System.out.println("final path: " + finalPath);

    }

    public static void main(String[] args) {
        int[][] mat = {{0 ,1 ,2 ,inf ,inf ,inf ,inf ,inf },
                {1 ,0 ,4 ,inf ,5 ,inf ,inf ,inf },
                {2 ,4 ,0 ,7 ,inf ,3 ,inf ,inf },
                {inf ,inf ,7 ,0 ,3 ,8 ,inf ,inf },
                {inf ,5 ,inf ,3 ,0 ,inf ,1 ,4 },
                {inf ,inf ,3 ,inf ,8 ,0 ,2 ,inf },
                {inf ,inf ,inf ,inf ,1 ,2 ,0 ,5 },
                {inf ,inf ,inf ,inf ,4 ,inf ,5 ,0 }};
        ArrayList<ArrayList<Integer>> G = InitializeGraph();
        ArrayList<ArrayList<Integer>> GR = InitializeGraphReverse();
        biDijkstra(G, GR, 0, 7, mat);

    }

    public static ArrayList<ArrayList<Integer>> InitializeGraph()
    {
        ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
        int numOfVertices = 8;

        for (int i = 0; i < numOfVertices; i++) {
            G.add(new ArrayList<Integer>());
        }

        G.get(0).add(1);
        G.get(0).add(2);

        G.get(1).add(0);
        G.get(1).add(2);
        G.get(1).add(4);

        G.get(2).add(0);
        G.get(2).add(1);
        G.get(2).add(3);
        G.get(2).add(5);

        G.get(3).add(2);
        G.get(3).add(4);
        G.get(3).add(5);

        G.get(4).add(1);
        G.get(4).add(3);
        G.get(4).add(7);

        G.get(5).add(2);
        G.get(5).add(3);
        G.get(5).add(6);

        G.get(6).add(4);
        G.get(6).add(5);
        G.get(6).add(7);

        G.get(7).add(4);
        G.get(7).add(6);

        return G;
    }

    private static ArrayList<ArrayList<Integer>> InitializeGraphReverse() {
        ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
        int numOfVertices = 8;

        for (int i = 0; i < numOfVertices; i++) {
            G.add(new ArrayList<Integer>());
        }

        G.get(1).add(0);
        G.get(2).add(0);

        G.get(0).add(1);
        G.get(2).add(1);
        G.get(4).add(1);

        G.get(0).add(2);
        G.get(1).add(2);
        G.get(3).add(2);
        G.get(5).add(2);

        G.get(2).add(3);
        G.get(4).add(3);
        G.get(5).add(3);

        G.get(1).add(4);
        G.get(3).add(4);
        G.get(7).add(4);

        G.get(2).add(5);
        G.get(3).add(5);
        G.get(6).add(5);

        G.get(4).add(6);
        G.get(5).add(6);
        G.get(7).add(6);

        G.get(4).add(7);
        G.get(6).add(7);

        return G;
    }

}
