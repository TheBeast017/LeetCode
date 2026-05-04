class Solution {
    public void rotate(int[][] matrix) {
        // first transpose the given matrix
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if( i < j ){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        // reverse the array

        for(int i = 0; i < n; i++){
            int start = 0, end = n-1;
            while (start < end ){
                int temp = matrix[i][start];
                matrix[i][start++] = matrix[i][end];
                matrix[i][end--] = temp;
                
            }
        }
    }
}
