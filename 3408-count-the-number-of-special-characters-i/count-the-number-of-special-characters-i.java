class Solution {
    public int numberOfSpecialChars(String word) {
        int[] c = new int[128];//32, 65, 97
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch)){
                if(c[ch] == 0) c[ch]++;
            }
            else{
                if(c[ch] == 0) c[ch]++;
            }
            
        }
        for(int i = 97; i < 123; i++) if(c[i] == 1 && c [i-32] == 1) count++;
        return count;
    }
}