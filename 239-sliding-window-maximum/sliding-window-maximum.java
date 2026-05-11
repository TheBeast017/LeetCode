class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) return nums;

        int[] arr = new int[nums.length - k + 1];
        Deque<Integer> l = new ArrayDeque<>();
        int j = 0, index = 0;
        while(j < nums.length){
            while(!l.isEmpty() && l.peekFirst() <= j - k){
                l.pollFirst();
            }
            while(!l.isEmpty() && nums[l.peekLast()] < nums[j]){
                l.pollLast();
            }
            l.offerLast(j);

            if(j >= k - 1){
                arr[index++] = nums[l.peekFirst()];
            }
            j++;
        }
        return arr;
    }
}