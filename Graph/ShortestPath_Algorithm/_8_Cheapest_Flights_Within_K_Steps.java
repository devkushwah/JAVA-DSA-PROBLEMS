package Graph.ShortestPath_Algorithm;
import java.util.*;

public class _8_Cheapest_Flights_Within_K_Steps {
    // step: create class Pair for {node, distance} and class Tuple for { stops,{node, distance} }
    // step1: create adjacency lists and make directed graph with distance in terms of { stops,{node, distance} }
    // step2: create queue type of Tuple for storing { stops,{node, distance} }
    // step3: create distance array like dijkstra algo
    // step4: execute while loop of queue
    // step4: if(stops > K) the use keyword continue in while loop
    // step4: check cheapest price within kth stop condition using for each loop in (while loop like dijkstra algo)
    // step: agar dist array me koi infinitr hai to usko -1 krdo aur dist array return krdo


    static class Pair{
        //{node, distance}
        int first;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    static class Tuple {
        //{ stops,{node, distance} }
        int first, second, third;
        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

        public static int CheapestFLight(int n, int[][] flights, int src, int dst, int K) {

        // step1: create adjacency lists and make directed graph with distance in terms of { stops,{node, distance} }
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for(int i = 0;i<n;i++) {
                adj.add(new ArrayList<>());
            }
//            for (int[] flight : flights) {
//                adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
//            }

            int m = flights.length;
            for(int i = 0;i<m;i++) {
                // { stops,{node, distance} }
                adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
            }



            // Step2: Create a queue which stores the node and their distances from the
            // source in the form of {stops, {node, dist}} with ‘stops’ indicating
            // the no. of nodes between src and current node.
            Queue<Tuple> q = new LinkedList<>();  // tuple= { stops,{node, distance} }

            q.add(new Tuple(0, src, 0));

            //step3: create distance array like dijkstra algo
            // Distance array to store the updated distances from the source.
            int[] dist = new int[n];
            Arrays.fill(dist, (int) (1e9));
            dist[src] = 0;

            // Iterate through the graph using a queue like in Dijkstra with
            // popping out the element with min stops first.
            while(!q.isEmpty()) {
                Tuple it = q.peek();
                q.remove();
                int stops = it.first;
                int node = it.second;
                int cost = it.third;

                // We stop the process as soon as the limit for the stops reaches.
                if(stops > K) continue;
                for(Pair iter: adj.get(node)) {
                    int adjNode = iter.first;
                    int edW = iter.second;

                    // We only update the queue if the new calculated dist is
                    // less than the prev and the stops are also within limits.
                    if (cost + edW < dist[adjNode]) {
                        dist[adjNode] = cost + edW;
                        q.add(new Tuple(stops + 1, adjNode, cost + edW));
                    }
                }
            }
            // If the destination node is unreachable return ‘-1’
            // else return the calculated dist from src to dst.
            if(dist[dst] == (int)(1e9)) return -1;
            return dist[dst];
        }


        public static void main(String[] args) {

            int n = 4, src = 0, dst = 3, K = 1;
            int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};


            int ans = CheapestFLight(n,flights,src,dst,K);

            System.out.print(ans);
            System.out.println();
        }


}
