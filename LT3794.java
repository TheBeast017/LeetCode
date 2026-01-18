class Solution {
    public String reversePrefix(String s, int k) {
        if(k==1) return s;
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < s.length(); i+=k) {
            int end = Math.min(i + k, s.length());
            String part = s.substring(i, end);
            build.append(new StringBuilder(part).reverse());
        }
        return build.toString();
    }
}
