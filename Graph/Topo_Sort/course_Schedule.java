package Graph.Topo_Sort;
import java.util.*;

public class course_Schedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int m = prerequisites.length;  //length = m = 2
        int n = numCourses;            // no. of courses  =  n = 4

        for (int i = 0; i < n; i++) {
            // 4 course hai to 4 empty arrayList banali
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            //agar course [u, v ] hai to humne u ->  v kar dia...to keh sakte hai ab humara Directed Graph ban chuka
            // hai ab topo sort decide krega.....ki ye sahi hai ya nhi
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

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return count == n;
    }
    public static void main(String[] args) {


        // Example test case
        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        boolean result = canFinish(numCourses, prerequisites);
        System.out.println("Can all courses be finished? " + result);
    }
}