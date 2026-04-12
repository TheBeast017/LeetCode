class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[27][27];
        
        for(int i = 0; i < 27; i++){
            for(int j = 0; j < 27; j++){
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }
    
        dp[26][26] = 0;
        
        for(int idx = 0; idx < n; idx++){
            int c = word.charAt(idx) - 'A';
            int[][] next = new int[27][27];
            
            for(int i = 0; i < 27; i++){
                for(int j = 0; j < 27; j++){
                    next[i][j] = Integer.MAX_VALUE / 2;
                }
            }
            for(int f1 = 0; f1 < 27; f1++){
                for(int f2 = 0; f2 < 27; f2++){
                    int cur = dp[f1][f2];
                    if (cur >= Integer.MAX_VALUE / 2) continue;
                    
                    int cost1 = cur + dist(f1, c);
                    next[c][f2] = Math.min(next[c][f2], cost1);
                    int cost2 = cur + dist(f2, c);
                    next[f1][c] = Math.min(next[f1][c], cost2);
                }
            }
            dp = next;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < 27; i++){
            for(int j = 0; j < 27; j++){
                res = Math.min(res, dp[i][j]);
            }
        }
        
        return res;
    }    
    private int dist(int a, int b){
        if(a == 26) return 0;
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
