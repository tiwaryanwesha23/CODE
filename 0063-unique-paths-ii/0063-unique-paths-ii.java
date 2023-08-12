class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        // init:
        for (int i = 0, j = 0; j < n; j++) {
            if (obstacleGrid[i][j] == 1) break;
            dp[i][j] = 1;
        }
        for (int i = 0, j = 0; i < m; i++) {
            if (obstacleGrid[i][j] == 1) break;
            dp[i][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}