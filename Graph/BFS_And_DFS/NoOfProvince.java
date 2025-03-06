package Graph.BFS_And_DFS;
import java.util.*;

public class NoOfProvince {
    // dfs traversal function
    private static void dfs(int node,
                            ArrayList<ArrayList<Integer>> adjLs ,
                            int[] vis) {
        /*
         * adjLs = [  [2]
         *            []         or      { 0---2, 1 }
         *            [0]  ]
         */


        //ye current node visit ho raha hai dfs() ka kaam hai nodes visit krna
        vis[node] = 1;
        //isme hum current node ke neighbours(Mapping) ko bhi dfs(!visit) chala rahe hai agar usse koi mapp hai to
        //Exlaination ke liye comment kholo:-

        /*
        Explain:- i=0, cnt = 1, dfs(0) aayga visit hoga +  dfs(2) ko visit krega, i = 2(already visited) No cnt++,
         i  = 3 dfs(3) cnt = 2

        iteration for node = 0
        * iteration 1:  isme phle 0 ka neighbour 2 aur joki hai unvisited usko dfs() call kro
        * iteration 2:  2 ko visit kro 2 ka padosi 0 already visited to chhodo
        iteration for node =  1
        * iteration 1: isme 1 ko visit kro aur uska padosi kuch nhi to chhdo
        iteration for node = 2
        * iteration 1:   isme 2 already visited hai aur uska padosi bhi visited hai to koi dfd() nhi to

        * */
        for(Integer it: adjLs.get(node)) {
            //agar wo unvisited hai to dfs() lagaao
            if(vis[it] == 0) {
                dfs(it, adjLs, vis);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        // yaha v = 3 hai, V means number of vertices or nodes in graph
        for(int i = 0;i<V;i++) {
            // ye ban gai 3 empty list of adjLs list
            adjLs.add(new ArrayList<Integer>());
        }

        // Convert Adjacency Matrix to Adjacency List
        // ye hai iska conversion:-
                     /*
                             0 1 2
                          0[ 1 0 1 ]
     adj=>                1[ 0 1 0 ]     =>    province  = { 0---2, 1 } only 2
                          2[ 1 0 1 ]
                     * */
        for(int i = 0;i<V;i++) {  // 3 row
            for(int j = 0;j<V;j++) { // 3 column
                // self nodes(i != j) are not considered
                if(adj.get(i).get(j) == 1 && i != j) {  // mapped && not self loop
                    adjLs.get(i).add(j);   // isme hum indirect mapping kr rhe hai
                    adjLs.get(j).add(i);   // result = { 0---2, 1 }
             /*                                    =  [  [2]
                                                           []
                                                          [0]  ]                         **/
                }
            }
        }


        int[] vis = new int[V];  // vis[3] = {0, 1, 2,}
        int cnt = 0;
        for(int i = 0;i<V;i++) {  // i = 0, 1, 2
            // agar ith node visited nhi hai iska mtlv hum agle province par aa gaye
            // isliye cnt++ krdo aur dfs() call  krdo

            if(vis[i] == 0) {
                cnt++;
                dfs(i, adjLs, vis);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        // adjacency matrix
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();

        // bhai phle bta du ye matrix kuch iss prakaar hai:-
                  /*
                             0 1 2
                          0[ 1 0 1 ]
     adj=>                1[ 0 1 0 ]     =>    province  = { 0---2, 1 } only 2
                          2[ 1 0 1 ]
                     * */
        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);
//        adj.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1)));
//        adj.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0)));
//        adj.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1)));

      //  System.out.println(adj);
        System.out.println(numProvinces(adj,3));
        /*
        * Important steps to find number of province

        * NOTE:- HUMKO HAR NODE KI ADJACENT LIST BANANI HAI JISKE LIYE, HUMKO adj PURA TRAVERSE KARNA HOGA AUR USME
        * MAPPING CHECK KRNI HOGI KI KISKI KISSE HAI OR KON KISKA NEIGHBOUR HAI
        *
        * Step1. humko 2 loop lagenge(3*3 = 9 iterations) kyoki hum adjacentt matrix ko adjacent List me change kar
        * rahe hai...first loop row ke liye aur  second loop column ke liye

        * step2. agar 3 nodes hai to iss prakar adj dhikegi:-

                                 0 1 2
                              0[ 1 0 1 ]
         adj=>                1[ 0 1 0 ]     =>    province  = { 0---2, 1 } only 2
                              2[ 1 0 1 ]

        * Step3. Iss List of list ko (row, column)wise traverse karke har node ke uske adjacent ke sath mapping
        * kardo without self loop aur har node ki adjacent list bnaado aur wo bhi list of list bnegi
         * adjLs = [  [2]
         *            []
         *            [0]  ]
         *
        * NOTE:- AB KHEL SHURU HOTA HAI dfs() KA aur count krlo passes dfs() ke
        *
        * Steps(i). ek visited array banaao jitne vertices hai utne size ka aur loop chalaao
        * if(vis[i] == 0) {
                cnt++;
                dfs(i, adjLs, vis);
            }
        * concept:- uss ith node ko visit kro aur uske neighbours ko check kro agar koi unvisited hai to dsf() call
        * karo
        * */
    }
}
