package Graph.BFS_And_DFS;
import java.util.*;

public class rottenOranges {
    public static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;   // ye acha idea hai matrix ya grid ke column ka size nikaalne ka
        Queue<int[]> queue = new LinkedList<>(); //queue array[] type ka jisme node ki (ith, jth) position aaygi
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    //ye humne queue me daaldi rotten ki position
                    queue.offer(new int[]{i , j});
                }
                if(grid[i][j] != 0) {
                    count_fresh++; //7 (include 2)
                }
            }
        }

        if(count_fresh == 0) return 0;
        int countMin = 0, cnt = 0;//apna main answer count_min hai, count_min tab increase hota hai jab queue khaali hota hai wo minute batata hai, aur cnt btata hai ki humne kitni baar oranges rot kre
        int[] dx = {-1,0,1,0}; // x-axis direction its four possible neighbors (up, right, down, left)
        int[] dy = {0,1,0,-1}; // y-axis direction its four possible neighbors (up, right, down, left)
        /*
         * NOTE:- x-axis me left ya right jaao sab constant rehta hai...bss top jaane me -1 aur down jaane me +1 hota hai
         *          y-axis me left jaane pr -1 aur right jaane pr +1 hota hai, top aur down jaane me sab constant rehta hai
         *
         *         bfs starting from initially rotten oranges
         */

        // EXPLANATION BFS:-
        /*
         * int[][] grid = { {2, 1, 1},
                           {1, 1, 0},
                           {0, 1, 1} };
queue = [(0, 0)]
First Iteration of the While Loop
Processing Point (0, 0):
point = (0, 0)
Loop over the 4 directions:
Direction 1 (Right):
x = 0 + 0 = 0, y = 0 + 1 = 1
grid[0][1] == 1 (fresh orange)
Rot the orange: grid[0][1] = 2
Add to queue: queue = [(0, 1)]
Direction 2 (Left):
x = 0 + 0 = 0, y = 0 - 1 = -1
Out of bounds, continue.
Direction 3 (Down):
x = 0 + 1 = 1, y = 0 + 0 = 0
grid[1][0] == 1 (fresh orange)
Rot the orange: grid[1][0] = 2
Add to queue: queue = [(0, 1), (1, 0)]
Direction 4 (Up):
x = 0 - 1 = -1, y = 0 + 0 = 0
Out of bounds, continue.
Updated grid:

java
Copy code
{ {2, 2, 1},
  {2, 1, 0},
  {0, 1, 1} }
Second Iteration of the While Loop
Processing Point (0, 1):
point = (0, 1)
Loop over the 4 directions:
Direction 1 (Right):
x = 0 + 0 = 0, y = 1 + 1 = 2
grid[0][2] == 1 (fresh orange)
Rot the orange: grid[0][2] = 2
Add to queue: queue = [(1, 0), (0, 2)]
Direction 2 (Left):
x = 0 + 0 = 0, y = 1 - 1 = 0
grid[0][0] == 2 (already rotten)
Continue.
Direction 3 (Down):
x = 0 + 1 = 1, y = 1 + 0 = 1
grid[1][1] == 1 (fresh orange)
Rot the orange: grid[1][1] = 2
Add to queue: queue = [(1, 0), (0, 2), (1, 1)]
Direction 4 (Up):
x = 0 - 1 = -1, y = 1 + 0 = 0
Out of bounds, continue.
Updated grid:

java
Copy code
{ {2, 2, 2},
  {2, 2, 0},
  {0, 1, 1} }
Processing Point (1, 0):
point = (1, 0)
Loop over the 4 directions:
Direction 1 (Right):
x = 1 + 0 = 1, y = 0 + 1 = 1
grid[1][1] == 2 (already rotten)
Continue.
Direction 2 (Left):
x = 1 + 0 = 1, y = 0 - 1 = -1
Out of bounds, continue.
Direction 3 (Down):
x = 1 + 1 = 2, y = 0 + 0 = 0
grid[2][0] == 0 (empty cell)
Continue.
Direction 4 (Up):
x = 1 - 1 = 0, y = 0 + 0 = 0
grid[0][0] == 2 (already rotten)
Continue.
Queue remains:

arduino
Copy code
queue = [(0, 2), (1, 1)]
Continue Iterations
Following this process, the remaining fresh oranges will be processed and eventually all oranges will become rotten or the queue will be empty. The number of minutes will be incremented accordingly until the process is complete.

By following this step-by-step process, the while loop ensures that all fresh oranges that can be reached by the rot will be processed and rotted, updating the grid and the queue dynamically.
* */
            while(!queue.isEmpty()) {  // queue ka itna kaam hai ki jo rotten hai usko queue me daalo aur uske chaaro neighbours bhi rotten krdo
                int size = queue.size();  // stack blocks size =  1 + 2 + 2 + 1 + 1 = 7 oranges
                cnt += size; // last me cnt = 7 ho jaaygi(mtlb humne 7 oranges rotten kiye hai)

                // NOTE:- yha se bfs shuru hua aur rottening ki kahani shuru hui
                // logic:- current node ke chaaro direction me jaao aur jo kabil hai usko rot kro aur queue me daalo
                for(int i = 0 ; i < size ; i++) {

                    // ye queue ke front ko  point array [ith, jth] banayga hum usi par  pehle traverse krenge isliye ye loop bnaya hai aur jo rot hote jaayga wo queue me front paraate jaayga...iss baat ka hee bfs hai aur main baat hum bfs use kr rhe hai isliye queue me 2 loop lge
                    int[] point = queue.poll();

                    for(int j = 0;j<4;j++) { //j = 4 kyoki 4 hee direction hai
                        assert point != null;  // ye kuch naya hai seekhna pdega iss line ko htake code try krna.
                        //isme ye sab ith row aur jth col hai jo matrix me hote hai aur point[] = [i=0, j=0] hai
                        int x = point[0] + dx[j];  // point[0] = ith position of node
                        int y = point[1] + dy[j];  // point[1] = jth position of node

                        // check range:-  between below and above the ith and jth which are 0, 1, 2
                        // (x < 0 and y < 0) = negative || (x >= rows and y >= cols) = above 2


                        // agar in chaaro mese koi bhi condition hui to grid[x][y] == 2 nhi krna
                        if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 ||
                                grid[x][y] == 2) continue;

                        grid[x][y] = 2;   // humne uska neighbour rotten krdia
                        queue.offer(new int[]{x , y}); // aur usko queue me daal dia taaki aur bhi rotten ho sake
                    }
                }
            if(!queue.isEmpty()) {
                countMin++;  // 4 baar queue khaali hua hai to 4 baar updation hoya hoga to ans = 4 minutes
                /*
                {2,1,1}      {2,"2",1}      {2,1,"2"}      {2,1,1}      {2,1,1}
                {1,1,0}  =>  {"2",1,0}  ->  {1,"2",0}  ->  {1,1,0}  ->  {1,1,0}
                {0,1,1}      {0,1,1}        {0,1,1}        {0,"2",1}    {0,1,"2"}
                * */
            }
        }

        return (count_fresh == cnt) ? countMin : -1;
    }
    public static void main(String[] args)
    {
        int[][] arr ={ {2,1,1} ,
                       {1,1,0} ,
                       {0,1,1} };
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required "+rotting);
    }
}

