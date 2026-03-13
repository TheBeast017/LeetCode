class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        long right = (long)1e18;
        long ans = right;
        while(left <= right){
            long mid = left + (right - left) / 2;
            if(canFinish(mid, mountainHeight, workerTimes)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
    public boolean canFinish(long time, int mountainHeight, int[] workerTimes){
        long total = 0;
        for(int t : workerTimes){
            long k = time / t;
            long x = (long)((Math.sqrt(1 + 8.0 * k) - 1) / 2);
            total += x;
            if(total >= mountainHeight)
                return true;
        }
        return false;
    }
}
