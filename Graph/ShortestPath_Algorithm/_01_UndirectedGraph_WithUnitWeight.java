package Graph.ShortestPath_Algorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class _01_UndirectedGraph_WithUnitWeight {

        public static int[] shortestPath(int[][] edges, int n, int m, int src) {
            //Create an adjacency list of size N for storing the undirected graph.
            //step1: adjacency list banana taaki adjacents nodes traverse ho sake
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0;i<n;i++) {
                adj.add(new ArrayList<>());
            }

            //step2: edges[U,V] ko jodna aur { U -> V and V -> U } taaki undirected edges bana sake aur isse humara
            // undirected Graph bhi banega
            for(int i = 0;i<m;i++) {
                adj.get(edges[i][0]).add(edges[i][1]);
                adj.get(edges[i][1]).add(edges[i][0]);
            }

           // A diistance array jisme humne pehle to infinity bhar diya fir hyum usko update krnege ki...source he
            // uss pointed node ki kitni shortest distance hai joki array me update hoga
            int[] dist = new int[n];
            Arrays.fill(dist, (int) 1e9);
            dist[src] = 0;    // source 0 ki distance 0 tak 0 hee hogi isliye usko phle hee zero update kar dia

            // BFS Implementation
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            while(!q.isEmpty()) {
                int node = q.peek();
                q.remove();
                for(int it : adj.get(node)) {
                    // ye hai main khel jis path ki distance kam hui hum wohi distance store krenge, aur sabki
                    // distance sirf unit means +1 se hee bhdegi
                    if(dist[node] + 1 < dist[it]) {
                        dist[it] = 1 + dist[node];
                        q.add(it);
                    }
                }
            }
           // jo node bach gya humara src node waha tak poch nhi paya aur wo infinity hee reh gya to uski baadme -14
            // bana do
            for(int i = 0;i<n;i++) {
                if(dist[i] == 1e9) {
                    dist[i] = -1;
                }
            }
            //last me sabki distance return krdo
            return dist;
        }


    public static void main(String[] args) throws IOException {
        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        // n = total no. od nodes and m = total no.of edges


        int[] res = shortestPath(edge,n,m,0);
        System.out.print("Shortest path of source to all nodes from 0 to 8 : ");
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }


}
