package Graph.ShortestPath_Algorithm;
import java.util.*;

public class _6_Binary_Maze_in_SP {


     static class tuple {
        int first, second, third;
        tuple(int _first, int _second, int _third) {
            this.first = _first;   // distance
            this.second = _second;  // row
            this.third = _third;    // col
        }
    }


      static   int  shortestPath(int[][] grid, int[] source, int[] destination) {

          // Step1: kya pata dono ek ho to distance measure karne ka koi matlb hee nhi
            // Edge Case: if the source is only the destination.
            if(source[0] == destination[0] &&
                    source[1] == destination[1]) return 0;

          // Step2: create queue
            // Create a queue for storing cells with their distances from source
            // in the form {dist,{cell coordinates pair}}.
            Queue<tuple> q = new LinkedList<>();
            int n = grid.length;
            int m = grid[0].length;

          // step3: create distance array aur sbme infinity bhar do bss, src node ko chhod do usko 0 bhardo aur queue
          // me daaaldo  src node ko
            // Create a distance matrix with initially all the cells marked as
            // unvisited and the source cell as 0.
          int[][] dist = new int[n][m];
          for (int[] row : dist) {
              Arrays.fill(row, (int)(1e9));
          }
            dist[source[0]] [source[1]] = 0;
            q.add(new tuple(0, source[0], source[1]));

            // step4: Directions set kardo, grid traversal ke liye
            // The following delta rows and delts columns array are created such that
            // each index represents each adjacent node that a cell may have
            // in a direction.
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};

            // Step5: BFS() lagaao
            // Iterate through the maze by popping the elements out of the queue
            // and pushing whenever a shorter distance to a cell is found.
            while(!q.isEmpty()) {
                tuple it = q.peek();
                q.remove();
                int dis = it.first;
                int r = it.second;
                int c = it.third;

                // Through this loop, we check the 4 direction adjacent nodes
                // for a shorter path to destination.
                for(int i = 0;i<4;i++) {
                    int newr = r + dr[i];
                    int newc = c + dc[i];

                    // Checking the validity of the cell and updating if dist is shorter.
                    if(newr >= 0 && newr < n && newc >= 0 && newc < m
                            && grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]) {
                        dist[newr][newc] = 1 + dis;

                        // Return the distance until the point when
                        // we encounter the destination cell.
                        if(newr == destination[0] &&
                                newc == destination[1]) return dis + 1;
                        q.add(new tuple(1+dis, newr, newc));
                    }
                }
            }
            // If no path is found from source to destination.
            return -1;
        }


        public static void main(String[] args) {

            int[] source={0,1};   // (r, c)
            int[] destination={2,2};   // (r, c)

            int[][] grid=  {{1, 1, 1, 1},
                            {1, 1, 0, 1},
                            {1, 1, 1, 1},
                            {1, 1, 0, 0},
                            {1, 0, 0, 1}};


            int res = shortestPath(grid, source, destination);

            System.out.print(res);
            System.out.println();
        }

}
