class Solution {
    public boolean isValid(String word) {
        if(word.length()<3) return false;
        boolean dl = true, co = false, v = false;
        String words = word.toLowerCase();
        for(int i =0 ; i < words.length(); i++){
            char c = words.charAt(i);
            if(!Character.isDigit(c) && !Character.isLetter(c)){
                return false;
            }else{
                if(!Character.isDigit(c)){
                    if(c=='a' || c=='e'|| c=='i' || c=='o'|| c=='u'){
                        v = true;
                    }else co = true;
                }
                
            }
        }
        return (dl && co) && v;
    }
}
