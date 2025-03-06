package Graph.ShortestPath_Algorithm;
import java.util.*;

public class _3_Dijkrstra_Algo_Through_PriorityQueue {



        // Function to find the shortest distance of all vertices from the source vertex S.
        public static int[] dijkstra(int V, ArrayList<ArrayList<int[]>> adj, int S) {
            // Priority queue to store the nodes as a pair {distance, node}.
            // Min-heap based on distance from the source node.
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            // { distance, node }

            // Array to store the shortest distance to each node, initialized to a large value.
            int[] distTo = new int[V];
            Arrays.fill(distTo, Integer.MAX_VALUE);

            // Set the distance of the source node to itself as 0 and add it to the priority queue.
            distTo[S] = 0;
            pq.add(new int[]{0, S});  // // { distance, node }

            // Process the nodes in the priority queue.
            while (!pq.isEmpty()) {
                // Get the node with the smallest distance.
                int[] top = pq.poll();   // { distance, node }
                int node = top[1];
                int distance = top[0];

                // For all adjacent nodes of the current node.
                for (int[] neighbor : adj.get(node)) {
                    // neighbour[adjNode, weight] = adj.get(0).add(new int[]{1, 1}); // Node 0 -> Node 1 with weight 1
                    // main function me hee sab initialise kr dia tha agar koi diikat hai to usme dhklo
                    int adjNode = neighbor[0];
                    int weight = neighbor[1];

                    // Relaxation step: if a shorter path to adjNode is found, update it.
                    // distance  = node ke upr, weight = edge ke upr
                    if (distance + weight < distTo[adjNode]) {
                        distTo[adjNode] = distance + weight;
                        pq.add(new int[]{distTo[adjNode], adjNode});
                    }
                }
            }

            // Return the array containing shortest distances from source to all the nodes.
            return distTo;
        }



        public static void main(String[] args) {
            int V = 3, E = 3, S = 2;

            // Create adjacency list representation.
            ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            adj.get(0).add(new int[]{1, 1}); // Node 0 -> Node 1 with weight 1
            adj.get(0).add(new int[]{2, 6}); // Node 0 -> Node 2 with weight 6
            adj.get(1).add(new int[]{2, 3}); // Node 1 -> Node 2 with weight 3
            adj.get(1).add(new int[]{0, 1}); // Node 1 -> Node 0 with weight 1
            adj.get(2).add(new int[]{1, 3}); // Node 2 -> Node 1 with weight 3
            adj.get(2).add(new int[]{0, 6}); // Node 2 -> Node 0 with weight 6

            // Run Dijkstra's algorithm and get the shortest distances.

            int[] res = dijkstra(V, adj, S);

            // Print the shortest distances.
            System.out.println("Shortest distances from node " + S + ":");
            for (int i = 0; i < V; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }


}
