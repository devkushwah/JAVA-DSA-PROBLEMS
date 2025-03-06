package Graph.BFS_And_DFS;
import java.util.*;

public class bipartite_graph {
    // same as detectCycleUsingDfs
    private static boolean dfs(int node, int col, int[] color,
                               ArrayList<ArrayList<Integer>>adj) {

        color[node] = col;

        // traverse adjacent nodes
        for(int it : adj.get(node)) {
            // if uncoloured
            if(color[it] == -1) {
                // isme 1-col hee bana raha hai colors = 0 and 1
                if(!dfs(it, 1 - col, color, adj)) return false;
            }
            // if previously coloured and have the same colour
            // agaar aange ka node already colured hai aur current node aur aange ka node ka same color hai to false
            else if(color[it] == col) { // same color (current node ka color == aange ke node ka color)
                return false;
            }
        }

        return true;
    }
    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        // for connected components
        for(int i = 0;i<V;i++) {
            if(color[i] == -1) {
                // here col means colors : 0 and 1
                if(!dfs(i, 0, color, adj)) return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        // V = 4, E = 4
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);


        boolean ans = isBipartite(4, adj);
        if(ans)
            System.out.println("Hega");
        else System.out.println("Nahi hai");
    }
}
