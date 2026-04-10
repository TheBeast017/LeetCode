class Solution {
    public int minimumDistance(int[] nums){
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int minDist = Integer.MAX_VALUE;
        
        for(List<Integer> list : map.values()){
            if(list.size() < 3) continue;
            
            for(int i = 0; i + 2 < list.size(); i++){
                int a = list.get(i);
                int b = list.get(i + 1);
                int c = list.get(i + 2);
                
                int dist = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);
                minDist = Math.min(minDist, dist);
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
