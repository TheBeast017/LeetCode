class Solution{
    int ans=Integer.MIN_VALUE;
    public int maxDotProduct(int[] a,int[] b){
    dfs(a,b,0,0,false,0);
        return ans;
    }
    void dfs(int[] a, int[] b, int i, int j, boolean used, int sum){
        if(i==a.length || j==b.length){
        if(used) ans=Math.max(ans,sum);
        return;
    }
    dfs(a, b, i+1, j, used, sum);
    dfs(a, b, i, j+1, used, sum);
    dfs(a, b, i+1, j+1, true, sum+a[i]*b[j]);
    }
}
