class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n-reverse(n));
    }
    private int reverse(int n){
        if(Math.log10(n)==0) return n;
        int rev = 0;
        while(n!=0){
            rev = (rev*10) + n%10;
            n /= 10;
        }
        return rev;
    }
}
