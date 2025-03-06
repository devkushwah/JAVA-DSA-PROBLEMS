package Graph.Others_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1_Bridge_in_Graph {
    // Concpet:- Aesi edge bataao jisko hatane par connected components alag-alag ho jaay... to wi edge return krni
    // hai like: { u -> v }
    // agar kisi node par kisi alteranre node ke dwara bhi poch sake to waha back edge ban rahi hai ,back edge waala
    // node khud to (decrease ya update ) hoga sath me apne adjacents ko bhi ( decrease ya update ) krega

    //Using Tarjan's Algorithm of time in and low time

        private static int timer = 1;  // ye humne global variable bana liya

        private static void dfs(int node, int parent, int[] vis,
                                ArrayList<ArrayList<Integer>> adj, int[]  disc, int[] low,
                                List<List<Integer>> bridges) {

            vis[node] = 1;  // node ko visit krenge
            disc[node] = low[node] = timer;   // starting me steps dono array same rakhenge...means 1
            timer++;   // steps++ karenge baadke liye dono array keliye

            for (Integer ngbr : adj.get(node)) {
                if (ngbr == parent) continue;  // hum node ko sirf uske neighbours se compare karenfe par uske parent
                // se nahi, kyoki wo jaha se aaya hai wahi jaane ka kya faayda

                // humare dfs() ki kaasiyat
                if (vis[ngbr] == 0) {
                    dfs(ngbr, node, vis, adj, disc, low, bridges);
                    // jab hum dfs ke last tak poch jaaynge tab hum compare karke lowest time update krenge current
                    // noe ka
                    low[node] = Math.min(low[node], low[ngbr]);
                    // agar neighbor ka lowest time jyadA huya current node ke disc time se to wo bridge hai, to fir
                    // uss bridge waale node aur node ke neighbor ko print kardo
                    if (low[ngbr] > disc[node]) {
                        bridges.add(Arrays.asList(ngbr, node));
                    }
                } else {  // agar node ka disc time chhota huya uske ngbr node ke lowest time se to update kardo node ka lowest time
                    low[node] = Math.min(low[node], low[ngbr]);
                }
            }
        }
        public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            //step1: create Lists of List
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            // Step2: make undirected graph with the help of adjacents nodes, for this we will use for-each loop
            // isme hum main list me se ek-ek list utha rahe hai isliye hum ye waala for each use kar rahe hai
            for (List<Integer> it : connections) {  // it  = { U, V }
                int u = it.get(0); int v = it.get(1);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            // step3: saare  pre-requisites banaao
            int[] vis = new int[n];
            int[] disc = new int[n];  // kitna time lga node par pochne me(insertion time)...steps maan sakte hai
            int[] low = new int[n];   // lowest insertion time(Lowest steps) matlb kisi bhi nodes se kam se kam
            // kitne time me poch sakte hai

            // step4: ek bridge Lists of List banaao, joki humara output banega aur usi ko return krenge...aur output
            // wo edges hai jinko hataay to connected components alag alag ho jaay(bridge)....isliye ek edge ek list
            // hogi to ek se jyada edge mtlb ek se jyada list
            List<List<Integer>> bridges = new ArrayList<>();

            // step4: dfs() lagaao main khel isi ka hai
            dfs(0, -1, vis, adj, disc, low, bridges);

            return bridges;
        }



        public static void main (String[] args) {
            // given 2D array input
            int n = 4;
            int[][] edges = {
                    {0, 1}, {1, 2},
                    {2, 0}, {1, 3}
            };

            // ye humne list of lists bnaali 4
            List<List<Integer>> connections = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                connections.add(new ArrayList<>());
            }

            // last me humne nodes ko connected kar diya aur ek list banadi connections naam ki
            // ye ek acha method hai array se list banakar nodes ko unke adjacents se connect karna
            for (int i = 0; i < n; i++) {
                connections.get(i).add(edges[i][0]);
                connections.get(i).add(edges[i][1]);
            }

            // ye humne criticalConnections function call kar diya
            List<List<Integer>> bridges = criticalConnections(n, connections);

            for (List<Integer> bridge : bridges) {
                int u = bridge.get(0);
                int v = bridge.get(1);
                System.out.print("[" + u + ", " + v + "] ");
            }
            System.out.println(" ");
        }

}
