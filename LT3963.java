class Solution {
    public String[] createGrid(int m, int n) {
        List<String> l = new ArrayList<>();
        for(int i = 0; i < m; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(i==0 || j==n-1) sb.append('.');
                else sb.append('#');
            }
            l.add(sb.toString());
        }
        return l.toArray(new String[0]);
    }
}
