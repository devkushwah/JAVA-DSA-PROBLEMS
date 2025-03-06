package Graph.BFS_And_DFS;
import java.util.*;

public class detectCycleUsingDFS {
    private static boolean dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>>  adj) {

        //sbse phele ye node ko visit krega
        vis[node] = 1;
        // go to all adjacent nodes
        for(int adjacentNode: adj.get(node)) {
            //isme current node  ke adjacents ko dhk rahe hai ki visited hai ya nhi
            if(vis[adjacentNode]==0) {
                if(dfs(adjacentNode, node, vis, adj))
                    return true;
            }
            // if adjacent node is visited and is not its own parent node
            /*
            * NOTE:- Ek adjacent Node ka ek hee parent ho sakta hai
            * Isme Node 1 dowara parent nahi ban sakte kyoki wo pehle se parent hai  "2" ka
            * (That's why)   else if(adjacentNode != parent) return true;
            * */
            else if(adjacentNode != parent) return true;
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        //visit array bna lia jo visit krega
        int[] vis = new int[V];
       // vis[0] = 1;
        for(int i = 0;i<V;i++) {
            if(vis[i] == 0) {
                // humare first node ka koi parent node to hai nhi isliye parent ko -1 de diya
                if(dfs(i, -1, vis, adj)) return true; // ab ye recursion shuru ho gya
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        //ye humne adjacency list banali
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            adj.add(new ArrayList < > ());
        }
        //undirected graph
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(2).add(5);
        adj.get(3).add(4);
        adj.get(3).add(1);
        adj.get(3).add(6);
        adj.get(4).add(3);
        adj.get(5).add(2);
        adj.get(5).add(7);
        adj.get(6).add(3);
        adj.get(6).add(7);
        adj.get(7).add(5);
        adj.get(7).add(6);


        boolean ans = isCycle(8, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");
    }

}
