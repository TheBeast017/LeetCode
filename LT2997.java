class Solution {
    public int minOperations(int[] nums, int k) {
        int n  = 0;
        for(int i = 0; i < nums.length; i++){
            n ^= nums[i];
        }
        if(n==k) return 0;
        int count = 0;
        while(n!=0 || k!=0){
            if((int)(n&1) != (int)(k&1)){
                count++;
            }
            n = n>>1;
            k = k>>1;
        }//0111, 1100
        return count;
    }
}
