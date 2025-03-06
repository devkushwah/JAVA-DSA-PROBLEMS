package Graph.BFS_And_DFS;
import java.util.*;
public class detectCycleUsingBFS {
    static class Node {
        int first;
        int second;
        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s,
                                 boolean[] vis, int[] parent)
    {
        Queue<Node> q =  new LinkedList<>(); //BFS

        /*
         ye humne Node Constructor bnaya hai aur constructor ek se jyada value le sakte
         hai....jese humm LinkedList ya Tree bnate time class Node bnate the aur usme {this.data, next, prev}
         daalte the
         */
        q.add(new Node(s, -1));  // ye while loop ke bahar queue me 0 ke liye pparent: -1 de diya only for 0
        vis[s] =true; // aur visit kr dia

        // until the queue is empty
        while(!q.isEmpty())  // BFS ki kahani shuru
        {
            // source node and its parent node....ye arraylist ya array nhi hai isliye aise hee karna hoga
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            // go to all the adjacent nodes
            for(Integer it: adj.get(node))
            {
                if(!vis[it])
                {
                    q.add(new Node(it, node));
                    vis[it] = true;
                }

                /*
                 * NOTE:- Ek adjacent Node ka ek hee parent ho sakta hai
                 * Isme Node 1 dowara parent nahi ban sakte kyoki wo pehle se parent hai  "2" ka
                 * (That's why)   else if(adjacentNode != parent) return true;
                 * */
                // if adjacent node is visited and is not its own parent node
                else if(par != it) return true;
            }
        }

        return false;
    }

    // function to detect cycle in an undirected graph
    public static  boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // ye boolean visited array bna lia aur sabme false bhar diya, false indicates unvisited
        boolean[] vis = new boolean[V];
        Arrays.fill(vis,false);

        /*
        ye humne parent array bna liya aur usme sabme -1 and -1 indicates not parent of someone
        Array isliye kyoki kisi bhi source node ka 1 hee parent node hoga to humko jese-jese source node ka parent milta jaayga hum array me store kar denge taaki baadme uska koi aur parent na bane simple language me naam rajister kar rahe hai parent ka
         */
        int[] parent = new int[V];
        Arrays.fill(parent,-1);

        for(int i=0;i<V;i++)
            // hum saare nodes traverse krenge agar koi unvisited hua to BFS call krenge
            if(!vis[i])
                if(checkForCycle(adj, i,vis, parent))
                    return true;

        return false;
    }

    public static void main(String[] args)
    {
        // ye adjacency list banali
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            adj.add(new ArrayList < > ());
        }
        //Undirected Graph
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(2).add(5);
        adj.get(3).add(4);
        adj.get(3).add(1);
        adj.get(3).add(6);
        adj.get(4).add(3);
        adj.get(5).add(2);
        adj.get(5).add(7);
        adj.get(6).add(3);
        adj.get(6).add(7);
        adj.get(7).add(5);
        adj.get(7).add(6);


        boolean ans = isCycle(8, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");
    }
}

