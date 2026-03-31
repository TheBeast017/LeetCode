class Solution {
    public int countNegatives(int[][] grid) {
        int c = 0;
        for(int[] i : grid){
            for(int j : i){
                if(j<0) c++;
            }
        }
        return c;
    }
}
