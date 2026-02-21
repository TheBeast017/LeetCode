class Solution{
    public String makeLargestSpecial(String s){
        if(s.length()<=2)return s;
        java.util.List<String> list=new java.util.ArrayList<>();
        int count=0,start=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')count++;
            else count--;
            if(count==0){
                String inner=makeLargestSpecial(s.substring(start+1,i));
                list.add("1"+inner+"0");
                start=i+1;
            }
        }
        list.sort(java.util.Collections.reverseOrder());
        StringBuilder sb=new StringBuilder();
        for(String str:list)sb.append(str);
        return sb.toString();
    }
}
