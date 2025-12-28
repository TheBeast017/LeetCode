class Solution {
    public int numberOfBeams(String[] bank) {
        int multi = 0;
        for(int i = 0, j = 1; j < bank.length; ){
            int val1 = getVal(bank[i]);
            int val2 = getVal(bank[j]);
            if(val1!=0){
                if(val2!=0){
                    multi+=(val1*val2);
                    i = j;
                    j++;
                }else j++;
            }else{
                if(val2!=0){
                    i = j;
                    j++;
                }else{
                    i++;
                    j++;
                }
            }
        }
        return multi;
    }
    public int getVal(String s){
        int count1 = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='1') count1++;
        }
        return count1;
    }
}