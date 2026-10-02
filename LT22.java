class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> s = new ArrayList<>();
        Paren(s, n, 0, 0, "");
        return s;
    }
    public void Paren(List<String> s, int n, int no, int nc, String str){
        if(str.length()== 2*n){
            s.add(str);
            return;
        }
        if(no<n){
            Paren(s, n, no+1 , nc, str+"(");
        }
        if(no>nc){
            Paren(s, n, no , nc+1, str+")");
        }
    }
}
