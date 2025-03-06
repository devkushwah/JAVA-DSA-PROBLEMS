package Graph.BFS_And_DFS;
import java.util.*;
public class bfsTraversal {
    // Function to return Breadth First Traversal of given graph.
    public static ArrayList<Integer> bfsOfGraph(int V,
                                                ArrayList<ArrayList<Integer>> adj) {

        // hum ans list me apna answer store karenge
        ArrayList < Integer > ans = new ArrayList < > ();
        // iske graph me max. value node = 4 hai to humko 5 size ka array banana hai...uske 2 tareeke
        // 1. ya to argument me hee 5 assign krdo.
        // 2. parameter me [v+1] assign krke [4+1] = 5 krdo
        // mene dfs me 2nd choose liya hai aur isme 1
        boolean[] vis = new boolean[V];
        // dfs me humne adj list of list bnaai hai par sime humne sirf queue bnaya hai jisme hum node ke adjacent ko
        // store karenge
        Queue < Integer > q = new LinkedList < > ();

        //humne phla node 0 liya hai aur shuruaat usse kii hai...usko array me visit kr dia aur queue me daal dia
        // taaki uske adjacent ko baadme store kar sake
        q.add(0);
        vis[0] = true;

        // NOTE:- iske aange tum thoda dfs traversal dhek lo ache se samaj aa jaayga thoda hee difference hai usme
        // adj list bnaai hai hai isme sirf queue bnaai hai.
        while (!q.isEmpty()) {
            Integer node = q.poll(); // hum normally baaki questions me Node type ka queue banete hai pr ye Integer h
            ans.add(node);

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer it: adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        //ye humne adj naam ki adjaceny list of list bna dii
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        // 5 vertex hai to sbki ek-ek adjacency list bnegi mtlb 5cho ki aur wo paacho ki ek adj list
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        //ye humne graph design kar dia
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);


        //ye humne call krdia jisme humne (total vetesx, adjacency list) bhejdi
        ArrayList < Integer > ans = bfsOfGraph(5, adj);
        int n = ans.size();
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }
}
