package Graph.ShortestPath_Algorithm;
import java.util.*;

public class _10_Bellmon_ford {


        static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
          // NOTE: isme pehle se adjacency bani banaai hai, isliye humne adjacency list banaai nahi


            // step1: create distance array and fill infinite
            int[] dist = new int[V];
            Arrays.fill(dist, (int) (1e8));
            dist[S] = 0;


            // V x E
            for (int i = 0; i < V - 1; i++) {   // bellman ford me (V-1) times relaxation krna hota hai,,,aur agar V
                // times relax ho gya to mtlv minus edge present hai graph me, isliye abhi hum sirf (V-1) times loop
                // chala rahe hai....fir baadme Vth times bhi check krenge

                // for each taaki node se uske adjacents par poch sake
                for (ArrayList<Integer> it : edges) { // Relaxation
                    // problem statement me jaise input diya jata hai usi prakar hee node, adjNode sur weight nikaaa
                    // jata hai

                    int u = it.get(0);  //node
                    int v = it.get(1);  // adjNode
                    int wt = it.get(2); // weight

                    // aur ye hai condition bellman ford ki joki dijkstra jesi hai bas thoda sa fark hai...aur ye
                    // condition (V-1) times chalegi
                    if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
            // Nth relaxation to check negative cycle
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    // isse pata chalta hai ki koi negative edge to hai...agar hui to hum usko -1 bana denge aur agar
                    // negative edge mili to uss edge ko return kr denge nahi to distance array return kr denge
                    int[] temp = new int[1];
                    temp[0] = -1;
                    return temp;
                }
            }
            return dist;
        }



        public static void main(String[] args) {
            int V = 6;
            int S = 0;
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
                {
                    add(new ArrayList<>(Arrays.asList(3, 2, 6)));
                    add(new ArrayList<>(Arrays.asList(5, 3, 1)));
                    add(new ArrayList<>(Arrays.asList(0, 1, 5)));
                    add(new ArrayList<>(Arrays.asList(1, 5, -3)));
                    add(new ArrayList<>(Arrays.asList(1, 2, -2)));
                    add(new ArrayList<>(Arrays.asList(3, 4, -2)));
                    add(new ArrayList<>(Arrays.asList(2, 4, 3)));
                }
            };



            int[] dist = bellman_ford(V, edges, S);
            for (int i = 0; i < V; i++) {
                System.out.print(dist[i] + " ");
            }
            System.out.println(" ");
        }

}
