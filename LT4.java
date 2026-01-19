class Solution {
    public double findMedianSortedArrays(int[] nums1,int[] nums2){
        nums1 = IntStream.concat(IntStream.of(nums1),IntStream.of(nums2)).toArray();
        Arrays.sort(nums1);
        if(nums1.length%2==0){
            return (double)(nums1[(nums1.length/2)-1] + nums1[(nums1.length/2)]) / 2;
        }
        return (double)(nums1[(nums1.length/2)]);
    }
}
