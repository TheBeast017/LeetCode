class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int MAX = 1000000;
        int[] pos = new int[MAX];
        Arrays.fill(pos, -1);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num < MAX && pos[num] != -1) {
                min = Math.min(min, i - pos[num]);
            }
            int rev = reverse(num);
            if (rev < MAX) {
                pos[rev] = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int reverse(int x){
        int r = 0;
        while (x > 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }
}
