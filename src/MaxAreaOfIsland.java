import java.util.*;

public class MaxAreaOfIsland {
    public int maxArea = 0;
    public int[][] dirs = new int[][] {{0,-1},{0,1},{-1,0},{1,0}};
    public boolean[][] visited;
    public int[][] matrix;
    public int maxAreaOfIsland(int[][] grid) {
        matrix = grid;
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int  j = 0; j < m; j++){
                if(!visited[i][j] && grid[i][j] == 1){

                    maxArea = Math.max(maxArea, explore(i, j));
                }
            }
        }
        return maxArea;
    }

    private int explore(int i, int j){
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{i, j});

        int size = 0;

        while(!queue.isEmpty()){
            size++;
            int[] cur = queue.poll();
            int k = cur[0];
            int l = cur[1];
            visited[k][l] = true;
            for(int[] dir : dirs) {
                if (isValid(k + dir[0], l + dir[1])){
                    visited[k + dir[0]][l + dir[1]] = true;
                    queue.add(new int[] {k + dir[0], l + dir[1]});
                }

            }
        }

        return size;
    }

    private boolean isValid(int k, int l){
        return k >= 0 && k < matrix.length &&
                l >= 0 && l < matrix[0].length &&
                !visited[k][l] && matrix[k][l] == 1;
    }
}
