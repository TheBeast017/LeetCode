class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance > 0) {
                    sb.append(c);
                }
                balance++;
            } else {
                balance--;
                if (balance > 0) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
