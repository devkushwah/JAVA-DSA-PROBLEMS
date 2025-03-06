package Graph.Topo_Sort;
import java.util.*;

public class Kahns_Algorithm {
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[V];

        // Calculate indegree of each vertex
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Add all vertices with 0 indegree to the queue
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Process the vertices in topological order
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[i++] = node;

            // Reduce the indegree of adjacent vertices
            for (int adjacents : adj.get(node)) {
                indegree[adjacents]--;
                if (indegree[adjacents] == 0) {
                    q.add(adjacents);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the directed graph
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Get the topological order
        int[] topoOrder = topoSort(V, adj);

        // Print the topological order
        System.out.println("Topological Sort of the given graph:");
        for (int i = 0; i < V; i++) {
            System.out.print(topoOrder[i] + " ");
        }
    }
}
