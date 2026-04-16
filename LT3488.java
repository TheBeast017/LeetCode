class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        for(int q = 0; q < queries.length; q++){
            int idx = queries[q];
            List<Integer> positions = indexMap.get(nums[idx]);
            
            if(positions.size() == 1){
                answer.add(-1);
                continue;
            }
            
            int pos = Collections.binarySearch(positions, idx);
            
            int prevPos = positions.get((pos - 1 + positions.size()) % positions.size());
            int nextPos = positions.get((pos + 1) % positions.size());
            
            int d1 = Math.min(Math.abs(idx - prevPos), n - Math.abs(idx - prevPos));
            int d2 = Math.min(Math.abs(idx - nextPos), n - Math.abs(idx - nextPos));
            
            answer.add(Math.min(d1, d2));
        }
        
        return answer;
    }
}
