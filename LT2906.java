class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int n = grid.length, m = grid[0].length;

        int[][] arr = new int[n][m];
        int size = n * m;

        int[] flat = new int[size];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                flat[i*m + j] = grid[i][j] % mod;
            }
        }

        int[] prefix = new int[size];
        int[] suffix = new int[size];

        prefix[0] = 1;
        for(int i = 1; i < size; i++){
            prefix[i] = (prefix[i-1] * flat[i-1]) % mod;
        }

        suffix[size-1] = 1;
        for(int i = size-2; i >= 0; i--){
            suffix[i] = (suffix[i+1] * flat[i+1]) % mod;
        }
        for(int i = 0; i < size; i++){
            arr[i/m][i%m] = (prefix[i] * suffix[i]) % mod;
        }
        return arr;
    }
}
