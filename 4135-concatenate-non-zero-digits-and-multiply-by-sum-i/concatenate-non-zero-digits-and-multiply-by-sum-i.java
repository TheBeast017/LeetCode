class Solution {
    public long sumAndMultiply(int n) {
        long ans = 0, nN = 0;//, org = n;
        // boolean noZero = true;
        while (n != 0) {
            if (n % 10 != 0){
                ans += n % 10;
                nN = (nN * 10) + (n % 10);
            } //else noZero = false;
            n /= 10;
        }
        // if (noZero) return org * ans;
        return Integer.parseInt(new StringBuilder(String.valueOf(nN)).reverse().toString()) * ans;

    }
}