class Solution{
    public int numIslands(char[][] grid){
        int m=grid.length,n=grid[0].length,c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    c++;
                }
            }
        }
        return c;
    }
    void dfs( char[][] g, int i, int j){
        if(i<0||j<0 || i>=g.length || j>=g[0].length || g[i][j]=='0') return;
        g[i][j]='0';
        dfs(g,i+1,j);
        dfs(g,i-1,j);
        dfs(g,i,j+1);
        dfs(g,i,j-1);
    }
}
