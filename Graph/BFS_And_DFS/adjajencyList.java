package Graph.BFS_And_DFS;
import java.util.*;

public class adjajencyList {

        public static List<List<Integer>> printGraph(int V, int[][] edges) {
            // Initialize the adjacency list
            // humne ans list bnaali aur map data str. bana dia 'hm' naam se  = [ node -> { adjacency list } ]
            List<List<Integer>> ans = new ArrayList<>();
            Map<Integer, List<Integer>> hm = new HashMap<>();

            // Initialize hashmap with empty lists for each vertex
            // hindi:- jitne nodes hai utni list banengi aur hm me store hongi
            for (int i = 0; i < V; i++) {
                hm.put(i, new ArrayList<>());
            }

           // isme hum u aur v ko find kar rahe hai. aur iske doorse method me humko u aur v diya tha
            // par isme ache se edges add kiya hai simple tareeka hai,
            for (int i = 0; i < edges.length; i++) {
                int key = edges[i][0];   // u  ( e.g. {0, 1} )
                int key2 = edges[i][1];  // v

                // Add the edge in both directions (undirected graph)
                if (hm.containsKey(key)) {
                    hm.get(key).add(key2);
                }
                if (hm.containsKey(key2)) {
                    hm.get(key2).add(key);
                }
            }

            // Extract the adjacency list from the hashmap
            for (int i = 0; i < V; i++) {  // 0 to  4
                if (hm.containsKey(i)) {
                    // isme 0 to 4 har node ke list banegi aur ans list of list me add hoti jaaygi aur usko return kr
                    // denge jisse wo print ho sake list of list
                    ans.add(hm.get(i));
                }
            }

            return ans;
        }

        public static void main(String[] args) {

            int V = 5;
            // isme humko matrix type me edges dii hai
            int[][] edges = {
                    {0, 1},
                    {0, 4},
                    {1, 2},
                    {1, 3},
                    {1, 4},
                    {2, 3},
                    {3, 4}
            };



            List<List<Integer>> graph = printGraph(V, edges);

            // Print the adjacency list
            for (int i = 0; i < graph.size(); i++) {
                System.out.print(i + " -> ");
                for (int j = 0; j < graph.get(i).size(); j++) {
                    System.out.print(graph.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }

