class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }
        int res = Integer.MAX_VALUE;
        
        for(List<Integer> list : map.values()){
            if(list.size() < 3) continue;
            for(int i = 0; i + 2 < list.size(); i++) {
                int dist = 2 * (list.get(i + 2) - list.get(i));
                res = Math.min(res, dist);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
