package Graph.ShortestPath_Algorithm;
import java.util.*;

public class _4_Dijkrstra_Algo_Through_TreeSet {



        // Function to find the shortest distance of all vertices from the source vertex S.
        public static int[] dijkstra(int V, ArrayList<ArrayList<int[]>> adj, int S) {
            // Create a TreeSet to store the nodes as a pair {dist, node}
            // where dist is the distance from source to the node.
            TreeSet<int[]> set = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

            // Initialize dist array with a large number to indicate the nodes are unvisited initially.
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);

            // Insert source node with distance 0.
            set.add(new int[]{0, S});
            dist[S] = 0;

            // Process the nodes in ascending order of distance.
            while (!set.isEmpty()) {
                int[] top = set.pollFirst();  // Extract the first element (min distance).
                assert top != null;   // agar set ka top khaali huya to ye uske liye
                int node = top[1];
                int dis = top[0];

                // Traverse all adjacent nodes of the current node.
                for (int[] neighbour : adj.get(node)) {
                    int adjNode = neighbour[0];
                    int edgeWeight = neighbour[1];

                    // Check if there's a shorter path to the adjacent node.
                    if (dis + edgeWeight < dist[adjNode]) {
                        // Remove the previous entry of the adjacent node if it exists.
                        if (dist[adjNode] != Integer.MAX_VALUE) {
                            set.remove(new int[]{dist[adjNode], adjNode});
                        }

                        // Update the distance and insert the new pair into the set.
                        dist[adjNode] = dis + edgeWeight;
                        set.add(new int[]{dist[adjNode], adjNode});
                    }
                }
            }

            // Return the array containing the shortest distances.
            return dist;
        }



        public static void main(String[] args) {
            int V = 3, S = 2;

            // Create adjacency list representation.
            ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            adj.get(0).add(new int[]{1, 1});
            adj.get(0).add(new int[]{2, 6});
            adj.get(1).add(new int[]{2, 3});
            adj.get(1).add(new int[]{0, 1});
            adj.get(2).add(new int[]{1, 3});
            adj.get(2).add(new int[]{0, 6});


            int[] res = dijkstra(V, adj, S);

            // Print the result
            for (int i = 0; i < V; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }


}
