package Graph.BFS_And_DFS;

import java.util.*;

class Graph {
    /* ek integer ki ek list se mapping kardi :-
       e.g.     0 -> {1, 2}, 1 -> {0, 2}, 2 -> {0, 1}
     but abhi sabhi khali hai nahi koi integer hai naaki koi adjacent list, bss jagah hai unke liye(empty blocks)*/
    private final Map<Integer, List<Integer>> adjList = new HashMap<>();

    // Method to add an edge to the graph
    public void addEdge(int u, int v, boolean direction) {
        // direction = false -> undirected
        // direction = true -> directed
        // Create an edge from u to v
        // hum checck kar rahe hai ki `u` adjList me present hai ya nhi agar na hoto adjList me `u` banaao Arraylist
        // type ka aur u ko vs se jodhdo....  u -> { v1, v2, v3... }
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(u).add(v);

        // agar undirected banana hai to v se bhi u ko jodhdo..... v -> { u1, u2, u3.... }
        if (!direction) {
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(u); // edge created from v to u ....   v -> {u,u,u,u,u,u,u}
        }
         /* c++ me aise karte hai....waah yrr sab direct hai:-
        adjList[u].push_back(v);
            // if undirected
            if(direction == 0)
                adjList[v].push_back(u); // edge created from v to u
        * */
    }

    // Method to print the adjacency list
    public void printAdjList() { // Iske liye ache se Hashmap aur map seekhna hoga, second method is better than this
        // but this is possible for directed graph also...pr apn doorse waale me bhi same kar sakte haii
        for (Map.Entry<Integer, List<Integer>> node : adjList.entrySet()) {
            /* humne jo 'adjList' banai thi wo Map se banaai thi to for-each loop me map se hee iterate hoga
            par agar list of list bnaai hoti to wo jada acha lagta...Map ki jrurt nhi padhti.
             0 -> {1, 2}, 1 -> {0, 2}, 2 -> {0, 1}         */
            System.out.print(node.getKey() + " -> ");  // node.getKey() = Integer
            for (Integer neighbour : node.getValue()) { // node.getValues() = List<Integer>
                System.out.print(neighbour + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();

        // undirected graph - false indicates undirected
         g.addEdge(0, 1, false);
         g.addEdge(1, 2, false);
         g.addEdge(0, 2, false);

        // directed graph
//        g.addEdge(1, 2, true);
//        g.addEdge(0, 1, true);
//        g.addEdge(0, 2, true);

        g.printAdjList();
    }
}
