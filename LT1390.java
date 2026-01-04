class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i =0; i< nums.length; i++) sum+=getSum(nums[i]);
        return sum;
    }
    public int getSum(int num){
        if(num < 6) return 0;
        int ans = num, count = 1;
        for(int j = 1 ; j <= num/2 && count <= 4; j++){
            if(num%j==0){
                ans+=j; count++;
            }
        }
        return (count == 4) ? ans : 0;
    }
}