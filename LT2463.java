class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<Integer> slots = new ArrayList<>();
        for(int k = 0; k < factory.length; k++){
            int[] f = factory[k];
            for(int i = 0; i < f[1]; i++){
                slots.add(f[0]);
            }
        }
        
        int n = robot.size();
        int m = slots.size();
        
        long[][] dp = new long[n + 1][m + 1];
        long num = (long)1e18;
        
        for(int i = 1; i <= n; i++){
            Arrays.fill(dp[i], num);
        }
        
        for(int j = 0; j <= m; j++){
            dp[0][j] = 0;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = dp[i][j - 1];
                dp[i][j] = Math.min(dp[i][j],
                        dp[i - 1][j - 1] + Math.abs(robot.get(i - 1) - slots.get(j - 1)));
            }
        }
        
        return dp[n][m];
    }
}
