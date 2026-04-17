class Solution{
    public int minMirrorPairDistance(int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        int min=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                min=Math.min(min,i-map.get(nums[i]));
                if(min==1)return 1;
            }
            int rev=reverse(nums[i]);
            map.put(rev,i);
        }

        return min==Integer.MAX_VALUE?-1:min;
    }

    private int reverse(int x){
        int r=0;
        while(x>0){
            r=r*10+x%10;
            x/=10;
        }
        return r;
    }
}
