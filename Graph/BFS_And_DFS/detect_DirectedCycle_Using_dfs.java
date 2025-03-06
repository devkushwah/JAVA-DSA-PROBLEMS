package Graph.BFS_And_DFS;
import java.util.*;

public class detect_DirectedCycle_Using_dfs {
    //defination of cycle:-
    // agar dfs karte karte same node aa jaay to cycle hai, kyoki sequencial path me cycle nahi hoti
    private static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
        //NOTE:- Jo visit nahi hai hum usko hee path me jodenge aur jo phle se visited hai wo path me nahi jud
        // paayga to return false, agar node already visited hai  aur phle se path me hai to wo cycle bana raha hai

        vis[node] = 1;
        pathVis[node] = 1;

        // traverse for adjacent nodes
        for(int it : adj.get(node)) {
            // when the node is not visited
            if(vis[it] == 0) {
                if(dfsCheck(it, adj, vis, pathVis))
                    return true;
            }
           /*
           *Koi bhi Node dfs() function me pehele upar visit hota hai aur pathVisit hota hai, tab wo neeche aata
             hai Node ke adjacent's  ko check karne,  agar ajdacent visit hua aur pathvisit hua to return true so,
             indicates directed cycle properties (vis[it] == 1 && pathVis[it] == 1) return true, only 4 adjacents

            *NOTE:- Jo visit nahi hai hum usko hee path me jodenge aur jo phle se visited hai wo path me nahi jud
             paayga to return false*/
            else if(pathVis[it] == 1) {
                return true;
            }
        }

        /*
        * Humne upar jo check kiya wo Current Node ke adjacents ke liye kiya, curr node ke adjacents ko check karne
         ke baad Current Node ko path unvisied kardo, ab ye karne ke baad hum return false karenge kyoki
         upr humne phle node ko visit kiya  -> fir pathVisit -> last me baapis path Unvisit(One condtion false)

        *NOTE:- Jo visit nahi hai hum usko hee path me jodenge aur jo phle se visited hai wo path me nahi jud
         paayga to return false

         *aur suno dfs() recurrsively kamm karta hai to sabse last function se path unvisit aur return false karna
         dikkat aay to copy pr graph tree banakr dhklo, tareek bataau:-
         visit to sab karna hai tjo mile unvisit kuch nahi karna, starting function se path visit krte jana uskee
         adcents bhi hote jaaynge jese last node aaya wese hee return false karte huye path unvisit krte jana*/

        pathVis[node] = 0;
        return false;
    }

    // Function to detect cycle in a directed graph.
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        /*
        *  ye humne do visited array bana liya, jime humne pathvis isliye banaya hai kyoki ye directed graph hai
         isliye to ho sakta hai cycle ban rahi ho, par directed nahi ban rahi ho

         * To kaise pata kare ki galat(Wrong directed) cycle ban rahi hai:-

             hum dfs chala rahe hai starting node se end node tak jaaynge visit to krenge hee par agar current node
               kisi path par hai to usko pathVis me daal denge, agar firse kisi node ke dwara dfs chalne par naya
               path banne par wo uss path me bhi present paya gaya to iska mtlb wo directed cycle ka node nhi hai,
               aur woh paya aise jaayga ki( visited huya ho aur puraane path se hatkar pathVis[node] = 0 ho gya ho)
               isliye waha cycle ban hee nhi sakti.

         *NOTE:- Jo visit nahi hai hum usko hee path me jodenge

             * To humko chaiye aisa node Jo dusre path me present na ho wohi cycle bnaayga
        */

        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for(int i = 0;i<V;i++) {
            // if unvisited
            if(vis[i] == 0) {
                // agar dfs() true hoga to hee aange bhadega
                if(dfsCheck(i, adj, vis, pathVis)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);


        boolean ans = isCyclic(V, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");

    }
}
