class Solution {
    public boolean checkOnesSegment(String s) {
        int c1 = 0, ca = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='1') c1++;
        }
        if(c1==1) return true;
        for(int i = 0; i < s.length()-1 ; i++){
                if(s.charAt(i)=='1' && s.charAt(i+1)=='1') ca++;
        }
        if(ca!=0) ca++;
        if(c1 == ca) return true;
        return false;
    }
}
