class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0, max = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums2[j] >= nums1[i]){
                max = Math.max(max, j - i);
                j++;
            }else{
                i++;
            }
        }
        return max;
        
    }
}
