class Solution {
    Integer[] memo;
    public int maxSumAfterPartitioning(int[] A, int K) {
        if (A == null || A.length == 0) return 0;

        int n = A.length;
        memo = new Integer[n];
        return dfs(A, K, 0);
    }
    
    private int dfs(int[] A, int k, int index) {
        if (index >= A.length) return 0;
        if (memo[index] != null) return memo[index];
        
        int local = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for (int i = index; i < A.length && i < index + k; i++) {
            local = Math.max(local, A[i]);
            max = Math.max(max, local * (i - index + 1) + dfs(A, k, i + 1));
        }
        memo[index] = max;
        return max;
    }
}