class Solution {
    public boolean checkDivisibility(int n) {
        int n1 = n;
        int sum = 0, prod = 1;
        while (n != 0) {
            sum += (n % 10);
            prod *= (n % 10);
            n /= 10;
        }
        sum += prod;
        return n1 % sum == 0;
    }
}
