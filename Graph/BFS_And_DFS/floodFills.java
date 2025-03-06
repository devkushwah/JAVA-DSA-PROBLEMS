package Graph.BFS_And_DFS;

public class floodFills {
    private static void dfs(int row, int col,
                            int[][] ans,
                            int[][] modifyImage,
                            int newColor, int delRow[], int delCol[],
                            int sourceNode) {
        // color the source Node
        ans[row][col] = newColor;    // yaha par row aur col = ith aur jth position hai

        // size nikaalo taake baadme check krte time limit check kar sake
        int n = modifyImage.length;
        int m = modifyImage[0].length;

        // there are exactly 4 neighboursss
        for(int i = 0;i<4;i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            // check for valid coordinate
            // then check for same initial color and unvisited pixel
            if(nrow>=0 && nrow<n && ncol>=0 && ncol < m &&
                    // jo modifyImage ka node hai wohi sourceNode hai ya nhi ya galti se kisi or ko modify kar rahe
                    // hai && aur phe se visited na ho mtlb phle se colured na ho
                    modifyImage[nrow][ncol] == sourceNode && ans[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, modifyImage, newColor, delRow, delCol, sourceNode);
            }
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // get initial color
        int sourceNode = image[sr][sc];  // source node
        int[][] modifyImage = image;  //Return the modified image after performing the flood fill.

        // delta row and delta column for neighbours
        int[] delRow = {-1, 0, +1, 0}; //direction same as rotten oranges
        int[] delCol = {0, +1, 0, -1};
        dfs(sr, sc, modifyImage, image, newColor, delRow, delCol, sourceNode);
        return modifyImage;
    }
    public static void main(String[] args)
    {
        int[][] image =  {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        // row = 1, col = 1, newColor = 2
        int[][] ans = floodFill(image, 1, 1, 2);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}
