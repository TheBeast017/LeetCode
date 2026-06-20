class Solution {
    public boolean areNumbersAscending(String s) {
        int prev = 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                int digit = s.charAt(i) + '0';
                i++;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    digit = (digit * 10) + (s.charAt(i) + '0');
                    i++;
                }
                if(prev >= digit) return false;
                else prev = digit;
            }
        }
        return true;
    }
}