class Solution {
    public boolean canWinNim(int n) {
        if(n<=3) return true;
        int rem = n/3;
        if(rem%2==0 && n%3!=0) return true;
        return false;
    }
}
