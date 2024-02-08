class Solution {
    public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, n);
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
        int t = (int) Math.sqrt(i);
        for (int j = 1; j <= t; j++) {
            int s = (int) Math.pow(j, 2);
            if (s <= i) {
                dp[i] = Math.min(dp[i], dp[i - s] + 1);
            }
        }
    }
    return dp[n];
}
}