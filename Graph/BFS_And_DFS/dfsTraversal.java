package Graph.BFS_And_DFS;
import java.util.*;
public class dfsTraversal {

    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj,
                           ArrayList<Integer> ls) {

        //main part of this code
        //marking current node as visited

        //jo node aay phle usko visit kro
        vis[node] = true;
        //usko ls me daaldo taaki baadme hun answer print kar sake
        ls.add(node);

        //getting neighbour nodes
        for(Integer it: adj.get(node)) {
            if(!vis[it]) {
                // jo node unvisited hai uske liye hum recurrsively dfs function chalaaynge jissme wo ls me answer
                // store krde aur audar jaake visit bhi ho jaay...ye kaam sabke liye recurrsively hoga...aur isme
                // kaafi backtracking bhi hogi
                dfs(it, vis, adj, ls);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        //boolean array to keep track of visited vertices
        //hum array [v+1] mtlv 6 ka isliye bana rahe hai kyoki....
        // array idx 0 se 5 tak ho sake aur hum 1 se 5 tak visit aur unvisit kar sake boolean array me
        boolean vis[] = new boolean[V];
        // humne vis[0] = 0 ko visit kar dia kyoki kyoki graph me 0 vertex to hai hee nhi aise to array me wo unvisit
        // hee reh jaayga aur humhara code pura execute hee nhi hoga
        vis[0] = true;
        // ls hamari list hai jisme hum traverse kiye huye nodes mtlv answer daalenge
        ArrayList<Integer> ls = new ArrayList<>();
        // iss dfs function ka itne kaam hai bss....node ko ls me store karna aur usko visit karna aur uss node ke
        // adjacent ke sath  bhi same kaam karna
        dfs(0, vis, adj, ls);
        // last me ls me sab visit hokar sab store ho chuke hai to usko  return kdo
        return ls;
    }

    public static void main(String args[]) {

        //ye humne adj naam ki adjaceny list of list bna dii
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        // 5 vertex hai to sbki ek-ek adjacency list bnegi mtlb 5cho ki aur wo paacho ki ek adj list
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        //ye humne graph design kar dia
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        //ye humne call krdia jisme humne (total vetesx, adjacency list) bhejdi
        ArrayList < Integer > ans = dfsOfGraph(5, adj);  // max. value node = 4
        int n = ans.size();
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }
}
