class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.equals("0")) return 0;
        if (s.length() == 1) return 1;

        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) != '0' ? 1 : 0;
        dp[1] = s.charAt(1) != '0' ? dp[0] : 0;
        dp[1] += check(s, 1) ? 1 : 0;
        
        for (int i = 2; i < n; i++) {
            if (s.charAt(i) != '0') dp[i] = dp[i - 1]; // possible to decode with just letter at i
            if (check(s, i)) dp[i] += dp[i - 2]; // possible to decode with (i-1, i)
        }
        return dp[n - 1];
    }
    
    private boolean check(String s, int i) {
        int twoDigit = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
        return twoDigit <= 26 && twoDigit >= 10;
    }
}