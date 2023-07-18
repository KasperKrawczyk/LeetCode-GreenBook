import java.util.*;

public class PacificAtlanticWaterFlow {

     public static final int[][] DIRS = new int[][] {
            new int[] {0, -1}, // E
            new int[] {-1, 0}, // N
            new int[] {0, 1},  // W
            new int[] {1, 0}   // S
    };

    public List<List<Integer>> pacificAtlanticSlow(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int height = heights.length;
        int width = heights[0].length;
        Stack<int[]> stack = new Stack<>();
        boolean[][] visited = new boolean[height][width];
        boolean reachedAtlantic = false;
        boolean reachedPacific = false;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                stack.push(new int[] {i, j});
                while (!stack.isEmpty()) {
                    int[] curCoords = stack.pop();
                    int curHeight = heights[curCoords[0]][curCoords[1]];
                    if (curCoords[0] == 0 || curCoords[1] == 0) {
                        reachedPacific = true;
                    }
                    if (curCoords[0] == height - 1 || curCoords[1] == width - 1) {
                        reachedAtlantic = true;
                    }
                    if (reachedAtlantic && reachedPacific) {
                        ans.add(new ArrayList<>(Arrays.asList(i, j)));
                        break;
                    }

                    for (int[] dir : DIRS) {
                        int neighborY = curCoords[0] + dir[0];
                        int neighborX = curCoords[1] + dir[1];
                        if (neighborY < 0
                                || neighborY >= height
                                || neighborX < 0
                                || neighborX >= width
                                || visited[neighborY][neighborX]) {
                            continue;
                        }

                        if (curHeight >= heights[neighborY][neighborX]) {
                            stack.push(new int[] {neighborY, neighborX});
                        }
                    }
                    visited[curCoords[0]][curCoords[1]] = true;

                }
                stack = new Stack<>();
                visited = new boolean[height][width];
                reachedAtlantic = false;
                reachedPacific = false;
            }
        }
        return ans;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int height = heights.length;
        int width = heights[0].length;
        boolean[][] canSeePacific = new boolean[height][width];
        boolean[][] canSeeAtlantic = new boolean[height][width];
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            dfs(heights, canSeePacific, i, 0, Integer.MIN_VALUE);
            dfs(heights, canSeeAtlantic, i, width - 1, Integer.MIN_VALUE);
        }

        for (int i = 0; i < width; i++) {
            dfs(heights, canSeePacific, 0, i, Integer.MIN_VALUE);
            dfs(heights, canSeeAtlantic, height - 1, i, Integer.MIN_VALUE);
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (canSeePacific[i][j] && canSeeAtlantic[i][j]) {
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, boolean[][] canSeeOcean, int y, int x, int prevHeight) {
        if (y >= heights.length || y < 0 || x >= heights[0].length || x < 0
                || heights[y][x] < prevHeight || canSeeOcean[y][x]) {
            return;
        }
        canSeeOcean[y][x] = true;
        dfs(heights, canSeeOcean, y, x - 1, heights[y][x]);
        dfs(heights, canSeeOcean, y - 1, x, heights[y][x]);
        dfs(heights, canSeeOcean, y, x + 1, heights[y][x]);
        dfs(heights, canSeeOcean, y + 1, x, heights[y][x]);
    }

}
