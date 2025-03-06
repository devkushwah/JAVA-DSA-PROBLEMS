package Graph.Minimum_Spanning_Tree;
import java.util.*;

public class _1_prims_algorithm {


// User function Template for Java

   static class Pair {
        int node;
        int distance;
        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }

        //Function to find sum of weights of edges of the Minimum Spanning Tree.
        static int spanningTree(int V,
                                ArrayList<ArrayList<ArrayList<Integer>>> adj) {
            PriorityQueue<Pair> pq =
                    new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));

            int[] vis = new int[V];
            // {wt, node}
            pq.add(new Pair(0, 0));
            int sum = 0;
            while (!pq.isEmpty()) {
                int wt = pq.peek().distance;
                int node = pq.peek().node;
                pq.remove();

                if (vis[node] == 1) continue;
                // add it to the mst
                vis[node] = 1;
                sum += wt;

                for (int i = 0; i < adj.get(node).size(); i++) {
                    int edW = adj.get(node).get(i).get(1);
                    int adjNode = adj.get(node).get(i).get(0);
                    if (vis[adjNode] == 0) {
                        pq.add(new Pair(edW, adjNode));
                    }
                }
            }
            return sum;
        }



        public static void main(String[] args) {
            int V = 5;
            // create undirected graph:-

            //1. lists of ( lists of list) banaao
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

            // abhi sirf humko grid dii hai
            int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

            // V=5 hai isliye 5 arrayList banegi adj list me { U -> { V, wt } }  U = 0,1,2,3,4
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            // ab 6 lists hai edges[][] array me, isliye hum poore 6 lists pr traverse krenge aur { u -> { v, wt } }
            // nikaalenge edges grid me se
            for (int i = 0; i < 6; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                int w = edges[i][2];

                // isse hum U aur V ko connect kr denge with same wight
                // we can say { u -> and <- v }
                ArrayList<Integer> tmp1 = new ArrayList<>();
                ArrayList<Integer> tmp2 = new ArrayList<>();
                tmp1.add(v);
                tmp1.add(w);

                tmp2.add(u);
                tmp2.add(w);

                adj.get(u).add(tmp1);
                adj.get(v).add(tmp2);
            }


            int sum = spanningTree(V, adj);
            System.out.println("The sum of all the edge weights: " + sum);
        }

}
