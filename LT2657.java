class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];
        for(int i = 0; i < ans.length; i++){
            int num = 0;
            for(int k = i; k >= 0; k--){
                for(int j = 0; j <= i; j++){
                    if(A[k]==B[j]){
                        num++;
                    }
                }
            }
            
            ans[i] = num;
        }
        return ans;
    }
}
