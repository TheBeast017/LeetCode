class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty()) return 0;
        int sign = 1, i = 0;
        if(s.charAt(i)=='-'){
            sign = -1;
            i++;
        }
        else{
            if(s.charAt(i)=='+') i++;
        }
        int result = 0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(!Character.isDigit(ch)) break;
            int character = ch - '0';
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && character > Integer.MAX_VALUE %10 )){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + character;
            i++;
        }
        return sign*result;
    }
}