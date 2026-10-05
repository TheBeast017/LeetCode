class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        return solve(s, 0, st);
    }

    private int solve(String s, int i, Stack<Integer> st) {
        if (i == s.length()) {
            return 0;
        }

        if (s.charAt(i) == '(') {
            st.push(0);
            return solve(s, i + 1, st);
        }

        int value = st.pop();

        if (value == 0) {
            value = 1;
        } else {
            value = 2 * value;
        }

        if (!st.isEmpty()) {
            int parent = st.pop();
            st.push(parent + value);
            return solve(s, i + 1, st);
        }

        return value + solve(s, i + 1, st);
    }
}
