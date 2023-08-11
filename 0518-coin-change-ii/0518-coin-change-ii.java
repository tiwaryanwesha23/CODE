class Solution {
    public int change(int amount, int[] coins) {
         if (amount == 0) return 1;
        int[] dp = new int[amount + 1];
        dp[0] = 1; // for dp, not quite meaning full: 1 way to build 0 amount
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}