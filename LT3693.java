class Solution {
    public int climbStairs(int n, int[] costs) {
        int s4;
        int s1 = 0 , s2 = 0 , s3 = 0;
        for(int i  = 0 ; i < n ; ++i){
            s4 = Math.min(1+costs[i]+s3,Math.min(4+costs[i]+s2,9+costs[i]+s1));
            s1 = s2;
            s2 = s3;
            s3 = s4;
        }
        return s4;
    }
}
