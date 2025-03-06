package Graph.ShortestPath_Algorithm;
import java.util.*;

public class _9_No_Of_Ways_To_Arrive_At_Destination {


    static class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    // Starting of the code:
        static int countPaths(int n, List<List<Integer>> roads) {

            // Step1: Creating an adjacency list for the given graph.
            // pair = { u -> {V, wt} }
            ArrayList < ArrayList < Pair >> adj = new ArrayList < > ();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList < > ());
            }
            int m = roads.size();
            for (List<Integer> road : roads) {
                // create undirected weighted graph { u -> {V, wt} }
                adj.get(road.get(0)).add(new Pair(road.get(1), road.get(2)));
                adj.get(road.get(1)).add(new Pair(road.get(0), road.get(2)));
            }
            // Step1 completed

            // Step2: Defining a priority queue (min heap). { distance, node }
            PriorityQueue < Pair > pq = new PriorityQueue<>((x, y) -> x.first - y.first);

            // Step3: Initializing the dist array and the ways array
            // along with their first indices.
            int[] dist = new int[n];
            int[] ways = new int[n];
            for (int i = 0; i < n; i++) {
                dist[i] = Integer.MAX_VALUE;
                ways[i] = 0;
            }

            //step4: insert values on dist[], ways[] and pq
            dist[0] = 0;
            ways[0] = 1;  // ek to way hoga hee agar koi aur mil gaya to +1 krdenge
            pq.add(new Pair(0, 0));  // { distance, node }

            // step5: Define modulo value
            int mod = (int)(1e9 + 7);

            // Iterate through the graph with the help of priority queue
            // just as we do in Dijkstra's Algorithm.
            //step6: Dijkstra jese while loop ke dwara condition check krte huye pq me daalo aur nikaalo aur ways
            // array update kro
            while (!pq.isEmpty()) {
                int dis = pq.peek().first;  // distance nikala taaki hum isko edW se add krke condition check kr paay
                int node = pq.peek().second;  // node nikala taaki hum iske adjacents nikaal paay
                pq.remove();

                for (Pair it : adj.get(node)) {
                    // it = { adjNode, edW }
                    int adjNode = it.first;
                    int edW = it.second;

                    // This ‘if’ condition signifies that this is the first
                    // time we’re coming with this short distance, so we push
                    // in PQ and keep the no. of ways the same.
                    if (dis + edW < dist[adjNode]) {
                        dist[adjNode] = dis + edW;
                        pq.add(new Pair(dis + edW, adjNode));  //  { distance, node }
                        ways[adjNode] = ways[node];
                    }

                    // If we again encounter a node with the same short distance
                    // as before, we simply increment the no. of ways.
                    else if (dis + edW == dist[adjNode]) {
                        ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                    }
                }
            }
            // Finally, we return the no. of ways to reach
            // (n-1)th node modulo 10^9+7.
            return ways[n - 1] % mod;
        }

    public static void main(String[] args) {

        int n = 7;
        List < List < Integer >> roads = new ArrayList < > () {
            {
                boolean add = add(new ArrayList<>(Arrays.asList(0, 6, 7))); // { u, v, wt }
                add(new ArrayList<>(Arrays.asList(0, 1, 2)));
                add(new ArrayList<>(Arrays.asList(1, 2, 3)));
                add(new ArrayList<>(Arrays.asList(1, 3, 3)));
                add(new ArrayList<>(Arrays.asList(6, 3, 3)));
                add(new ArrayList<>(Arrays.asList(3, 5, 1)));
                add(new ArrayList<>(Arrays.asList(6, 5, 1)));
                add(new ArrayList<>(Arrays.asList(2, 5, 1)));
                add(new ArrayList<>(Arrays.asList(0, 4, 5)));
                add(new ArrayList<>(Arrays.asList(4, 6, 2)));

            }
        };

        int ans = countPaths(n, roads);

        System.out.print(ans);
        System.out.println();
    }

}
