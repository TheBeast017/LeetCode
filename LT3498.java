class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += ((i + 1) * (27 - ((int)s.charAt(i) - 96)));
        }
        return sum;
    }
}
