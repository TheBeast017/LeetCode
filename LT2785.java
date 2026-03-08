class Solution{
    public String sortVowels(String s){
        List<Character> v = new ArrayList<>();
        for (char c : s.toCharArray()){
            if (isVowel(c)) v.add(c);
        }
        Collections.sort(v);
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (char c : s.toCharArray()){
            if (isVowel(c)) res.append(v.get(i++));
            else res.append(c);
        }
        return res.toString();
    }
    public boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
