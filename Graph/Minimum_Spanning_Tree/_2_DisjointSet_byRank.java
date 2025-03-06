package Graph.Minimum_Spanning_Tree;

import java.util.ArrayList;
import java.util.List;

public class _2_DisjointSet_byRank {
    // concept:-
    // 1. sab apne apne baap ko bulate hai aur unki rank  dhkte hai jiski rank badi baap banta hai sabka,
    // lekin baap ek hee rahega sabka
    // 2. jese hee ulp se koi node judega ya path compression hoga to uss ulp ki rank++ hogi



  static   class DisjointSet {
      // pre-requisites
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {  // n = 7

            for (int i = 0; i <= n; i++) {
                rank.add(0);   // starting me sb node ki rank 0 krdi  { rank = [0, 0, 0, 0, 0, 0, 0, 0]  }
                parent.add(i); // starting me sab node ke parent wo khud hai { parent = [0, 1, 2, 3, 4, 5, 6, 7] }
                size.add(1);   // starting me sb node ka size 1 krdiya ( size  = no. of nodes)
                               // size = [1, 1, 1, 1, 1, 1, 1, 1]
            }
        }

        // step2: find ultimate parent of node
        public int findUPar(int node) {
            // jis node ka koi parent nhi hai uska parent wo khud hai , uske parent ke liye node khud ko return krega
            if (node == parent.get(node)) {
                return node;
            }
            // agar node khudka parent nahi hai to iska mtlb wo ulp node hai wo, to recursively function ke dwara ulp
            // nikaalo jiska koi ulp na ho, aur fir path compression krdo =  parent.set(node, ulp);
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);   // ( child, parent )  ulp milne par node ke parent ulp set krdenge
            return parent.get(node);   // last me node ke parent ko return krdenge
        }

        public void unionByRank(int u, int v) {
            // step1: sbse pehle ultimate parent nikaalne ka function banaao usse { u aur v } ka ulp nikaalo
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            // step1:
            // 1. U aur V  ka ulp check kro agar equal(ek hee parent) hai to , chhodo ( return ) krdo...to fir dono
            // ke baap me kya comparasion hogga
            // 2. lekin dono me se kiske ulp ki rank badi hai to uss node ko parent banado chhote node vaale ka
            // 3. agar dono node ke ulp ki rank equal hui to kisi bhi node ko parent bana dena
            // 4. agar U aur V dono ke ulp ki rank same hui to kisi ko bhi baap bana do , aur uss baao ki rank++ krdo
            if (ulp_u == ulp_v) return;
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);   // (child = u, parent = v)
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);   // (child = v, parent = u)
            } else {
                parent.set(ulp_v, ulp_u);  // jab dono baapo ki rank equal ho, kisi ko to bada baap banana pdega na
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1); // jab rank equal hogi tabhi rank++ hogi
            }
        }

        // ************************************same as unionByRank*************************************************
        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            // agar v ke baap ka size bda hai u ke baap se,
            // to v ke baap ko baapo ka baap bana do aur
            // fir v ke ulp ke size me u ke ulp ka size add krdo
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {  // same for U
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
        //**********************************************************************************************************
    }


        public static void main (String[] args) {
            DisjointSet ds = new DisjointSet(7);
            ds.unionByRank(1, 2);
            ds.unionByRank(2, 3);
            ds.unionByRank(4, 5);
            ds.unionByRank(6, 7);
            ds.unionByRank(5, 6);

            // if 3 and 7 same or not
            if (ds.findUPar(3) == ds.findUPar(7)) {
                System.out.println("Same");
            } else
                System.out.println("Not Same");

            ds.unionByRank(3, 7);
            if (ds.findUPar(3) == ds.findUPar(7)) {
                System.out.println("Same");
            } else
                System.out.println("Not Same");
        }

}
