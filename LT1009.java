class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int num = 0;
        for(int i = 0 ; n!=0 ; i++){
            if((n & 1)==0){
                num += (int)Math.pow(2,i);
            }
            n = n>>1;
        }
        return num;
    }
}
