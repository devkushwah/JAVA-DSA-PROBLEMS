package Graph.Others_Algorithm;

import java.util.ArrayList;
import java.util.Stack;

// ye 3 steps ka problem hai:-
 // 1. traverse all graph and do dfs() call for  store all node in stack
// 2. reverse an graph
// 3. with dfs() call remove stack elements and traverse resversed graph and count ssc with the help of dfs() calls
public class _3_Kosarajus_Algorithm {

//User function Template for Java

        private static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj,
                                Stack<Integer> st) {
            vis[node] = 1;
            // yha par node ko hum visit aur store kar rahe hai aur uske adjacents ke sath
            for (Integer it : adj.get(node)) {
                if (vis[it] == 0) {
                    dfs(it, vis, adj, st);
                }
            }
            st.push(node);
            // yha tak humne step1 khatam kiya
        }
        private static void dfs2(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
            vis[node] = 1;
            for (Integer it : adjT.get(node)) {
                if (vis[it] == 0) {
                    dfs2(it, vis, adjT);
                }
            }
        }
        //Function to find number of strongly connected components in the graph.
        public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
            int[] vis = new int[V];
            Stack<Integer> st = new Stack<>();
            // humne vis aur stack bana liya, stack me hum dfs() ke dwara SSC's ko count krenge
            for (int i = 0; i < V; i++) {
                if (vis[i] == 0) {
                    dfs(i, vis, adj, st);
                }
            }

            // step2: reverse an graph and named that graph is adjT(ye simple graph jaisa hee hai phle arraylist list
            // hoti fir array list se node aur uske adjcents ko connect karte hai)
            ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                // jitne nodes the uthne nodes ki arraylist banadi
                adjT.add(new ArrayList<>());
            }
            for (int i = 0; i < V; i++) { // yha pr hum ith node ke adjacents ko uss ith node se jodenge........ith
                // node ke jo jo adjacents honge un sabse ith node judega { adjacentsNodes -> ith node }.......isse graph reverse ho jaayga.....NOTE: isse stack khaali nhi hua hai abhi......stack khalli hum ssc ginne ke liye krenge dfs2 ke dwara
                vis[i] = 0;  // saare nodes ko unvisit krdia taaki bapis dfs lag sake
                for (Integer it : adj.get(i)) {
                    // i -> it
                    // it -> i
                    adjT.get(it).add(i);
                }
            }
            // yha tak step2 khatam hua ab step3 start
            // step3: stack and dfs() ke dwara traverse karke SSC's ko count karna
            int scc = 0;
            while (!st.isEmpty()) {
                int node = st.peek();
                st.pop();
                if (vis[node] == 0) {
                    scc++;
                    dfs2(node, vis, adjT);
                }
            }
            return scc;
        }



        public static void main (String[] args) {
            int n = 5;
            int[][] edges = {
                    {1, 0}, {0, 2},
                    {2, 1}, {0, 3},
                    {3, 4}
            };

            // ye humne 2D array se arrayylist banakar, nodes ko uske adjacents se jod diya
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                adj.get(edges[i][0]).add(edges[i][1]);
            }

            int ans = kosaraju(n, adj);
            System.out.println("The number of strongly connected components is: " + ans);
        }

}
