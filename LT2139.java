class Solution {
    public int minMoves(int target, int maxDoubles) {
        return moves(target, maxDoubles, 0);
    }
    public int moves(int target, int d, int s){
        if(d==0) return target+s-1;
        if(target==1) return s;
        if(target%2==0 && d>0){
            return moves(target/2, d-1, s+1);
        }
        return moves(target-1, d, s+1);
    }
}
