class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific: top row + left column
        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c);
        }

        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0);
        }

        // Atlantic: bottom row + right column
        for (int c = 0; c < cols; c++) {
            dfs(heights, atlantic, rows - 1, c);
        }

        for (int r = 0; r < rows; r++) {
            dfs(heights, atlantic, r, cols - 1);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    ans.add(Arrays.asList(r, c));
                }
            }
        }

        return ans;
    }

    public void dfs(int[][] heights, boolean[][] ocean,
                    int r, int c) {

        ocean[r][c] = true;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= heights.length ||
                nc < 0 || nc >= heights[0].length) {
                continue;
            }

            if (ocean[nr][nc]) {
                continue;
            }

            // Reverse flow:
            // neighbor must be >= current cell
            if (heights[nr][nc] >= heights[r][c]) {
                dfs(heights, ocean, nr, nc);
            }
        }
    }
}