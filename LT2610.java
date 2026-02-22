class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<Integer> inner = new ArrayList<>();
        List<List<Integer>> outer = new ArrayList<>();
        int allZero = 0, i = 0;
        while(allZero!=nums.length){
            if(i < nums.length){
                if(nums[i] == 0){
                    i++;
                    continue;
                }
                if(inner.indexOf(nums[i])==-1){
                    inner.add(nums[i]);
                    nums[i] = 0;
                    allZero++;
                }
            }else{
                if(i == nums.length){
                    if(!inner.isEmpty()){
                        outer.add(new ArrayList<>(inner));
                        inner.clear();
                    }
                    i = 0;
                    continue;
                }
            }
            i++;
        }
        if(!inner.isEmpty()){
            outer.add(new ArrayList<>(inner));
        }
        return outer;
    }
}
