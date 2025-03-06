package Graph.Minimum_Spanning_Tree;

import java.util.ArrayList;
import java.util.List;

public class _4_No_of_operations_to_make_network_connected {
    // Concept:-
    // 1. Extra edges find karo (Extra edge = jiska ulp ek hee ho)
    // 2.  No. of components(No of root nodes ) nikaalo disjoint set ki help se
    // 2. agar extra edges jyada hui required edges yo return krdo nc - 1 { no. of components - 1} nahi to -1

   static class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

        // Step1: Disjoint object banaao aur no. of components find karo
        public static int Solve(int n, int[][] edge) {
            DisjointSet ds = new DisjointSet(n);

            // Step2: faaldo edges find krne ke liye variable banaao cntExtras = 0
            int cntExtras = 0;
            int m = edge.length;

            // edge grid me se { U aur V } nikaal lo taaki Disjoint set laga sako
            for (int[] ints : edge) {
                int u = ints[0];
                int v = ints[1];
                // agar { U aur V } ka parent ek hee hai to mtlv wo extra edge hai component me jisko hatakra hum
                // next component jodenge
                if (ds.findUPar(u) == ds.findUPar(v)) {
                    cntExtras++;
                } else {
                    ds.unionBySize(u, v);
                }
            }

            // yaha hum count krenge ki jitne edges ki jarurt hau humko components ko jodne ke liye (nc - 1)
            int cntC = 0;
            for (int i = 0; i < n; i++) {
                if (ds.parent.get(i) == i) cntC++;   // hum root node ginenge
            }
            int ans = cntC - 1;   // itne edges chaiye components ko jodne ke liye
            if (cntExtras >= ans) return ans;  // agar hum par extra edges huye to hee hum jod paaynge
            return -1;
        }



        public static void main (String[] args) {
            int V = 9;
            int[][] edge = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};


            int ans = Solve(V, edge);
            System.out.println("The number of operations needed: " + ans);

        }

}
