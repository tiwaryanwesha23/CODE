class Solution {
    public int numOfArrays(int n, int m, int k) {
        //dp
        Integer[][][] dp = new Integer[n+1][m+1][k+1];
        return dfs(n,m,k,0,0,0,dp);
    }
    private int dfs(int n, int m, int k, int i, int curMax, int curCost, Integer[][][] dp){
        if(i==n){
            if(k == curCost) return 1;
            return 0;
        }
        if (dp[i][curMax][curCost] != null) return dp[i][curMax][curCost];
        int ans = 0;
        for(int num=1; num<=m; num++){
            int newCost = curCost;
            int newMax = curMax;
            if(num>curMax){
                newMax = num;
                newCost++;
            }
            if(newCost>k) break;
            ans += dfs(n, m, k, i + 1, newMax, newCost, dp);
            ans %= 1_000_000_007;
        }
        
        return dp[i][curMax][curCost] = ans;

    }
}