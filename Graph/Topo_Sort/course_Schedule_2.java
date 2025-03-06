package Graph.Topo_Sort;
import java.util.*;

//ye bilkul course_schedule jesa hai bss isme fark hai ki....isme order btaya hai aur usme btaya tha ki ye topo sort
// ha ya nhi aur isme btaya hai ki agar ye topo sort hai to uska order find kro

public class course_Schedule_2 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int m = prerequisites.length;
        int n = numCourses;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // Topological sort start
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] topo = new int[n];
        int ind = 0;
        // Topological sort process
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[ind++] = node;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // If the topological sort is valid, return the order
        if (ind == n) {
            return topo;
        } else {
            return new int[0];  // Return an empty array if it's not possible to finish all courses
        }
    }

    public static void main(String[] args) {


        // Example test case 1
        int numCourses1 = 4;
        int[][] prerequisites1 = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        int[] order1 = findOrder(numCourses1, prerequisites1);
        System.out.println("Course order 1: " + Arrays.toString(order1));

        // Example test case 2 of cyclic graph
        int numCourses2 = 2;
        int[][] prerequisites2 = {
                {1, 0},
                {0, 1}
        };
        int[] order2 = findOrder(numCourses2, prerequisites2);
        System.out.println("Course order 2: " + Arrays.toString(order2));
    }

}
