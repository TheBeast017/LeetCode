class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i % 2 == 0){
                    int shiftL = (j + k) % m;
                    if(mat[i][j] != mat[i][shiftL]) return false;
                } else {
                    int shiftR = ((j - k) % m + m) % m;
                    if(mat[i][j] != mat[i][shiftR]) return false;
                }
            }
        }
        return true;
    }
}
