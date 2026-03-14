class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();
        if (n + m != s3.length()) return false;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;

        for (int j = 1; j <= m; j++)
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        for (int i = 1; i <= n; i++) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for(int j = 1; j <= m; j++){
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||  (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m];
    }
}
