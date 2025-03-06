package Graph.BFS_And_DFS;

public class replace_0_with_X {
    static void dfs(int row, int col, int[][] vis,
                    char[][] mat, int[] delrow, int[] delcol) {

        vis[row][col] = 1;  // jo element aayga usko visited krenge
        int n = mat.length; // ye row ki length nikaal li
        int m = mat[0].length; // ye column ki length nikaal li

        // check for top, right, bottom, left
        // jo element aaya hai uske chaaro direction me bhi jaaynge kyki dfs() hai agar koi neighbour bhi 0's hai to
        // uska bhi dfs() chalaynge aur usko bhi visited krenge
        for(int i = 0;i<4;i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            // check karrahe hai kii chaaro direction me jaate jaate kahi bhatak to nhi gaye...agar nhi bhatke aur
            // current element ka neighbour bhi 0 hai to dfs() laga do
            if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m
                    && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, mat, delrow, delcol);
            }
        }
    }

    static char[][] fill(int n, int m, char[][] mat)
    {
        // ye rhi chaaro direction jisse hum matrix me current element ke chaaro direction me jaaynge
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, 1, 0, -1};

        // ye bna lia ek khaali matrix
        int[][] vis = new int[n][m];

        // sabse phle hum traverse krenge first row and last row check kro 2 if conditions hai
        for(int j = 0 ; j<m;j++) {
            // check karo agar first aur last row boundry me koi unvisited 0's mil jaay to usko dfs() chala kar
            // visited kardo
            // first row
            if(vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, delrow, delcol);
            }

            // check karo agar first aur last row boundary me koi unvisited 0's mil jaay to usko dfs() chala kar
            // visited kardo
            // last row
            if(vis[n-1][j] == 0 && mat[n-1][j] == 'O') {
                dfs(n-1,j,vis,mat, delrow, delcol);
            }
        }

        for(int i = 0;i<n;i++) {
            // check for unvisited Os in the boundary columns
            // first column
            if(vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, delrow, delcol);
            }

            // last column
            if(vis[i][m-1] == 0 && mat[i][m-1] == 'O') {
                dfs(i, m-1, vis, mat, delrow, delcol);
            }
        }

        // humne boundary waale 0 sabko visited kardia hai ab wo kisiki kaam ke nhi hai isliye jo boundary me nhi hai
        // joki matrix ke bich me unko 'X' me convert krenge aur fir matrix return krenge
        //NOTE:- Jo boundary par hai wo 'X' ke sath replace nhi hoyega sirf bichke honge
        for(int i = 0;i<n;i++) {
            for(int j= 0 ;j<m;j++) {
                if(vis[i][j] == 0 && mat[i][j] == 'O')
                    mat[i][j] = 'X';
            }
        }

        return mat;
    }
    public static void main(String[] args)
    {
        char[][] mat = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}
        };

        // n = 5, m = 4

        char[][] ans = fill(5, 4, mat);
        for(int i = 0;i < 5;i++) {
            for(int j = 0;j < 4;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
