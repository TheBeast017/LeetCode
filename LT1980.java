class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = (int)(Math.pow(2, nums[0].length()));
        int[] arr = new int[n];
        for(int i = 0; i < nums.length; i++){
            int index = Integer.parseInt(nums[i], 2);
            arr[index] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(arr[i]==0){
                sb.append(Integer.toBinaryString(i));
                return getSameLength(sb, nums[0].length());
            }
        }
        return "";
    }
    public String getSameLength(StringBuilder sb, int l){
        if(sb.length()==l) return sb.toString();
        return getSameLength(sb.insert(0,"0"), l);
    }
}
