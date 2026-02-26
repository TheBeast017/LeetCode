class Solution {
    public int numSteps(String s) {
        // long n = Long.parseLong(s,2);
        // return countSteps(n,0);
        int steps = 0, carry = 0;
        for(int i = s.length()-1; i > 0; i-- ){
            int bit = (s.charAt(i) - '0') + carry;
            if(bit == 1){
                steps+=2;
                carry=1;
            }else{
                steps++;
            }
        }
        return (carry + steps);
    }
    // public int countSteps(long n , int c){
    //     if(n==1) return (int)(c);
    //     if(n%2==0) return countSteps(n/2, c+1);
    //     return countSteps(n+1, c+1);
    // }
}
